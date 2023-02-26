package com.rangedatepickerpackageclassic;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Declare Java class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = RangeDatePickerClassicModule.NAME)
public class RangeDatePickerClassicModule extends NativeRangeDatePickerClassicModuleSpec {
    public static final String NAME = RangeDatePickerClassicModuleImpl.NAME;

    // Use shared module implementation and forward react application context
    private final RangeDatePickerClassicModuleImpl moduleImpl;

    public RangeDatePickerClassicModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.moduleImpl = new RangeDatePickerClassicModuleImpl(reactContext);
    }

    // Return the name of the module - it should match the name provided in JS specification
    @Override
    public String getName() {
        return NAME;
    }

    // Exported methods are overriden - based on the spec class
    @Override
    public void showRangeDatePickerWithCallback(String title, Callback callback) {
        moduleImpl.showRangeDatePickerWithCallback(title, callback);
    }

    @Override
    public void showRangeDatePickerWithPromise(ReadableMap config, Promise promise) {
        moduleImpl.showRangeDatePickerWithPromise(config, promise);
    }
}
