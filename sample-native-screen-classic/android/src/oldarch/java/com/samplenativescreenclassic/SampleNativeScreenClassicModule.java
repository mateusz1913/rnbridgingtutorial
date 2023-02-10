package com.samplenativescreenclassic;

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
@ReactModule(name = SampleNativeScreenClassicModule.NAME)
public class SampleNativeScreenClassicModule extends ReactContextBaseJavaModule {
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
    SampleNativeScreenModuleImpl.setReactApplicationContext(getReactApplicationContext());
  }

  // Exported methods must be annotated with @ReactMethod decorator
  @ReactMethod
  public void launchNativeScreen(String valueFromJS) {
    SampleNativeScreenModuleImpl.launchNativeScreen(valueFromJS);
  }

  @ReactMethod
  public void addListener(String eventName) {}

  @ReactMethod
  public void removeListeners(double count) {}
}
