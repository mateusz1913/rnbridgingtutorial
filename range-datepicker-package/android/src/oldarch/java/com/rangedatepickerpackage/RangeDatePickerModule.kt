package com.rangedatepickerpackage

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule

/**
 * Declare Kotlin class for old arch native module implementation
 *
 * Each native module extends ReactContextBaseJavaModule class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = RangeDatePickerModule.NAME)
class RangeDatePickerModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {
    // Use shared module implementation and forward react application context
    private val moduleImpl = RangeDatePickerModuleImpl(reactContext)

    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = NAME

    // Exported methods must be annotated with @ReactMethod decorator
    @ReactMethod
    fun showRangeDatePickerWithCallback(title: String, onResult: Callback) = moduleImpl.showRangeDatePickerWithCallback(title, onResult)

    @ReactMethod
    fun showRangeDatePickerWithPromise(config: ReadableMap, promise: Promise) = moduleImpl.showRangeDatePickerWithPromise(config, promise)

    companion object {
        const val NAME = RangeDatePickerModuleImpl.NAME
    }
}
