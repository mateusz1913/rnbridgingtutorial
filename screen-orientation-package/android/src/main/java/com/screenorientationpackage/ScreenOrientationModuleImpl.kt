package com.screenorientationpackage

import android.hardware.SensorManager
import android.view.OrientationEventListener
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.modules.core.DeviceEventManagerModule

/**
 * Native module's shared implementation
 */
class ScreenOrientationModuleImpl(
    private val reactContext: ReactApplicationContext
) {
    /**
     * Example usage:
     *
     * ```kotlin
     * sendEvent(EVENT_NAME, Arguments.createMap().apply {
     *     putDouble(EVENT_KEY, 42)
     * });
     * ```
     */
    private fun sendEvent(eventName: String, params: WritableMap?) {
        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
            .emit(eventName, params)
    }

    private var mOrientationDidChangeListener: OrientationEventListener? = null
    private var mLastOrientation = "unknown"

    fun onInitialize() {
        mOrientationDidChangeListener = object : OrientationEventListener(reactContext, SensorManager.SENSOR_DELAY_NORMAL) {
            override fun onOrientationChanged(orientation: Int) {
                val screenOrientation = if (orientation > 315 || orientation < 45 || (orientation in 135..225)) {
                    "portrait"
                } else {
                    "landscape"
                }

                if (mLastOrientation == screenOrientation) {
                    return
                }
                mLastOrientation = screenOrientation

                sendEvent(EVENT_NAME, Arguments.createMap().apply {
                    putString("orientation", screenOrientation)
                })
            }
        }
        mOrientationDidChangeListener?.enable()
    }

    fun onInvalidate() {
        mOrientationDidChangeListener?.disable()
        mOrientationDidChangeListener = null
    }

    companion object {
        const val EVENT_NAME = "onScreenOrientationModuleChange"
        const val EVENT_KEY = "value"
        const val NAME = "ScreenOrientationModule"
    }
}
