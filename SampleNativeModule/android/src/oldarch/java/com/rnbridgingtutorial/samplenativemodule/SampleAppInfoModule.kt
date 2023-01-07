package com.rnbridgingtutorial.samplenativemodule

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
@ReactModule(name = SampleAppInfoModule.NAME)
class SampleAppInfoModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {
    // Use shared module implementation and forward react application context
    private val moduleImpl = SampleAppInfoModuleImpl(reactContext)

    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = SampleAppInfoModuleImpl.NAME

    // Exported methods must be annotated with @ReactMethod decorator
    @ReactMethod(isBlockingSynchronousMethod = true)
    fun getAppBuildNumber() = moduleImpl.getAppBuildNumber()

    @ReactMethod(isBlockingSynchronousMethod = true)
    fun getAppBundleId() = moduleImpl.getAppBundleId()

    @ReactMethod(isBlockingSynchronousMethod = true)
    fun getAppVersion() = moduleImpl.getAppVersion()

    companion object {
        const val NAME = SampleAppInfoModuleImpl.NAME
    }
}
