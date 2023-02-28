package com.rangesliderpackage

import android.view.View
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RangeSliderViewManagerDelegate
import com.facebook.react.viewmanagers.RangeSliderViewManagerInterface

@ReactModule(name = RangeSliderView.NAME)
class RangeSliderViewManager : ViewGroupManager<RangeSliderView>(), RangeSliderViewManagerInterface<RangeSliderView> {
    private val mDelegate = RangeSliderViewManagerDelegate(this)

    override fun getName() = RangeSliderView.NAME

    override fun getDelegate(): ViewManagerDelegate<RangeSliderView> = mDelegate

    override fun receiveCommand(root: RangeSliderView, commandId: String?, args: ReadableArray?) {
        mDelegate.receiveCommand(root, commandId, args)
    }

    override fun createViewInstance(reactContext: ThemedReactContext): RangeSliderView {
        return RangeSliderView(reactContext)
    }

    @ReactProp(name = "activeColor", customType = "Color")
    override fun setActiveColor(view: RangeSliderView, activeColor: Int?) {
        view.setActiveColor(activeColor)
    }

    @ReactProp(name = "inactiveColor", customType = "Color")
    override fun setInactiveColor(view: RangeSliderView, inactiveColor: Int?) {
        view.setInactiveColor(inactiveColor)
    }

    @ReactProp(name = "minValue")
    override fun setMinValue(view: RangeSliderView, value: Double) {
        view.setMinValue(value)
    }

    @ReactProp(name = "maxValue")
    override fun setMaxValue(view: RangeSliderView, value: Double) {
        view.setMaxValue(value)
    }

    @ReactProp(name = "leftKnobValue")
    override fun setLeftKnobValue(view: RangeSliderView, value: Double) {
        view.setLeftKnobValue(value)
    }

    @ReactProp(name = "rightKnobValue")
    override fun setRightKnobValue(view: RangeSliderView, value: Double) {
        view.setRightKnobValue(value)
    }

    @ReactProp(name = "step")
    override fun setStep(view: RangeSliderView, step: Int) {
        view.setStep(step)
    }

    override fun setLeftKnobValueProgrammatically(view: RangeSliderView?, value: Double) {
        view?.setLeftKnobValue(value)
    }

    override fun setRightKnobValueProgrammatically(view: RangeSliderView?, value: Double) {
        view?.setRightKnobValue(value)
    }

    override fun addView(parent: RangeSliderView, child: View?, index: Int) {
        // That component does not accept child views
    }

    override fun addViews(parent: RangeSliderView, views: MutableList<View>?) {
        // That component does not accept child views
    }

    override fun removeAllViews(parent: RangeSliderView) {
        // That component does not accept child views
    }

    override fun removeView(parent: RangeSliderView, view: View?) {
        // That component does not accept child views
    }

    override fun removeViewAt(parent: RangeSliderView, index: Int) {
        // That component does not accept child views
    }

    override fun addEventEmitters(reactContext: ThemedReactContext, view: RangeSliderView) {
        super.addEventEmitters(reactContext, view)
        view.setOnRangeSliderViewListener(object : RangeSliderView.OnRangeSliderViewListener {
            override fun onRangeSliderViewValueChange(
                leftKnobValue: Double,
                rightKnobValue: Double
            ) {
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.id)
                    ?.dispatchEvent(
                        OnRangeSliderViewValueChangeEvent(
                            UIManagerHelper.getSurfaceId(reactContext),
                            view.id,
                            leftKnobValue,
                            rightKnobValue
                        )
                    )
            }

            override fun onRangeSliderViewBeginDrag() {
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.id)
                    ?.dispatchEvent(
                        OnRangeSliderViewBeginDragEvent(
                            UIManagerHelper.getSurfaceId(reactContext),
                            view.id
                        )
                    )
            }

            override fun onRangeSliderViewEndDrag(leftKnobValue: Double, rightKnobValue: Double) {
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.id)
                    ?.dispatchEvent(
                        OnRangeSliderViewEndDragEvent(
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
            OnRangeSliderViewValueChangeEvent.NAME,
            MapBuilder.of("registrationName", OnRangeSliderViewValueChangeEvent.EVENT_PROP_NAME),
            OnRangeSliderViewBeginDragEvent.NAME,
            MapBuilder.of("registrationName", OnRangeSliderViewBeginDragEvent.EVENT_PROP_NAME),
            OnRangeSliderViewEndDragEvent.NAME,
            MapBuilder.of("registrationName", OnRangeSliderViewEndDragEvent.EVENT_PROP_NAME)
        )
    }
}
