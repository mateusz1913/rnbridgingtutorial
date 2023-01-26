package com.samplenativemoduleclassic;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Declare Java class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleAppInfoClassicModule.NAME)
public class SampleAppInfoClassicModule extends NativeSampleAppInfoClassicModuleSpec {
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

  // Exported methods are overriden - based on the spec class
  @Override
  public String getAppBuildNumber() {
    return moduleImpl.getAppBuildNumber();
  }

  @Override
  public String getAppBundleId() {
    return moduleImpl.getAppBundleId();
  }

  @Override
  public String getAppVersion() {
    return moduleImpl.getAppVersion();
  }
}
