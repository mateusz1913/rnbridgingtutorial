package com.samplereactviewclassic;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.SampleConicGradientClassicViewManagerDelegate;
import com.facebook.react.viewmanagers.SampleConicGradientClassicViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

@ReactModule(name = SampleConicGradientClassicView.NAME)
public class SampleConicGradientClassicViewManager extends ReactViewManager implements SampleConicGradientClassicViewManagerInterface<ReactViewGroup> {
  private final SampleConicGradientClassicViewManagerDelegate mDelegate = new SampleConicGradientClassicViewManagerDelegate(this);
  
  @Override
  public String getName() {
    return SampleConicGradientClassicView.NAME;
  }

  @Override
  protected ViewManagerDelegate<ReactViewGroup> getDelegate() {
    return mDelegate;
  }

  @Override
  public SampleConicGradientClassicView createViewInstance(ThemedReactContext reactContext) {
    return new SampleConicGradientClassicView(reactContext);
  }

  @Override
  @ReactProp(name = "colors")
  public void setColors(ReactViewGroup view, @Nullable ReadableArray colors) {
    if (!(view instanceof SampleConicGradientClassicView)) {
      throw new IllegalStateException("Check failed.");
    }
    SampleConicGradientClassicView typedView = (SampleConicGradientClassicView)view;
    if (colors == null) {
      return;
    }
    typedView.setColors(colors);
  }

  @Override
  @ReactProp(name = "locations")
  public void setLocations(ReactViewGroup view, @Nullable ReadableArray locations) {
    if (!(view instanceof SampleConicGradientClassicView)) {
      throw new IllegalStateException("Check failed.");
    }
    SampleConicGradientClassicView typedView = (SampleConicGradientClassicView)view;
    if (locations == null) {
      return;
    }
    typedView.setLocations(locations);
  }

  @Override
  @ReactProp(name = "centerPoint")
  public void setCenterPoint(ReactViewGroup view, @Nullable ReadableMap centerPoint) {
    if (!(view instanceof SampleConicGradientClassicView)) {
      throw new IllegalStateException("Check failed.");
    }
    SampleConicGradientClassicView typedView = (SampleConicGradientClassicView)view;
    if (centerPoint == null) {
      return;
    }
    typedView.setCenterPoint(centerPoint);
  }
}
