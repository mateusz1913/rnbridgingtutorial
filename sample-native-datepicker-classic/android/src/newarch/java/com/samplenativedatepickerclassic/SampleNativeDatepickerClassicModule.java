package com.samplenativedatepickerclassic;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

/**
 * Declare Java class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleNativeDatepickerClassicModule.NAME)
public class SampleNativeDatepickerClassicModule extends NativeSampleNativeDatepickerClassicModuleSpec {
    public static final String NAME = SampleNativeDatepickerClassicModuleImpl.NAME;

    // Use shared module implementation and forward react application context
    private final SampleNativeDatepickerClassicModuleImpl moduleImpl;

    public SampleNativeDatepickerClassicModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.moduleImpl = new SampleNativeDatepickerClassicModuleImpl(reactContext);
    }

    // Return the name of the module - it should match the name provided in JS specification
    @Override
    public String getName() {
        return SampleNativeDatepickerClassicModuleImpl.NAME;
    }

    // Exported methods are overriden - based on the spec class
    @Override
    public void showRangeDatepickerWithCallback(String title, Callback callback) {
        moduleImpl.showRangeDatepickerWithCallback(title, callback);
    }

    @Override
    public void showRangeDatepickerWithPromise(ReadableMap config, Promise promise) {
        moduleImpl.showRangeDatepickerWithPromise(config, promise);
    }
}
