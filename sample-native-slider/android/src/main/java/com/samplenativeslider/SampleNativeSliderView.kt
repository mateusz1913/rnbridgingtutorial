package com.samplenativeslider

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.FrameLayout
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.PixelUtil
import com.google.android.material.slider.RangeSlider
import kotlin.math.abs

class SampleNativeSliderView(private val reactContext: ReactContext) : FrameLayout(reactContext) {
  interface OnSampleNativeSliderViewListener {
    fun onSampleNativeSliderViewBeginDrag()
    fun onSampleNativeSliderViewEndDrag(leftKnobValue: Double, rightKnobValue: Double)
    fun onSampleNativeSliderViewValueChange(leftKnobValue: Double, rightKnobValue: Double)
  }

  private var mListener: OnSampleNativeSliderViewListener? = null
  private var mLastLeftKnobValue = 0f
  private var mLastRightKnobValue = 1f
  private var slider = RangeSlider(reactContext).apply {
    trackHeight = PixelUtil.toPixelFromDIP(10f).toInt()
    thumbTintList = ColorStateList.valueOf(Color.BLUE)
    addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
      override fun onStartTrackingTouch(slider: RangeSlider) {
        sendOnSampleNativeSliderViewBeginDragEvent()
      }

      override fun onStopTrackingTouch(slider: RangeSlider) {
        sendOnSampleNativeSliderViewEndDragEvent(slider.values[0].toDouble(), slider.values[1].toDouble())
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
      sendOnSampleNativeSliderViewValueChangeEvent(newLeftKnobValue.toDouble(), newRightKnobValue.toDouble())
    }
  }

  init {
    this.addView(slider, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
  }

  fun setOnSampleNativeSliderViewListener(listener: OnSampleNativeSliderViewListener?) {
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
    val rightKnobValue = slider.values[1]
    slider.values = listOf(leftKnobValue.toFloat(), rightKnobValue)
  }

  fun setRightKnobValue(rightKnobValue: Double) {
    if (rightKnobValue.isNaN()) {
      return
    }
    val leftKnobValue = slider.values[0]
    slider.values = listOf(leftKnobValue, rightKnobValue.toFloat())
  }

  fun setStep(step: Int) {
    slider.stepSize = step.toFloat()
  }

  private fun sendOnSampleNativeSliderViewValueChangeEvent(leftKnobValue: Double, rightKnobValue: Double) {
    mListener?.onSampleNativeSliderViewValueChange(leftKnobValue, rightKnobValue)
  }

  private fun sendOnSampleNativeSliderViewBeginDragEvent() {
    mListener?.onSampleNativeSliderViewBeginDrag()
  }

  private fun sendOnSampleNativeSliderViewEndDragEvent(leftKnobValue: Double, rightKnobValue: Double) {
    mListener?.onSampleNativeSliderViewEndDrag(leftKnobValue, rightKnobValue)
  }

  companion object {
    const val NAME = "SampleNativeSliderView"
  }
}
