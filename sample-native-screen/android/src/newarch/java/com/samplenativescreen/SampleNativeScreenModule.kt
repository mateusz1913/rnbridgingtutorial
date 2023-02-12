package com.samplenativescreen

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

/**
 * Declare Kotlin class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleNativeScreenModule.NAME)
class SampleNativeScreenModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : NativeSampleNativeScreenModuleSpec(reactContext) {
    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = SampleNativeScreenModuleImpl.NAME

    override fun initialize() {
        super.initialize()
        SampleNativeScreenModuleImpl.setReactApplicationContext(reactApplicationContext)
    }

    // Exported methods are overriden - based on the spec class
    override fun launchNativeScreen(valueFromJS: String) = SampleNativeScreenModuleImpl.launchNativeScreen(valueFromJS)

    override fun addListener(eventName: String?) = Unit

    override fun removeListeners(count: Double) = Unit

    companion object {
        const val NAME = SampleNativeScreenModuleImpl.NAME
    }
}
