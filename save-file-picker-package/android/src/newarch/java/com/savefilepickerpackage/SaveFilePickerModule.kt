package com.savefilepickerpackage

import android.net.Uri
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.module.annotations.ReactModule
import java.io.File

/**
 * Declare Kotlin class for new arch native module implementation
 *
 * Each turbo module extends codegenerated spec class
 *
 * Class should be annotated with @ReactModule decorator
 */
@ReactModule(name = SaveFilePickerModule.NAME)
class SaveFilePickerModule(
    // Each native module class consumes react application context
    reactContext: ReactApplicationContext
) : NativeSaveFilePickerModuleSpec(reactContext) {
    // Use shared module implementation and forward react application context
    private val moduleImpl = SaveFilePickerModuleImpl(reactContext)

    private var callbackBlock: Callback? = null
    private var promiseBlock: Promise? = null
    private var sourceFilename: String = ""

    init {
        SaveFilePickerModuleImpl.listener = object : SaveFilePickerModuleImpl.SaveFilePickerListener {
            override fun onCancel() {
                val callback = callbackBlock
                val promise = promiseBlock

                if (callback != null) {
                    callback.invoke(Arguments.createMap().apply {
                        putBoolean("success", false)
                        putBoolean("cancelled", true)
                    })
                } else if (promise != null) {
                    promise.resolve(false)
                }

                callbackBlock = null
                promiseBlock = null
                sourceFilename = ""
            }

            override fun onError(error: Exception) {
                val callback = callbackBlock
                val promise = promiseBlock

                if (callback != null) {
                    callback.invoke(Arguments.createMap().apply {
                        putMap("error", Arguments.createMap().apply {
                            putInt("code", 1234)
                            putString("message", error.message)
                        })
                        putBoolean("success", false)
                        putBoolean("cancelled", false)
                    })
                } else if (promise != null) {
                    promise.reject("1234", error.message)
                }

                callbackBlock = null
                promiseBlock = null
                sourceFilename = ""
            }

            override fun onSuccess(uri: Uri?) {
                reactContext.applicationContext.assets.open(sourceFilename).use { sourceInputStream ->
                    uri?.let {
                        reactContext.contentResolver.openOutputStream(it)?.use { outputStream ->
                            sourceInputStream.copyTo(outputStream)
                        }
                    }
                }

                val callback = callbackBlock
                val promise = promiseBlock

                if (callback != null) {
                    callback.invoke(Arguments.createMap().apply {
                        putBoolean("success", true)
                        putBoolean("cancelled", false)
                    })
                } else if (promise != null) {
                    promise.resolve(true)
                }

                callbackBlock = null
                promiseBlock = null
                sourceFilename = ""
            }
        }
    }

    // Return the name of the module - it should match the name provided in JS specification
    override fun getName() = SaveFilePickerModuleImpl.NAME

    // Exported methods are overriden - based on the spec class
    override fun saveFileWithCallback(filename: String, callback: Callback) {
        callbackBlock = callback
        sourceFilename = filename
        moduleImpl.saveFile(filename)
    }

    override fun saveFileWithPromise(filename: String, promise: Promise) {
        promiseBlock = promise
        sourceFilename = filename
        moduleImpl.saveFile(filename)
    }

    companion object {
        const val NAME = SaveFilePickerModuleImpl.NAME
    }
}
