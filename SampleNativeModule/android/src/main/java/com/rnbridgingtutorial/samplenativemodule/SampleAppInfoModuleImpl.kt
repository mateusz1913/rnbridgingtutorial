package com.rnbridgingtutorial.samplenativemodule

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

/**
 * Native module's shared implementation
 */
class SampleAppInfoModuleImpl(
    private val reactContext: ReactApplicationContext
) {
    fun getAppBuildNumber(): String {
        var buildNumber = "unknown"
        try {
            buildNumber = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                getPackageInfo().longVersionCode.toString()
            } else {
                @Suppress("DEPRECATION")
                getPackageInfo().versionCode.toString()
            }
        } catch (_: Exception) {}
        return buildNumber
    }

    fun getAppBundleId() = reactContext.packageName as String

    fun getAppVersion(): String {
        var appVersion = "unknown"
        try {
            appVersion = getPackageInfo().versionName
        } catch (_: Exception) {}
        return appVersion
    }

    private fun getPackageInfo(): PackageInfo {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            reactContext
                .packageManager
                .getPackageInfo(
                    reactContext.packageName,
                    PackageManager.PackageInfoFlags.of(0L)
                )
        } else {
            @Suppress("DEPRECATION")
            reactContext
                .packageManager
                .getPackageInfo(reactContext.packageName, 0)
        }
    }

    companion object {
        const val NAME = "SampleAppInfoModule"
    }
}
