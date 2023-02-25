package com.conicgradientpackageclassic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;

import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.views.view.ReactViewGroup;

public class ConicGradientClassicView extends ReactViewGroup {
    private final ReactContext reactContext;

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();
    private final RectF mRect = new RectF();
    private int[] mColors = {Color.TRANSPARENT, Color.TRANSPARENT};
    private float[] mLocations = {0f, 0f};
    private Double mCenterPointX = 0.5;
    private Double mCenterPointY = 0.5;
    private int mWidth = 0;
    private int mHeight = 0;

    public static final String NAME = "ConicGradientClassicView";
    
    public ConicGradientClassicView(ReactContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

        /**
         * This will invoke internal `getOrCreateReactViewBackground` method
         * to initialize ReactViewBackgroundDrawable for this view,
         * if ReactViewBackgroundDrawable, then view will not draw the gradient
         */
        this.setBorderRadius(0f);
    }

    public void setColors(ReadableArray colors) {
        mColors = new int[colors.size()];
        for (int i = 0; i < colors.size(); i++) {
            if (colors.getType(i) == ReadableType.Map) {
                mColors[i] = ColorPropConverter.getColor(colors.getMap(i), reactContext);
            } else {
                mColors[i] = colors.getInt(i);
            }
        }
        prepareGradient();
    }

    public void setLocations(ReadableArray locations) {
        mLocations = new float[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            mLocations[i] = (float)locations.getDouble(i);
        }
        prepareGradient();
    }

    public void setCenterPoint(ReadableMap centerPoint) {
        mCenterPointX = 0.5;
        mCenterPointY = 0.5;
        if (centerPoint.hasKey("x") && !centerPoint.isNull("x")) {
            mCenterPointX = centerPoint.getDouble("x");
        }
        if (centerPoint.hasKey("y") && !centerPoint.isNull("y")) {
            mCenterPointY = centerPoint.getDouble("y");
        }
        prepareGradient();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        preparePath();
        prepareGradient();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawPath(mPath, mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void preparePath() {
        mPath.reset();
        mRect.set(
                0f,
                0f,
                (float) mWidth,
                (float) mHeight
        );
        mPath.addRect(mRect, Path.Direction.CW);
    }

    private void prepareGradient() {
        if (mColors.length != mLocations.length) {
            return;
        }
        mPaint.setShader(new SweepGradient(
                (float) (mCenterPointX * mWidth),
                (float) (mCenterPointY * mHeight),
                mColors,
                mLocations
        ));
        invalidate();
    }
}
