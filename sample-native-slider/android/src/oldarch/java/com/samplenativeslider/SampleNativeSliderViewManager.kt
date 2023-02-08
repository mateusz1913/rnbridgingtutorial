package com.samplenativeslider

import android.view.View
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp

@ReactModule(name = SampleNativeSliderView.NAME)
class SampleNativeSliderViewManager : ViewGroupManager<SampleNativeSliderView>() {
  override fun getName() = SampleNativeSliderView.NAME

  override fun receiveCommand(root: SampleNativeSliderView, commandId: String?, args: ReadableArray?) {
    super.receiveCommand(root, commandId, args)

    when (commandId) {
      "setLeftKnobValueProgrammatically" -> {
        val value = args!!.getDouble(0)
        setLeftKnobValueProgrammatically(root, value)
      }
      "setRightKnobValueProgrammatically" -> {
        val value = args!!.getDouble(0)
        setRightKnobValueProgrammatically(root, value)
      }
    }
  }

  override fun createViewInstance(reactContext: ThemedReactContext): SampleNativeSliderView {
    return SampleNativeSliderView(reactContext)
  }

  @ReactProp(name = "activeColor", customType = "Color")
  fun setActiveColor(view: SampleNativeSliderView, activeColor: Int?) {
    view.setActiveColor(activeColor)
  }

  @ReactProp(name = "inactiveColor", customType = "Color")
  fun setInactiveColor(view: SampleNativeSliderView, inactiveColor: Int?) {
    view.setInactiveColor(inactiveColor)
  }

  @ReactProp(name = "minValue")
  fun setMinValue(view: SampleNativeSliderView, value: Double) {
    view.setMinValue(value)
  }

  @ReactProp(name = "maxValue")
  fun setMaxValue(view: SampleNativeSliderView, value: Double) {
    view.setMaxValue(value)
  }

  @ReactProp(name = "leftKnobValue")
  fun setLeftKnobValue(view: SampleNativeSliderView, value: Double) {
    view.setLeftKnobValue(value)
  }

  @ReactProp(name = "rightKnobValue")
  fun setRightKnobValue(view: SampleNativeSliderView, value: Double) {
    view.setRightKnobValue(value)
  }

  @ReactProp(name = "step")
  fun setStep(view: SampleNativeSliderView, step: Int) {
    view.setStep(step)
  }

  private fun setLeftKnobValueProgrammatically(view: SampleNativeSliderView, value: Double) {
    view.setLeftKnobValue(value)
  }

  private fun setRightKnobValueProgrammatically(view: SampleNativeSliderView, value: Double) {
    view.setRightKnobValue(value)
  }

  override fun addView(parent: SampleNativeSliderView, child: View?, index: Int) {
    // That component does not accept child views
  }

  override fun addViews(parent: SampleNativeSliderView, views: MutableList<View>?) {
    // That component does not accept child views
  }

  override fun removeAllViews(parent: SampleNativeSliderView) {
    // That component does not accept child views
  }

  override fun removeView(parent: SampleNativeSliderView, view: View?) {
    // That component does not accept child views
  }

  override fun removeViewAt(parent: SampleNativeSliderView, index: Int) {
    // That component does not accept child views
  }

  override fun addEventEmitters(reactContext: ThemedReactContext, view: SampleNativeSliderView) {
    super.addEventEmitters(reactContext, view)
    view.setOnSampleNativeSliderViewListener(object : SampleNativeSliderView.OnSampleNativeSliderViewListener {
      override fun onSampleNativeSliderViewValueChange(
        leftKnobValue: Double,
        rightKnobValue: Double
      ) {
        UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.id)
          ?.dispatchEvent(
            OnSampleNativeSliderViewValueChangeEvent(
              UIManagerHelper.getSurfaceId(reactContext),
              view.id,
              leftKnobValue,
              rightKnobValue
            )
          )
      }

      override fun onSampleNativeSliderViewBeginDrag() {
        UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.id)
          ?.dispatchEvent(
            OnSampleNativeSliderViewBeginDragEvent(
              UIManagerHelper.getSurfaceId(reactContext),
              view.id
            )
          )
      }

      override fun onSampleNativeSliderViewEndDrag(leftKnobValue: Double, rightKnobValue: Double) {
        UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.id)
          ?.dispatchEvent(
            OnSampleNativeSliderViewEndDragEvent(
              UIManagerHelper.getSurfaceId(reactContext),
              view.id,
              leftKnobValue,
              rightKnobValue
            )
          )
      }
    })
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.of(
      OnSampleNativeSliderViewValueChangeEvent.NAME,
      MapBuilder.of("registrationName", OnSampleNativeSliderViewValueChangeEvent.EVENT_PROP_NAME),
      OnSampleNativeSliderViewBeginDragEvent.NAME,
      MapBuilder.of("registrationName", OnSampleNativeSliderViewBeginDragEvent.EVENT_PROP_NAME),
      OnSampleNativeSliderViewEndDragEvent.NAME,
      MapBuilder.of("registrationName", OnSampleNativeSliderViewEndDragEvent.EVENT_PROP_NAME)
    )
  }
}
