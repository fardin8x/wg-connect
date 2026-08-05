package com.wgconnect.app.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Android Keystore hardware-backed encryption helper for secure WireGuard private keys.
 */
class CryptoManager(context: Context) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptedPrefs = EncryptedSharedPreferences.create(
        context,
        "secure_wg_configs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveEncryptedPrivateKey(configId: String, privateKey: String) {
        encryptedPrefs.edit().putString("priv_$configId", privateKey).apply()
    }

    fun getEncryptedPrivateKey(configId: String): String? {
        return encryptedPrefs.getString("priv_$configId", null)
    }
}
