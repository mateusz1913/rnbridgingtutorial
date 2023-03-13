package com.rangesliderpackageclassic;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.List;
import java.util.Map;

@ReactModule(name = RangeSliderClassicView.NAME)
public class RangeSliderClassicViewManager extends ViewGroupManager<RangeSliderClassicView> {
    @Override
    public String getName() {
        return RangeSliderClassicView.NAME;
    }

    @Override
    public void receiveCommand(RangeSliderClassicView root, String commandId, @Nullable ReadableArray args) {
        super.receiveCommand(root, commandId, args);

        switch (commandId) {
            case "setLeftKnobValueProgrammatically":
                final double leftKnobValue = args.getDouble(0);
                setLeftKnobValueProgrammatically(root, leftKnobValue);
                break;
            case "setRightKnobValueProgrammatically":
                final double rightKnobValue = args.getDouble(0);
                setRightKnobValueProgrammatically(root, rightKnobValue);
                break;
        }
    }

    @Override
    public RangeSliderClassicView createViewInstance(ThemedReactContext reactContext) {
        return new RangeSliderClassicView(reactContext);
    }

    @ReactProp(name = "activeColor", customType = "Color")
    public void setActiveColor(RangeSliderClassicView view, @Nullable Integer activeColor) {
        view.setActiveColor(activeColor);
    }

    @ReactProp(name = "inactiveColor", customType = "Color")
    public void setInactiveColor(RangeSliderClassicView view, @Nullable Integer inactiveColor) {
        view.setInactiveColor(inactiveColor);
    }

    @ReactProp(name = "minValue")
    public void setMinValue(RangeSliderClassicView view, double value) {
        view.setMinValue(value);
    }

    @ReactProp(name = "maxValue")
    public void setMaxValue(RangeSliderClassicView view, double value) {
        view.setMaxValue(value);
    }

    @ReactProp(name = "leftKnobValue")
    public void setLeftKnobValue(RangeSliderClassicView view, double value) {
        view.setLeftKnobValue(value);
    }

    @ReactProp(name = "rightKnobValue")
    public void setRightKnobValue(RangeSliderClassicView view, double value) {
        view.setRightKnobValue(value);
    }

    @ReactProp(name = "step")
    public void setStep(RangeSliderClassicView view, int step) {
        view.setStep(step);
    }

    private void setLeftKnobValueProgrammatically(RangeSliderClassicView view, double value) {
        view.setLeftKnobValue(value);
    }

    private void setRightKnobValueProgrammatically(RangeSliderClassicView view, double value) {
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
    public Map getExportedCustomDirectEventTypeConstants() {
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
