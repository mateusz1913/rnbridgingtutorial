package com.sampleeventmodule

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule

/**
 * Declare Kotlin class for old arch native module implementation
 *
 * Each native module extends ReactContextBaseJavaModule class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleScreenOrientationModule.NAME)
class SampleScreenOrientationModule(
  // Each native module class consumes react application context
  reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {
  // Use shared module implementation and forward react application context
  private val moduleImpl = SampleScreenOrientationModuleImpl(reactContext)

  // Return the name of the module - it should match the name provided in JS specification
  override fun getName() = SampleScreenOrientationModuleImpl.NAME

  override fun initialize() {
    super.initialize()
    moduleImpl.onInitialize()
  }

  override fun invalidate() {
    moduleImpl.onInvalidate()
    super.invalidate()
  }

  override fun getConstants(): MutableMap<String, Any> {
    return mutableMapOf(
      PORTRAIT to PORTRAIT,
      LANDSCAPE to LANDSCAPE
    )
  }

  @ReactMethod
  fun addListener(eventName: String?) = Unit

  @ReactMethod
  fun removeListeners(count: Double) = Unit

  companion object {
    const val PORTRAIT = "PORTRAIT"
    const val LANDSCAPE = "LANDSCAPE"
    const val NAME = SampleScreenOrientationModuleImpl.NAME
  }
}
