package com.samplenativesliderclassic;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.List;

@ReactModule(name = SampleNativeSliderClassicView.NAME)
public class SampleNativeSliderClassicViewManager extends ViewGroupManager<SampleNativeSliderClassicView> {
    @Override
    public String getName() {
        return SampleNativeSliderClassicView.NAME;
    }

    @Override
    public void receiveCommand(SampleNativeSliderClassicView root, String commandId, @Nullable ReadableArray args) {
        super.receiveCommand(root, commandId, args);

        switch (commandId) {
            case "setLeftKnobValueProgrammatically":
                final int value = args.getInt(0);
                setLeftKnobValueProgrammatically(root, value);
                break;
            case "setRightKnobValueProgrammatically":
                final int value = args.getInt(0);
                setRightKnobValueProgrammatically(root, value);
                break;
        }
    }

    @Override
    public SampleNativeSliderClassicView createViewInstance(ThemedReactContext reactContext) {
        return new SampleNativeSliderClassicView(reactContext);
    }

    @ReactProp(name = "activeColor", customType = "Color")
    public void setActiveColor(SampleNativeSliderClassicView view, @Nullable Integer activeColor) {
        view.setActiveColor(activeColor);
    }

    @ReactProp(name = "inactiveColor", customType = "Color")
    public void setInactiveColor(SampleNativeSliderClassicView view, @Nullable Integer inactiveColor) {
        view.setInactiveColor(inactiveColor);
    }

    @ReactProp(name = "minValue")
    public void setMinValue(SampleNativeSliderClassicView view, double value) {
        view.setMinValue(value);
    }

    @ReactProp(name = "maxValue")
    public void setMaxValue(SampleNativeSliderClassicView view, double value) {
        view.setMaxValue(value);
    }

    @ReactProp(name = "leftKnobValue")
    public void setLeftKnobValue(SampleNativeSliderClassicView view, double value) {
        view.setLeftKnobValue(value);
    }

    @ReactProp(name = "rightKnobValue")
    public void setRightKnobValue(SampleNativeSliderClassicView view, double value) {
        view.setRightKnobValue(value);
    }

    @ReactProp(name = "step")
    public void setStep(SampleNativeSliderClassicView view, int step) {
        view.setStep(step);
    }

    private void setLeftKnobValueProgrammatically(SampleNativeSliderClassicView view, double value) {
        view.setLeftKnobValue(value);
    }

    private void setRightKnobValueProgrammatically(SampleNativeSliderClassicView view, double value) {
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
                            view.getId(),
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
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
            OnSampleNativeSliderClassicViewValueChangeEvent.NAME,
            MapBuilder.of("registrationName", OnSampleNativeSliderClassicViewValueChangeEvent.EVENT_PROP_NAME)
            OnSampleNativeSliderClassicViewBeginDragEvent.NAME,
            MapBuilder.of("registrationName", OnSampleNativeSliderClassicViewBeginDragEvent.EVENT_PROP_NAME)
            OnSampleNativeSliderClassicViewEndDragEvent.NAME,
            MapBuilder.of("registrationName", OnSampleNativeSliderClassicViewEndDragEvent.EVENT_PROP_NAME)
        );
    }
}
