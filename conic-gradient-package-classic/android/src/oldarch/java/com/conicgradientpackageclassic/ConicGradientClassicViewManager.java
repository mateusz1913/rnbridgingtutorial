package com.conicgradientpackageclassic;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;

@ReactModule(name = ConicGradientClassicView.NAME)
public class ConicGradientClassicViewManager extends ReactViewManager {
    @Override
    public String getName() {
        return ConicGradientClassicView.NAME;
    }

    @Override
    public ConicGradientClassicView createViewInstance(ThemedReactContext reactContext) {
        return new ConicGradientClassicView(reactContext);
    }

    @ReactProp(name = "colors")
    public void setColors(ConicGradientClassicView view, @Nullable ReadableArray colors) {
        if (colors == null) {
            return;
        }
        view.setColors(colors);
    }

    @ReactProp(name = "locations")
    public void setLocations(ConicGradientClassicView view, @Nullable ReadableArray locations) {
        if (locations == null) {
            return;
        }
        view.setLocations(locations);
    }

    @ReactProp(name = "centerPoint")
    public void setCenterPoint(ConicGradientClassicView view, @Nullable ReadableMap centerPoint) {
        if (centerPoint == null) {
            return;
        }
        view.setCenterPoint(centerPoint);
    }
}
