package com.rangesliderpackageclassic;

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
import com.facebook.react.viewmanagers.RangeSliderClassicViewManagerDelegate;
import com.facebook.react.viewmanagers.RangeSliderClassicViewManagerInterface;
import java.util.List;
import java.util.Map;

@ReactModule(name = RangeSliderClassicView.NAME)
public class RangeSliderClassicViewManager extends ViewGroupManager<RangeSliderClassicView> implements RangeSliderClassicViewManagerInterface<RangeSliderClassicView> {
    private final RangeSliderClassicViewManagerDelegate mDelegate = new RangeSliderClassicViewManagerDelegate(this);
  
    @Override
    public String getName() {
        return RangeSliderClassicView.NAME;
    }

    @Override
    public ViewManagerDelegate<RangeSliderClassicView> getDelegate() {
        return mDelegate;
    }

    @Override
    public void receiveCommand(RangeSliderClassicView root, String commandId, ReadableArray args) {
        mDelegate.receiveCommand(root, commandId, args);
    }

    @Override
    public RangeSliderClassicView createViewInstance(ThemedReactContext reactContext) {
        return new RangeSliderClassicView(reactContext);
    }

    @Override
    @ReactProp(name = "activeColor", customType = "Color")
    public void setActiveColor(RangeSliderClassicView view, @Nullable Integer activeColor) {
        view.setActiveColor(activeColor);
    }

    @Override
    @ReactProp(name = "inactiveColor", customType = "Color")
    public void setInactiveColor(RangeSliderClassicView view, @Nullable Integer inactiveColor) {
        view.setInactiveColor(inactiveColor);
    }

    @Override
    @ReactProp(name = "minValue")
    public void setMinValue(RangeSliderClassicView view, double value) {
        view.setMinValue(value);
    }

    @Override
    @ReactProp(name = "maxValue")
    public void setMaxValue(RangeSliderClassicView view, double value) {
        view.setMaxValue(value);
    }

    @Override
    @ReactProp(name = "leftKnobValue")
    public void setLeftKnobValue(RangeSliderClassicView view, double value) {
        view.setLeftKnobValue(value);
    }

    @Override
    @ReactProp(name = "rightKnobValue")
    public void setRightKnobValue(RangeSliderClassicView view, double value) {
        view.setRightKnobValue(value);
    }

    @Override
    @ReactProp(name = "step")
    public void setStep(RangeSliderClassicView view, int step) {
        view.setStep(step);
    }

    @Override
    public void setLeftKnobValueProgrammatically(RangeSliderClassicView view, double value) {
        view.setLeftKnobValue(value);
    }

    @Override
    public void setRightKnobValueProgrammatically(RangeSliderClassicView view, double value) {
        view.setRightKnobValue(value);
    }

    @Override
    public void addView(RangeSliderClassicView parent, View child, int index) {
        // That component does not accept child views
    }

    @Override
    public void addViews(RangeSliderClassicView parent, List<View> views) {
        // That component does not accept child views
    }

    @Override
    public void removeAllViews(RangeSliderClassicView parent) {
        // That component does not accept child views
    }

    @Override
    public void removeView(RangeSliderClassicView parent, View view) {
        // That component does not accept child views
    }

    @Override
    public void removeViewAt(RangeSliderClassicView parent, int index) {
        // That component does not accept child views
    }

    @Override
    protected void addEventEmitters(ThemedReactContext reactContext, RangeSliderClassicView view) {
        super.addEventEmitters(reactContext, view);
        view.setOnRangeSliderClassicViewListener(new RangeSliderClassicView.OnRangeSliderClassicViewListener() {
            @Override
            public void onRangeSliderClassicViewValueChange(double leftKnobValue, double rightKnobValue) {
                final EventDispatcher dispatcher =
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
                if (dispatcher != null) {
                    dispatcher.dispatchEvent(
                        new OnRangeSliderClassicViewValueChangeEvent(
                            UIManagerHelper.getSurfaceId(reactContext),
                            view.getId(),
                            leftKnobValue,
                            rightKnobValue
                        )
                    );
                }
            }

            @Override
            public void onRangeSliderClassicViewBeginDrag() {
                final EventDispatcher dispatcher =
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
                if (dispatcher != null) {
                    dispatcher.dispatchEvent(
                        new OnRangeSliderClassicViewBeginDragEvent(
                            UIManagerHelper.getSurfaceId(reactContext),
                            view.getId()
                        )
                    );
                }
            }

            @Override
            public void onRangeSliderClassicViewEndDrag(double leftKnobValue, double rightKnobValue) {
                final EventDispatcher dispatcher =
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
                if (dispatcher != null) {
                    dispatcher.dispatchEvent(
                        new OnRangeSliderClassicViewEndDragEvent(
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
            OnRangeSliderClassicViewValueChangeEvent.NAME,
            MapBuilder.of("registrationName", OnRangeSliderClassicViewValueChangeEvent.EVENT_PROP_NAME),
            OnRangeSliderClassicViewBeginDragEvent.NAME,
            MapBuilder.of("registrationName", OnRangeSliderClassicViewBeginDragEvent.EVENT_PROP_NAME),
            OnRangeSliderClassicViewEndDragEvent.NAME,
            MapBuilder.of("registrationName", OnRangeSliderClassicViewEndDragEvent.EVENT_PROP_NAME)
        );
    }
}
