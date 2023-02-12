package com.samplenativedatepicker

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule

/**
 * Declare Kotlin class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleNativeDatepickerModule.NAME)
class SampleNativeDatepickerModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : NativeSampleNativeDatepickerModuleSpec(reactContext) {
    // Use shared module implementation and forward react application context
    private val moduleImpl = SampleNativeDatepickerModuleImpl(reactContext)

    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = SampleNativeDatepickerModuleImpl.NAME

    // Exported methods are overriden - based on the spec class
    override fun showRangeDatepickerWithCallback(title: String, onResult: Callback) = moduleImpl.showRangeDatepickerWithCallback(title, onResult)

    override fun showRangeDatepickerWithPromise(config: ReadableMap, promise: Promise) = moduleImpl.showRangeDatepickerWithPromise(config, promise)

    companion object {
        const val NAME = SampleNativeDatepickerModuleImpl.NAME
    }
}
