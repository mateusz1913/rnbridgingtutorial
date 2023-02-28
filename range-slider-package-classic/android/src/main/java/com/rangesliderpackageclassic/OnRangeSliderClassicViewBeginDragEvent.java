package com.rangesliderpackageclassic;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class OnRangeSliderClassicViewBeginDragEvent extends Event<OnRangeSliderClassicViewBeginDragEvent> {
    public static final String NAME = "topRangeSliderClassicViewBeginDrag";
    public static final String EVENT_PROP_NAME = "onRangeSliderClassicViewBeginDrag";

    public OnRangeSliderClassicViewBeginDragEvent(int surfaceId, int viewId) {
        super(surfaceId, viewId);
    }

    @Override
    public String getEventName() {
        return NAME;
    }

    @Nullable
    @Override
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
