package com.wgconnect.app.vpn

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import android.util.Log
import com.wgconnect.app.domain.model.TunnelState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WgTunnelService : VpnService() {

    companion object {
        private const val TAG = "WgTunnelService"
        val tunnelState = MutableStateFlow(TunnelState.DISCONNECTED)
        val rxBytesFlow = MutableStateFlow(0L)
        val txBytesFlow = MutableStateFlow(0L)
    }

    private var vpnInterface: ParcelFileDescriptor? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        if (action == "ACTION_DISCONNECT") {
            stopTunnel()
            return START_NOT_STICKY
        }

        startTunnel()
        return START_STICKY
    }

    private fun startTunnel() {
        try {
            tunnelState.value = TunnelState.CONNECTING

            val builder = Builder()
                .addAddress("10.8.0.2", 32)
                .addDnsServer("1.1.1.1")
                .addRoute("0.0.0.0", 0)
                .setMtu(1420)

            vpnInterface = builder.establish()
            tunnelState.value = TunnelState.CONNECTED
            Log.i(TAG, "WireGuard Tunnel established successfully.")

        } catch (e: Exception) {
            Log.e(TAG, "Error starting tunnel", e)
            tunnelState.value = TunnelState.DISCONNECTED
        }
    }

    private fun stopTunnel() {
        tunnelState.value = TunnelState.DISCONNECTING
        try {
            vpnInterface?.close()
            vpnInterface = null
        } catch (e: Exception) {
            Log.e(TAG, "Error closing interface", e)
        }
        tunnelState.value = TunnelState.DISCONNECTED
        stopSelf()
    }

    override fun onDestroy() {
        stopTunnel()
        super.onDestroy()
    }
}
