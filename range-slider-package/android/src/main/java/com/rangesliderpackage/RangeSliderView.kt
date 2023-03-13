package com.rangesliderpackage

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.FrameLayout
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.PixelUtil
import com.google.android.material.slider.RangeSlider
import kotlin.math.abs

class RangeSliderView(private val reactContext: ReactContext) : FrameLayout(reactContext) {
    interface OnRangeSliderViewListener {
        fun onRangeSliderViewBeginDrag()
        fun onRangeSliderViewEndDrag(leftKnobValue: Double, rightKnobValue: Double)
        fun onRangeSliderViewValueChange(leftKnobValue: Double, rightKnobValue: Double)
    }

    private var mListener: OnRangeSliderViewListener? = null
    private var mLastLeftKnobValue = 0f
    private var mLastRightKnobValue = 1f
    private var slider = RangeSlider(reactContext).apply {
        trackHeight = PixelUtil.toPixelFromDIP(10f).toInt()
        thumbTintList = ColorStateList.valueOf(Color.BLUE)
        addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: RangeSlider) {
                sendOnRangeSliderViewBeginDragEvent()
            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                sendOnRangeSliderViewEndDragEvent(slider.values[0].toDouble(), slider.values[1].toDouble())
            }
        })
        addOnChangeListener { slider, _, _ ->
            val newLeftKnobValue = slider.values[0]
            val newRightKnobValue = slider.values[1]
            if (abs(newLeftKnobValue - mLastLeftKnobValue) < 0.1f && abs(newRightKnobValue - mLastRightKnobValue) < 0.1f) {
                return@addOnChangeListener
            }
            mLastLeftKnobValue = newLeftKnobValue
            mLastRightKnobValue = newRightKnobValue
            sendOnRangeSliderViewValueChangeEvent(newLeftKnobValue.toDouble(), newRightKnobValue.toDouble())
        }
    }

    init {
        this.addView(slider, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
    }

    fun setOnRangeSliderViewListener(listener: OnRangeSliderViewListener?) {
        mListener = listener
    }

    fun setActiveColor(activeColor: Int?) {
        slider.trackActiveTintList = ColorStateList.valueOf(activeColor ?: Color.BLUE)
    }

    fun setInactiveColor(inactiveColor: Int?) {
        slider.trackInactiveTintList = ColorStateList.valueOf(inactiveColor ?: Color.GRAY)
    }

    fun setMinValue(minValue: Double) {
        slider.valueFrom = minValue.toFloat()
    }

    fun setMaxValue(maxValue: Double) {
        slider.valueTo = maxValue.toFloat()
    }

    fun setLeftKnobValue(leftKnobValue: Double) {
        if (leftKnobValue.isNaN()) {
            return
        }
        if (slider.values.count() < 2) {
            slider.values = listOf(leftKnobValue.toFloat(), leftKnobValue.toFloat() + 1)
            return
        }
        val rightKnobValue = slider.values[1]
        slider.values = listOf(leftKnobValue.toFloat(), rightKnobValue)
    }

    fun setRightKnobValue(rightKnobValue: Double) {
        if (rightKnobValue.isNaN()) {
            return
        }
        if (slider.values.isEmpty()) {
            slider.values = listOf(rightKnobValue.toFloat() - 1, rightKnobValue.toFloat())
            return
        }
        val leftKnobValue = slider.values[0]
        slider.values = listOf(leftKnobValue, rightKnobValue.toFloat())
    }

    fun setStep(step: Int) {
        slider.stepSize = step.toFloat()
    }

    private fun sendOnRangeSliderViewValueChangeEvent(leftKnobValue: Double, rightKnobValue: Double) {
        mListener?.onRangeSliderViewValueChange(leftKnobValue, rightKnobValue)
    }

    private fun sendOnRangeSliderViewBeginDragEvent() {
        mListener?.onRangeSliderViewBeginDrag()
    }

    private fun sendOnRangeSliderViewEndDragEvent(leftKnobValue: Double, rightKnobValue: Double) {
        mListener?.onRangeSliderViewEndDrag(leftKnobValue, rightKnobValue)
    }

    companion object {
        const val NAME = "RangeSliderView"
    }
}
