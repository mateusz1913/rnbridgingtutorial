package com.conicgradientpackageclassic;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.ConicGradientClassicViewManagerDelegate;
import com.facebook.react.viewmanagers.ConicGradientClassicViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

@ReactModule(name = ConicGradientClassicView.NAME)
public class ConicGradientClassicViewManager extends ReactViewManager implements ConicGradientClassicViewManagerInterface<ReactViewGroup> {
    private final ConicGradientClassicViewManagerDelegate mDelegate = new ConicGradientClassicViewManagerDelegate(this);
    
    @Override
    public String getName() {
        return ConicGradientClassicView.NAME;
    }

    @Override
    protected ViewManagerDelegate<ReactViewGroup> getDelegate() {
        return mDelegate;
    }

    @Override
    public ConicGradientClassicView createViewInstance(ThemedReactContext reactContext) {
        return new ConicGradientClassicView(reactContext);
    }

    @Override
    @ReactProp(name = "colors")
    public void setColors(ReactViewGroup view, @Nullable ReadableArray colors) {
        if (!(view instanceof ConicGradientClassicView)) {
            throw new IllegalStateException("Check failed.");
        }
        ConicGradientClassicView typedView = (ConicGradientClassicView)view;
        if (colors == null) {
            return;
        }
        typedView.setColors(colors);
    }

    @Override
    @ReactProp(name = "locations")
    public void setLocations(ReactViewGroup view, @Nullable ReadableArray locations) {
        if (!(view instanceof ConicGradientClassicView)) {
            throw new IllegalStateException("Check failed.");
        }
        ConicGradientClassicView typedView = (ConicGradientClassicView)view;
        if (locations == null) {
            return;
        }
        typedView.setLocations(locations);
    }

    @Override
    @ReactProp(name = "centerPoint")
    public void setCenterPoint(ReactViewGroup view, @Nullable ReadableMap centerPoint) {
        if (!(view instanceof ConicGradientClassicView)) {
            throw new IllegalStateException("Check failed.");
        }
        ConicGradientClassicView typedView = (ConicGradientClassicView)view;
        if (centerPoint == null) {
            return;
        }
        typedView.setCenterPoint(centerPoint);
    }
}
