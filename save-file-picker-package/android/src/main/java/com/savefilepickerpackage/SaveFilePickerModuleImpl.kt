package com.savefilepickerpackage

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.UiThreadUtil

/**
 * Native module's shared implementation
 */
class SaveFilePickerModuleImpl(private val reactContext: ReactApplicationContext) {
    fun saveFile(filename: String) {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "text/html"
            putExtra(Intent.EXTRA_TITLE, filename)
        }

        val launcher = activityLauncher
        if (launcher == null) {
            listener?.onError(Exception("Activity launcher not registered"))
            return
        }

        UiThreadUtil.runOnUiThread {
            launcher.launch(intent)
        }
    }

    interface SaveFilePickerListener {
        fun onSuccess(uri: Uri?)
        fun onCancel()
        fun onError(error: Exception)
    }

    companion object {
        const val NAME = "SaveFilePickerModule"

        private var activityLauncher: ActivityResultLauncher<Intent>? = null

        var listener: SaveFilePickerListener? = null

        fun registerActivityLauncher(activity: AppCompatActivity) {
            activityLauncher = activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                when (result.resultCode) {
                    Activity.RESULT_OK -> {
                        listener?.onSuccess(result.data?.data)
                    }
                    Activity.RESULT_CANCELED -> {
                        listener?.onCancel()
                    }
                    else -> {
                        listener?.onError(Exception("Unknown result when saving the file"))
                    }
                }
            }
        }
    }
}
