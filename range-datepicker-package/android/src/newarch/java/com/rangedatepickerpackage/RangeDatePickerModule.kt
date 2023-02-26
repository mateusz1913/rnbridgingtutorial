package com.rangedatepickerpackage

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
@ReactModule(name = RangeDatePickerModule.NAME)
class RangeDatePickerModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : NativeRangeDatePickerModuleSpec(reactContext) {
    // Use shared module implementation and forward react application context
    private val moduleImpl = RangeDatePickerModuleImpl(reactContext)

    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = NAME

    // Exported methods are overriden - based on the spec class
    override fun showRangeDatePickerWithCallback(title: String, onResult: Callback) = moduleImpl.showRangeDatePickerWithCallback(title, onResult)

    override fun showRangeDatePickerWithPromise(config: ReadableMap, promise: Promise) = moduleImpl.showRangeDatePickerWithPromise(config, promise)

    companion object {
        const val NAME = RangeDatePickerModuleImpl.NAME
    }
}
