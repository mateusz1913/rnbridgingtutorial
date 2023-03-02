package com.savefilepickerpackageclassic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;

/**
 * Native module's shared implementation
 */
public class SaveFilePickerClassicModuleImpl {
    interface SaveFilePickerClassicListener {
        void onSuccess(@Nullable Uri uri);
        void onCancel();
        void onError(Exception error);
    }
    private final ReactApplicationContext reactContext;
    public static final String NAME = "SaveFilePickerClassicModule";

    private static @Nullable ActivityResultLauncher<Intent> activityLauncher = null;

    public static @Nullable SaveFilePickerClassicListener listener = null;

    public static void registerActivityLauncher(AppCompatActivity activity) {
        activityLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                if (listener != null) {
                    Intent data = result.getData();
                    Uri uri = null;
                    if (data != null) {
                        uri = data.getData();
                    }
                    listener.onSuccess(uri);
                }
            } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                if (listener != null) {
                    listener.onCancel();
                }
            } else {
                if (listener != null) {
                    listener.onError(new Exception("Unknown result when saving the file"));
                }
            }
        });
    }

    public SaveFilePickerClassicModuleImpl(ReactApplicationContext reactContext) {
        this.reactContext = reactContext;
    }

    public void saveFile(String filename) {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_TITLE, filename);

        ActivityResultLauncher<Intent> launcher = activityLauncher;
        if (launcher == null) {
            if (listener != null) {
                listener.onError(new Exception("Activity launcher not registered"));
            }
            return;
        }

        UiThreadUtil.runOnUiThread(() -> {
            launcher.launch(intent);
        });
    }
}
