package com.wgconnect.app.domain.model

enum class SplitMode {
    DISABLED,
    INCLUDE,
    EXCLUDE
}

data class SplitTunnelApp(
    val packageName: String,
    val appName: String,
    val isSystemApp: Boolean,
    val isSelected: Boolean = false
)
