package com.rnbridgingtutorial.samplenativemodule

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

/**
 * Declare Kotlin class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SampleAppInfoModule.NAME)
class SampleAppInfoModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : NativeAppInfoSpec(reactContext) {
    // Use shared module implementation and forward react application context
    private val moduleImpl = SampleAppInfoModuleImpl(reactContext)

    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = SampleAppInfoModuleImpl.NAME

    // Exported methods are overriden - based on the spec class
    override fun getAppBuildNumber() = moduleImpl.getAppBuildNumber()

    override fun getAppBundleId() = moduleImpl.getAppBundleId()

    override fun getAppVersion() = moduleImpl.getAppVersion()

    companion object {
        const val NAME = SampleAppInfoModuleImpl.NAME
    }
}
