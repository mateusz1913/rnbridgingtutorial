package com.screenorientationpackageclassic;

import com.facebook.react.bridge.ReactApplicationContext;
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
@ReactModule(name = ScreenOrientationClassicModule.NAME)
public class ScreenOrientationClassicModule extends NativeScreenOrientationClassicModuleSpec {
    public static final String PORTRAIT = "PORTRAIT";
    public static final String LANDSCAPE = "LANDSCAPE";
    public static final String NAME = ScreenOrientationClassicModuleImpl.NAME;

    // Use shared module implementation and forward react application context
    private final ScreenOrientationClassicModuleImpl moduleImpl;

    public ScreenOrientationClassicModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.moduleImpl = new ScreenOrientationClassicModuleImpl(reactContext);
    }

    // Return the name of the module - it should match the name provided in JS specification
    @Override
    public String getName() {
        return ScreenOrientationClassicModuleImpl.NAME;
    }

    @Override
    public void initialize() {
        super.initialize();
        moduleImpl.onInitialize();
    }

    @Override
    public void invalidate() {
        moduleImpl.onInvalidate();
        super.invalidate();
    }

    @Override
    protected Map<String, Object> getTypedExportedConstants() {
        final Map<String, Object> map = new HashMap<>();
        map.put(PORTRAIT, PORTRAIT);
        map.put(LANDSCAPE, LANDSCAPE);
        return map;
    }

    @Override
    public void addListener(String eventName) {}

    @Override
    public void removeListeners(double count) {}
}
