package com.rangedatepickerpackage

import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.UiThreadUtil
import com.facebook.react.bridge.WritableMap
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

/**
 * Native module's shared implementation
 */
class RangeDatePickerModuleImpl(
    private val reactContext: ReactApplicationContext
) {
    private var mCallback: Callback? = null

    fun showRangeDatePickerWithCallback(title: String, onResult: Callback) {
        mCallback = onResult
        showRangeDatePicker(
            title,
            onCancel = {
                mCallback?.invoke(null)
                mCallback = null
            },
            onError = {
                mCallback?.invoke(null)
                mCallback = null
            },
            onResult = {
                mCallback?.invoke(it)
                mCallback = null
            }
        )
    }

    fun showRangeDatePickerWithPromise(config: ReadableMap, promise: Promise) {
        showRangeDatePicker(
            config.getString("title")!!,
            onCancel = { promise.resolve(null) },
            onError = { promise.reject(it) },
            onResult = { promise.resolve(it) }
        )
    }

    private fun showRangeDatePicker(
        title: String,
        onCancel: () -> Unit,
        onError: (Throwable) -> Unit,
        onResult: (WritableMap) -> Unit
    ) {
        val activity = reactContext.currentActivity as AppCompatActivity?
        if (activity == null) {
            onError(Exception("No activity"))
            return
        }

        val picker = MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText(title)
            .build()
        picker.addOnCancelListener { onCancel() }
        picker.addOnDismissListener { onCancel() }
        picker.addOnNegativeButtonClickListener { onCancel() }
        picker.addOnPositiveButtonClickListener { result ->
            val fromCalendar = Calendar.getInstance()
            fromCalendar.timeInMillis = result.first
            val fromYear = fromCalendar.get(Calendar.YEAR)
            val fromMonth = fromCalendar.get(Calendar.MONTH)
            val fromDay = fromCalendar.get(Calendar.DAY_OF_MONTH)
            val toCalendar = Calendar.getInstance()
            toCalendar.timeInMillis = result.second
            val toYear = toCalendar.get(Calendar.YEAR)
            val toMonth = toCalendar.get(Calendar.MONTH)
            val toDay = toCalendar.get(Calendar.DAY_OF_MONTH)

            val payload = Arguments.createMap().apply {
                putMap("from", Arguments.createMap().apply {
                    putInt("day", fromDay)
                    putInt("month", fromMonth + 1)
                    putInt("year", fromYear)
                })
                putMap("to", Arguments.createMap().apply {
                    putInt("day", toDay)
                    putInt("month", toMonth + 1)
                    putInt("year", toYear)
                })
            }
            onResult(payload)
        }

        UiThreadUtil.runOnUiThread {
            picker.show(activity.supportFragmentManager, NAME)
        }
    }

    companion object {
        const val NAME = "RangeDatePickerModule"
    }
}
