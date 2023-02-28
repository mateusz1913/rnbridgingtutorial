package com.rangesliderpackage

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

class OnRangeSliderViewEndDragEvent(
    surfaceId: Int,
    viewId: Int,
    private val leftKnobValue: Double,
    private val rightKnobValue: Double
) : Event<OnRangeSliderViewEndDragEvent>(surfaceId, viewId) {
    override fun getEventName() = NAME

    override fun getEventData(): WritableMap? {
        return createPayload()
    }

    private fun createPayload() = Arguments.createMap().apply {
        putDouble(LEFT_KNOB_KEY, leftKnobValue)
        putDouble(RIGHT_KNOB_KEY, rightKnobValue)
    }

    companion object {
        private const val LEFT_KNOB_KEY = "leftKnobValue"
        private const val RIGHT_KNOB_KEY = "rightKnobValue"
        const val NAME = "topRangeSliderViewEndDrag"
        const val EVENT_PROP_NAME = "onRangeSliderViewEndDrag"
    }
}
