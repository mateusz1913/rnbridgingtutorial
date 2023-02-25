package com.conicgradientpackage

import android.graphics.*
import com.facebook.react.bridge.ColorPropConverter
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.ReadableType
import com.facebook.react.views.view.ReactViewGroup

class ConicGradientView(private val reactContext: ReactContext) : ReactViewGroup(reactContext) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mPath = Path()
    private var mRect = RectF()
    private var mColors = mutableListOf(Color.RED, Color.YELLOW)
    private var mLocations = mutableListOf(0f, 1f)
    private var mCenterPointX = 0.5
    private var mCenterPointY = 0.5
    private var mWidth = 0
    private var mHeight = 0

    init {
        /**
        * This will invoke internal `getOrCreateReactViewBackground` method
        * to initialize ReactViewBackgroundDrawable for this view,
        * if ReactViewBackgroundDrawable, then view will not draw the gradient
        */
        setBorderRadius(0f)
    }

    fun setColors(colors: ReadableArray) {
        mColors.clear()
        for (i in 0 until colors.size()) {
            if (colors.getType(i) == ReadableType.Map) {
                mColors.add(i, ColorPropConverter.getColor(colors.getMap(i), reactContext))
            } else {
                mColors.add(i, colors.getInt(i))
            }
        }
        prepareGradient()
    }

    fun setLocations(locations: ReadableArray) {
        mLocations.clear()
        for (i in 0 until locations.size()) {
            mLocations.add(i, locations.getDouble(i).toFloat())
        }
        prepareGradient()
    }

    fun setCenterPoint(centerPoint: ReadableMap) {
        mCenterPointX = if (centerPoint.hasKey("x") && !centerPoint.isNull("x")) {
            centerPoint.getDouble("x")
        } else {
            0.5
        }
        mCenterPointY = if (centerPoint.hasKey("y") && !centerPoint.isNull("y")) {
            centerPoint.getDouble("y")
        } else {
            0.5
        }
        prepareGradient()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        preparePath()
        prepareGradient()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        canvas?.drawPath(mPath, mPaint)
        super.dispatchDraw(canvas)
    }

    private fun preparePath() {
        mPath.reset()
        mRect.set(
            0f,
            0f,
            mWidth.toFloat(),
            mHeight.toFloat()
        )
        mPath.addRect(mRect, Path.Direction.CW)
    }

    private fun prepareGradient() {
        if (mColors.size != mLocations.size) {
            return
        }
        mPaint.shader = SweepGradient(
            (mCenterPointX * mWidth).toFloat(),
            (mCenterPointY * mHeight).toFloat(),
            mColors.toIntArray(),
            mLocations.toFloatArray()
        )
        invalidate()
    }

    companion object {
        const val NAME = "ConicGradientView"
    }
}
