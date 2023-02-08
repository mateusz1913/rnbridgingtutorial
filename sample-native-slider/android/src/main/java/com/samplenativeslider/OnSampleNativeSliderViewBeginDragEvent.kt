package com.samplenativeslider

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

class OnSampleNativeSliderViewBeginDragEvent(
    surfaceId: Int,
    viewId: Int
) : Event<OnSampleNativeSliderViewBeginDragEvent>(surfaceId, viewId) {
    override fun getEventName() = NAME

    override fun getEventData(): WritableMap? {
        return Arguments.createMap()
    }

    companion object {
        const val NAME = "topSampleNativeSliderViewBeginDrag"
        const val EVENT_PROP_NAME = "onSampleNativeSliderViewBeginDrag"
    }
}
