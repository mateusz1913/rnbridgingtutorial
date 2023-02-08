package com.samplenativeslider

import android.view.View
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.SampleNativeSliderViewManagerDelegate
import com.facebook.react.viewmanagers.SampleNativeSliderViewManagerInterface

@ReactModule(name = SampleNativeSliderView.NAME)
class SampleNativeSliderViewManager : ViewGroupManager<SampleNativeSliderView>(), SampleNativeSliderViewManagerInterface<SampleNativeSliderView> {
  private val mDelegate = SampleNativeSliderViewManagerDelegate(this)

  override fun getName() = SampleNativeSliderView.NAME

  override fun getDelegate(): ViewManagerDelegate<SampleNativeSliderView> = mDelegate

  override fun receiveCommand(root: SampleNativeSliderView, commandId: String?, args: ReadableArray?) {
    mDelegate.receiveCommand(root, commandId, args)
  }

  override fun createViewInstance(reactContext: ThemedReactContext): SampleNativeSliderView {
    return SampleNativeSliderView(reactContext)
  }

  @ReactProp(name = "activeColor", customType = "Color")
  override fun setActiveColor(view: SampleNativeSliderView, activeColor: Int?) {
    view.setActiveColor(activeColor)
  }

  @ReactProp(name = "inactiveColor", customType = "Color")
  override fun setInactiveColor(view: SampleNativeSliderView, inactiveColor: Int?) {
    view.setInactiveColor(inactiveColor)
  }

  @ReactProp(name = "minValue")
  override fun setMinValue(view: SampleNativeSliderView, value: Double) {
    view.setMinValue(value)
  }

  @ReactProp(name = "maxValue")
  override fun setMaxValue(view: SampleNativeSliderView, value: Double) {
    view.setMaxValue(value)
  }

  @ReactProp(name = "leftKnobValue")
  override fun setLeftKnobValue(view: SampleNativeSliderView, value: Double) {
    view.setLeftKnobValue(value)
  }

  @ReactProp(name = "rightKnobValue")
  override fun setRightKnobValue(view: SampleNativeSliderView, value: Double) {
    view.setRightKnobValue(value)
  }

  @ReactProp(name = "step")
  override fun setStep(view: SampleNativeSliderView, step: Int) {
    view.setStep(step)
  }

  override fun setLeftKnobValueProgrammatically(view: SampleNativeSliderView?, value: Double) {
    view?.setLeftKnobValue(value)
  }

  override fun setRightKnobValueProgrammatically(view: SampleNativeSliderView?, value: Double) {
    view?.setRightKnobValue(value)
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
