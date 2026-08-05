package com.wgconnect.app.domain.model

data class WgInterface(
    val privateKey: String,
    val publicKey: String,
    val address: String,
    val dns: String,
    val mtu: Int = 1420
)

data class WgPeer(
    val publicKey: String,
    val presharedKey: String? = null,
    val endpoint: String,
    val allowedIPs: String = "0.0.0.0/0, ::/0",
    val persistentKeepalive: Int = 25
)

data class WgConfig(
    val id: String,
    val name: String,
    val wgInterface: WgInterface,
    val wgPeer: WgPeer,
    val isDefault: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
