package com.samplereactviewclassic;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;

@ReactModule(name = SampleConicGradientClassicView.NAME)
public class SampleConicGradientClassicViewManager extends ReactViewManager {
    @Override
    public String getName() {
        return SampleConicGradientClassicView.NAME;
    }

    @Override
    public SampleConicGradientClassicView createViewInstance(ThemedReactContext reactContext) {
        return new SampleConicGradientClassicView(reactContext);
    }

    @ReactProp(name = "colors")
    public void setColors(SampleConicGradientClassicView view, @Nullable ReadableArray colors) {
        if (colors == null) {
            return;
        }
        view.setColors(colors);
    }

    @ReactProp(name = "locations")
    public void setLocations(SampleConicGradientClassicView view, @Nullable ReadableArray locations) {
        if (locations == null) {
            return;
        }
        view.setLocations(locations);
    }

    @ReactProp(name = "centerPoint")
    public void setCenterPoint(SampleConicGradientClassicView view, @Nullable ReadableMap centerPoint) {
        if (centerPoint == null) {
            return;
        }
        view.setCenterPoint(centerPoint);
    }
}
