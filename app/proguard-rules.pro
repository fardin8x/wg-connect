# WireGuard Android Native GoBackend Keep Rules
-keep class com.wireguard.android.backend.** { *; }
-keepclassmembers class com.wireguard.android.backend.** { *; }

# Security Crypto & DataStore
-keep class androidx.security.crypto.** { *; }

# Compose Material 3
-keep class androidx.compose.material3.** { *; }
