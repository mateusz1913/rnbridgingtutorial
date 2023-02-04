package com.sampleeventmoduleclassic;

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
@ReactModule(name = SampleScreenOrientationClassicModule.NAME)
public class SampleScreenOrientationClassicModule extends NativeSampleScreenOrientationClassicModuleSpec {
  public static final String PORTRAIT = "PORTRAIT";
  public static final String LANDSCAPE = "LANDSCAPE";
  public static final String NAME = SampleScreenOrientationClassicModuleImpl.NAME;

  // Use shared module implementation and forward react application context
  private final SampleScreenOrientationClassicModuleImpl moduleImpl;

  public SampleScreenOrientationClassicModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.moduleImpl = new SampleScreenOrientationClassicModuleImpl(reactContext);
  }

  // Return the name of the module - it should match the name provided in JS specification
  @Override
  public String getName() {
    return SampleScreenOrientationClassicModuleImpl.NAME;
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
