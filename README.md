# WG Connect - WireGuard Android Client

[![Android CI/CD](https://github.com/wgconnect/app/actions/workflows/android_release.yml/badge.svg)](https://github.com/wgconnect/app/actions)
![Min SDK](https://img.shields.io/badge/Min%20SDK-26%20(Android%208.0)-blue)
![Target SDK](https://img.shields.io/badge/Target%20SDK-34%20(Android%2014)-green)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.23-purple)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-orange)

## 🚀 Overview
**WG Connect** is a high-performance, standalone WireGuard VPN client built natively for Android using **Kotlin**, **Jetpack Compose (Material 3)**, and **Clean Architecture + MVVM**.

### 🌟 Key Features
- **Standalone WireGuard Engine**: Direct Tunnel creation via official `com.wireguard.android:tunnel` SDK (No WireGuard official app dependency).
- **Comprehensive Profile Management**:
  - Import `.conf` files
  - Paste text configuration
  - Camera QR Code scanner & QR generator
  - System Share Menu intent handler
  - Multiple profiles storage, edit, rename, duplicate & default selector
  - Backup & Restore (.json / .conf zip)
- **Split Tunneling**:
  - Mode 1: *Include Only* selected apps
  - Mode 2: *Exclude* selected apps from VPN
  - Installed apps list with search & category filtering
- **Connection Controls**:
  - Auto-Connect on App Launch
  - Auto Reconnect on Network Drop
  - Kill Switch (Block non-VPN traffic)
  - Start on Device Boot
  - Persistent Status Bar Notification with quick disconnect
- **Security & Hardware Encryption**:
  - Android Keystore AES-256-GCM hardware key protection for private keys
  - Biometric Fingerprint / Device PIN Lock
- **Real-time Metrics**:
  - Ping latency, live upload/download speed, total bandwidth counters, connection duration.

## 🛠️ Building from Source
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/WG-Connect.git
   cd WG-Connect
   ```
2. Open in **Android Studio Hedgehog** or newer.
3. Sync Gradle project.
4. Run on Android device or emulator (API 26+).

## 📄 License
MIT License. Created for WG Connect Project.
