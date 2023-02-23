package com.appinfopackageclassic;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;

/**
 * Native module's shared implementation
 */
public class AppInfoModuleClassicImpl {
    private final ReactApplicationContext reactContext;

    public static final String NAME = "AppInfoModuleClassic";

    public AppInfoModuleClassicImpl(ReactApplicationContext reactContext) {
        this.reactContext = reactContext;
    }

    public String getAppBuildNumber() {
        String buildNumber = "unknown";
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                buildNumber = Long.toString(getPackageInfo().getLongVersionCode());
            } else {
                buildNumber = Long.toString(getPackageInfo().versionCode);
            }
        } catch (Exception ignored) {}

        return buildNumber;
    }

    public String getAppBundleId() {
        return reactContext.getPackageName();
    }

    public String getAppVersion() {
        String appVersion = "unknown";
        try {
            appVersion = getPackageInfo().versionName;
        } catch (Exception ignored) {}
        return appVersion;
    }

    private PackageInfo getPackageInfo() throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return reactContext
                .getPackageManager()
                .getPackageInfo(
                        reactContext.getPackageName(),
                        PackageManager.PackageInfoFlags.of(0L)
                );
        } else {
            return reactContext
                .getPackageManager()
                .getPackageInfo(reactContext.getPackageName(), 0);
        }
    }
}
