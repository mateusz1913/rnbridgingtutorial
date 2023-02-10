package com.samplenativescreen

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.UiThreadUtil
import com.facebook.react.modules.core.DeviceEventManagerModule

/**
 * Native module's shared implementation
 */
object SampleNativeScreenModuleImpl {
  const val NAME = "SampleNativeScreenModule"

  private const val EVENT_NAME = "onResult"

  private var activityLauncher: ActivityResultLauncher<Intent>? = null
  private var reactContext: ReactApplicationContext? = null

  @JvmStatic
  fun setReactApplicationContext(context: ReactApplicationContext) {
    reactContext = context
  }

  @JvmStatic
  fun registerActivityLauncher(activity: AppCompatActivity) {
    activityLauncher = activity.registerForActivityResult(StartActivityForResult()) { result ->
      val context = reactContext ?: return@registerForActivityResult
      context
        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
        .emit(EVENT_NAME, Arguments.createMap().apply {
          if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            if (data != null) {
              val success = data.getBooleanExtra("success", false)
              putBoolean("success", success)
              if (success) {
                putString("text", data.getStringExtra("text"))
              }
            } else {
              putBoolean("success", false)
            }
          } else {
            putBoolean("success", false)
          }
        })
    }
  }

  @JvmStatic
  fun launchNativeScreen(valueFromJS: String) {
    val launcher = activityLauncher ?: return
    val context = reactContext ?: return
    val intent = Intent(context, SampleNativeActivity::class.java).apply {
      putExtra("headerText", valueFromJS)
    }
    UiThreadUtil.runOnUiThread {
      launcher.launch(intent)
    }
  }
}
