package com.rangesliderpackageclassic;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.slider.RangeSlider;

public class RangeSliderClassicView extends FrameLayout {
    private final ReactContext reactContext;

    private final RangeSlider slider;
    private float mLastLeftKnobValue = 0f;
    private float mLastRightKnobValue = 1f;

    public static final String NAME = "RangeSliderClassicView";
  
    public RangeSliderClassicView(ReactContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.slider = new RangeSlider(reactContext);
        this.slider.setTrackHeight((int) PixelUtil.toPixelFromDIP(10f));
        this.slider.setThumbTintList(ColorStateList.valueOf(Color.BLUE));
        this.slider.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull RangeSlider slider) {
                sendOnRangeSliderClassicViewBeginDragEvent();
            }

            @Override
            public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                sendOnRangeSliderClassicViewEndDragEvent((double) slider.getValues().get(0), (double) slider.getValues().get(1));
            }
        });
        this.slider.addOnChangeListener(
                (slider, value, fromUser) -> {
                    float newLeftKnobValue = slider.getValues().get(0);
                    float newRightKnobValue = slider.getValues().get(1);
                    if (
                        Math.abs(newLeftKnobValue - mLastLeftKnobValue) < 0.1f &&
                        Math.abs(newRightKnobValue - mLastRightKnobValue) < 0.1f
                    ) {
                        return;
                    }
                    mLastLeftKnobValue = newLeftKnobValue;
                    mLastRightKnobValue = newRightKnobValue;
                    sendOnRangeSliderClassicViewValueChangeEvent(newLeftKnobValue, newRightKnobValue);
                }
        );
        this.addView(this.slider, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    public interface OnRangeSliderClassicViewListener {
        void onRangeSliderClassicViewBeginDrag();
        void onRangeSliderClassicViewEndDrag(double leftKnobValue, double rightKnobValue);
        void onRangeSliderClassicViewValueChange(double leftKnobValue, double rightKnobValue);
    }

    private @Nullable OnRangeSliderClassicViewListener mListener = null;

    public void setOnRangeSliderClassicViewListener(@Nullable OnRangeSliderClassicViewListener listener) {
        mListener = listener;
    }

    public void setActiveColor(@Nullable Integer activeColor) {
        int newColor = Color.BLUE;
        if (activeColor != null) {
            newColor = activeColor;
        }
        slider.setTrackActiveTintList(ColorStateList.valueOf(newColor));
    }

    public void setInactiveColor(@Nullable Integer inactiveColor) {
        int newColor = Color.GRAY;
        if (inactiveColor != null) {
            newColor = inactiveColor;
        }
        slider.setTrackInactiveTintList(ColorStateList.valueOf(newColor));
    }

    public void setMinValue(double minValue) {
        slider.setValueFrom((float) minValue);
    }

    public void setMaxValue(double maxValue) {
        slider.setValueTo((float) maxValue);
    }

    public void setLeftKnobValue(double leftKnobValue) {
        if (Double.isNaN(leftKnobValue)) {
            return;
        }
        float rightKnobValue = slider.getValues().get(1);
        slider.setValues((float) leftKnobValue, rightKnobValue);
    }

    public void setRightKnobValue(double rightKnobValue) {
        if (Double.isNaN(rightKnobValue)) {
            return;
        }
        float leftKnobValue = slider.getValues().get(0);
        slider.setValues(leftKnobValue, (float) rightKnobValue);
    }

    public void setStep(int step) {
        slider.setStepSize((float) step);
    }

    private void sendOnRangeSliderClassicViewValueChangeEvent(double leftKnobValue, double rightKnobValue) {
        @Nullable final OnRangeSliderClassicViewListener listener = mListener;
        if (listener != null) {
            listener.onRangeSliderClassicViewValueChange(leftKnobValue, rightKnobValue);
        }
    }

    private void sendOnRangeSliderClassicViewBeginDragEvent() {
        @Nullable final OnRangeSliderClassicViewListener listener = mListener;
        if (listener != null) {
            listener.onRangeSliderClassicViewBeginDrag();
        }
    }

    private void sendOnRangeSliderClassicViewEndDragEvent(double leftKnobValue, double rightKnobValue) {
        @Nullable final OnRangeSliderClassicViewListener listener = mListener;
        if (listener != null) {
            listener.onRangeSliderClassicViewEndDrag(leftKnobValue, rightKnobValue);
        }
    }
}
