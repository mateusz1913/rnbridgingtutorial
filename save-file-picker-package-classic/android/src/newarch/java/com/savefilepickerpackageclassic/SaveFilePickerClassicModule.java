package com.savefilepickerpackageclassic;

import android.net.Uri;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Declare Java class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SaveFilePickerClassicModule.NAME)
public class SaveFilePickerClassicModule extends NativeSaveFilePickerClassicModuleSpec {
    public static final String NAME = SaveFilePickerClassicModuleImpl.NAME;

    // Use shared module implementation and forward react application context
    private final SaveFilePickerClassicModuleImpl moduleImpl;

    private @Nullable Callback callbackBlock = null;
    private @Nullable Promise promiseBlock = null;
    private String sourceFilename = "";

    public SaveFilePickerClassicModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.moduleImpl = new SaveFilePickerClassicModuleImpl(reactContext);
        SaveFilePickerClassicModuleImpl.listener = new SaveFilePickerClassicModuleImpl.SaveFilePickerClassicListener() {
            @Override
            public void onSuccess(@Nullable Uri uri) {
                try {
                    InputStream sourceInputStream = reactContext
                        .getApplicationContext()
                        .getAssets()
                        .open(sourceFilename);
                    if (uri != null) {
                        OutputStream outputStream = reactContext
                            .getContentResolver()
                            .openOutputStream(uri);
                        byte[] buffer = new byte[8 * 1024];
                        int bytes = sourceInputStream.read(buffer);
                        while (bytes >= 0) {
                            outputStream.write(buffer, 0, bytes);
                            bytes = sourceInputStream.read(buffer);
                        }
                        outputStream.close();
                    }
                    sourceInputStream.close();
                } catch (Exception ignored) {}

                Callback callback = callbackBlock;
                Promise promise = promiseBlock;

                if (callback != null) {
                    WritableMap payload = Arguments.createMap();
                    payload.putBoolean("success", true);
                    payload.putBoolean("cancelled", false);
                    callback.invoke(payload);
                } else if (promise != null) {
                    promise.resolve(true);
                }

                callbackBlock = null;
                promiseBlock = null;
                sourceFilename = "";
            }

            @Override
            public void onCancel() {
                Callback callback = callbackBlock;
                Promise promise = promiseBlock;

                if (callback != null) {
                    WritableMap payload = Arguments.createMap();
                    payload.putBoolean("success", false);
                    payload.putBoolean("cancelled", true);
                    callback.invoke(payload);
                } else if (promise != null) {
                    promise.resolve(false);
                }

                callbackBlock = null;
                promiseBlock = null;
                sourceFilename = "";
            }

            @Override
            public void onError(Exception error) {
                Callback callback = callbackBlock;
                Promise promise = promiseBlock;

                if (callback != null) {
                    WritableMap payload = Arguments.createMap();
                    WritableMap errorMap = Arguments.createMap();
                    errorMap.putInt("code", 1234);
                    errorMap.putString("message", error.getMessage());
                    payload.putMap("error", errorMap);
                    payload.putBoolean("success", false);
                    payload.putBoolean("cancelled", false);
                    callback.invoke(payload);
                } else if (promise != null) {
                    promise.reject("1234", error.getMessage());
                }

                callbackBlock = null;
                promiseBlock = null;
                sourceFilename = "";
            }
        };
    }

    // Return the name of the module - it should match the name provided in JS specification
    @Override
    public String getName() {
        return SaveFilePickerClassicModuleImpl.NAME;
    }

    // Exported methods are overriden - based on the spec class

    @Override
    public void saveFileWithCallback(String filename, Callback callback) {
        callbackBlock = callback;
        sourceFilename = filename;
        moduleImpl.saveFile(filename);
    }

    @Override
    public void saveFileWithPromise(String filename, Promise promise) {
        promiseBlock = promise;
        sourceFilename = filename;
        moduleImpl.saveFile(filename);
    }
}
