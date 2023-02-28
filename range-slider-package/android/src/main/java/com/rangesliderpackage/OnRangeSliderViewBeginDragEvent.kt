package com.rangesliderpackage

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

class OnRangeSliderViewBeginDragEvent(
    surfaceId: Int,
    viewId: Int
) : Event<OnRangeSliderViewBeginDragEvent>(surfaceId, viewId) {
    override fun getEventName() = NAME

    override fun getEventData(): WritableMap? {
        return Arguments.createMap()
    }

    companion object {
        const val NAME = "topRangeSliderViewBeginDrag"
        const val EVENT_PROP_NAME = "onRangeSliderViewBeginDrag"
    }
}
