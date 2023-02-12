package com.samplenativesliderclassic;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class OnSampleNativeSliderClassicViewBeginDragEvent extends Event<OnSampleNativeSliderClassicViewBeginDragEvent> {
    public static final String NAME = "topSampleNativeSliderClassicViewBeginDrag";
    public static final String EVENT_PROP_NAME = "onSampleNativeSliderClassicViewBeginDrag";

    public OnSampleNativeSliderClassicViewBeginDragEvent(int surfaceId, int viewId) {
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
