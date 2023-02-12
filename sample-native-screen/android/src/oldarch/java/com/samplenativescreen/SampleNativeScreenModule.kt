package com.samplenativescreen

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
@ReactModule(name = SampleNativeScreenModule.NAME)
class SampleNativeScreenModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {
    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = SampleNativeScreenModuleImpl.NAME

    override fun initialize() {
        super.initialize()
        SampleNativeScreenModuleImpl.setReactApplicationContext(reactApplicationContext)
    }

    // Exported methods must be annotated with @ReactMethod decorator
    @ReactMethod
    fun launchNativeScreen(valueFromJS: String) = SampleNativeScreenModuleImpl.launchNativeScreen(valueFromJS)

    @ReactMethod
    fun addListener(eventName: String?) = Unit

    @ReactMethod
    fun removeListeners(count: Double) = Unit

    companion object {
        const val NAME = SampleNativeScreenModuleImpl.NAME
    }
}
