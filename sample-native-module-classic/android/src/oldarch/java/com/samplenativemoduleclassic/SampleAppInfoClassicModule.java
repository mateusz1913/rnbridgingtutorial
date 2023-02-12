package com.samplenativemoduleclassic;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Declare Java class for old arch native module implementation
 *
 * Each native module extends ReactContextBaseJavaModule class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleAppInfoClassicModule.NAME)
public class SampleAppInfoClassicModule extends ReactContextBaseJavaModule {
    public static final String NAME = SampleAppInfoClassicModuleImpl.NAME;

    // Use shared module implementation and forward react application context
    private final SampleAppInfoClassicModuleImpl moduleImpl;

    public SampleAppInfoClassicModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.moduleImpl = new SampleAppInfoClassicModuleImpl(reactContext);
    }

    // Return the name of the module - it should match the name provided in JS specification
    @Override
    public String getName() {
        return SampleAppInfoClassicModuleImpl.NAME;
    }

    // Exported methods must be annotated with @ReactMethod decorator
    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getAppBuildNumber() {
        return moduleImpl.getAppBuildNumber();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getAppBundleId() {
        return moduleImpl.getAppBundleId();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getAppVersion() {
        return moduleImpl.getAppVersion();
    }
}
