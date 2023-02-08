package com.samplenativesliderclassic;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.SampleNativeSliderClassicViewManagerDelegate;
import com.facebook.react.viewmanagers.SampleNativeSliderClassicViewManagerInterface;
import java.util.List;
import java.util.Map;

@ReactModule(name = SampleNativeSliderClassicView.NAME)
public class SampleNativeSliderClassicViewManager extends ViewGroupManager<SampleNativeSliderClassicView> implements SampleNativeSliderClassicViewManagerInterface<SampleNativeSliderClassicView> {
  private final SampleNativeSliderClassicViewManagerDelegate mDelegate = new SampleNativeSliderClassicViewManagerDelegate(this);
  
  @Override
  public String getName() {
    return SampleNativeSliderClassicView.NAME;
  }

  @Override
  public ViewManagerDelegate<SampleNativeSliderClassicView> getDelegate() {
    return mDelegate;
  }

  @Override
  public void receiveCommand(SampleNativeSliderClassicView root, String commandId, ReadableArray args) {
    mDelegate.receiveCommand(root, commandId, args);
  }

  @Override
  public SampleNativeSliderClassicView createViewInstance(ThemedReactContext reactContext) {
    return new SampleNativeSliderClassicView(reactContext);
  }

  @Override
  @ReactProp(name = "activeColor", customType = "Color")
  public void setActiveColor(SampleNativeSliderClassicView view, @Nullable Integer activeColor) {
    view.setActiveColor(activeColor);
  }

  @Override
  @ReactProp(name = "inactiveColor", customType = "Color")
  public void setInactiveColor(SampleNativeSliderClassicView view, @Nullable Integer inactiveColor) {
    view.setInactiveColor(inactiveColor);
  }

  @Override
  @ReactProp(name = "minValue")
  public void setMinValue(SampleNativeSliderClassicView view, double value) {
    view.setMinValue(value);
  }

  @Override
  @ReactProp(name = "maxValue")
  public void setMaxValue(SampleNativeSliderClassicView view, double value) {
    view.setMaxValue(value);
  }

  @Override
  @ReactProp(name = "leftKnobValue")
  public void setLeftKnobValue(SampleNativeSliderClassicView view, double value) {
    view.setLeftKnobValue(value);
  }

  @Override
  @ReactProp(name = "rightKnobValue")
  public void setRightKnobValue(SampleNativeSliderClassicView view, double value) {
    view.setRightKnobValue(value);
  }

  @Override
  @ReactProp(name = "step")
  public void setStep(SampleNativeSliderClassicView view, int step) {
    view.setStep(step);
  }

  @Override
  public void setLeftKnobValueProgrammatically(SampleNativeSliderClassicView view, double value) {
    view.setLeftKnobValue(value);
  }

  @Override
  public void setRightKnobValueProgrammatically(SampleNativeSliderClassicView view, double value) {
    view.setRightKnobValue(value);
  }

  @Override
  public void addView(SampleNativeSliderClassicView parent, View child, int index) {
    // That component does not accept child views
  }

  @Override
  public void addViews(SampleNativeSliderClassicView parent, List<View> views) {
    // That component does not accept child views
  }

  @Override
  public void removeAllViews(SampleNativeSliderClassicView parent) {
    // That component does not accept child views
  }

  @Override
  public void removeView(SampleNativeSliderClassicView parent, View view) {
    // That component does not accept child views
  }

  @Override
  public void removeViewAt(SampleNativeSliderClassicView parent, int index) {
    // That component does not accept child views
  }

  @Override
  protected void addEventEmitters(ThemedReactContext reactContext, SampleNativeSliderClassicView view) {
    super.addEventEmitters(reactContext, view);
    view.setOnSampleNativeSliderClassicViewListener(new SampleNativeSliderClassicView.OnSampleNativeSliderClassicViewListener() {
      @Override
      public void onSampleNativeSliderClassicViewValueChange(double leftKnobValue, double rightKnobValue) {
        final EventDispatcher dispatcher =
          UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (dispatcher != null) {
          dispatcher.dispatchEvent(
            new OnSampleNativeSliderClassicViewValueChangeEvent(
              UIManagerHelper.getSurfaceId(reactContext),
              view.getId(),
              leftKnobValue,
              rightKnobValue
            )
          );
        }
      }

      @Override
      public void onSampleNativeSliderClassicViewBeginDrag() {
        final EventDispatcher dispatcher =
          UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (dispatcher != null) {
          dispatcher.dispatchEvent(
            new OnSampleNativeSliderClassicViewBeginDragEvent(
              UIManagerHelper.getSurfaceId(reactContext),
              view.getId()
            )
          );
        }
      }

      @Override
      public void onSampleNativeSliderClassicViewEndDrag(double leftKnobValue, double rightKnobValue) {
        final EventDispatcher dispatcher =
          UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (dispatcher != null) {
          dispatcher.dispatchEvent(
            new OnSampleNativeSliderClassicViewEndDragEvent(
              UIManagerHelper.getSurfaceId(reactContext),
              view.getId(),
              leftKnobValue,
              rightKnobValue
            )
          );
        }
      }
    });
  }

  @Override
  public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    return MapBuilder.of(
      OnSampleNativeSliderClassicViewValueChangeEvent.NAME,
      MapBuilder.of("registrationName", OnSampleNativeSliderClassicViewValueChangeEvent.EVENT_PROP_NAME),
      OnSampleNativeSliderClassicViewBeginDragEvent.NAME,
      MapBuilder.of("registrationName", OnSampleNativeSliderClassicViewBeginDragEvent.EVENT_PROP_NAME),
      OnSampleNativeSliderClassicViewEndDragEvent.NAME,
      MapBuilder.of("registrationName", OnSampleNativeSliderClassicViewEndDragEvent.EVENT_PROP_NAME)
    );
  }
}
