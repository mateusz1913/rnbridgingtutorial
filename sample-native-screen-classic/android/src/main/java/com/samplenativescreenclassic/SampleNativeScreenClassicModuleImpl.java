package com.samplenativescreenclassic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Native module's shared implementation
 */
public class SampleNativeScreenClassicModuleImpl {
    public static final String NAME = "SampleNativeScreenClassicModule";
    private static final String EVENT_NAME = "onResultClassic";
    private static @Nullable ReactApplicationContext reactContext = null;
    private static @Nullable ActivityResultLauncher<Intent> activityLauncher = null;

    public static void setReactApplicationContext(ReactApplicationContext context) {
        reactContext = context;
    }

    public static void registerActivityLauncher(AppCompatActivity activity) {
        activityLauncher = activity.registerForActivityResult(new StartActivityForResult(), result -> {
            ReactApplicationContext context = reactContext;
            if (context == null) {
                return;
            }
            WritableMap payload = Arguments.createMap();
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                    boolean success = data.getBooleanExtra("success", false);
                    payload.putBoolean("success", success);
                    if (success) {
                        payload.putString("text", data.getStringExtra("text"));
                    }
                } else {
                    payload.putBoolean("success", false);
                }
            } else {
                payload.putBoolean("success", false);
            }
            context
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(EVENT_NAME, payload);
        });
    }

    public static void launchNativeScreen(String valueFromJS) {
        ActivityResultLauncher<Intent> launcher = activityLauncher;
        ReactApplicationContext context = reactContext;
        if (launcher == null || context == null) {
            return;
        }
        Intent intent = new Intent(context, SampleNativeClassicActivity.class);
        intent.putExtra("headerText", valueFromJS);
        UiThreadUtil.runOnUiThread(() -> launcher.launch(intent));
    }
}
