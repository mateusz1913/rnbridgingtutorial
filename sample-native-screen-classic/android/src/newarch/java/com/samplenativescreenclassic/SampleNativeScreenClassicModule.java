package com.samplenativescreenclassic;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Declare Java class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleNativeScreenClassicModule.NAME)
public class SampleNativeScreenClassicModule extends NativeSampleNativeScreenClassicModuleSpec {
  public static final String NAME = SampleNativeScreenClassicModuleImpl.NAME;

  public SampleNativeScreenClassicModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  // Return the name of the module - it should match the name provided in JS specification
  @Override
  public String getName() {
    return SampleNativeScreenClassicModuleImpl.NAME;
  }

  @Override
  public void initialize() {
    super.initialize();
    SampleNativeScreenClassicModuleImpl.setReactApplicationContext(getReactApplicationContext());
  }

  // Exported methods are overriden - based on the spec class
  @Override
  public void launchNativeScreen(String valueFromJS) {
    SampleNativeScreenClassicModuleImpl.launchNativeScreen(valueFromJS);
  }

  @Override
  public void addListener(String eventName) {}

  @Override
  public void removeListeners(double count) {}
}
