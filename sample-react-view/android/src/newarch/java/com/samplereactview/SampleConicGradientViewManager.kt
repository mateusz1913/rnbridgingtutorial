package com.samplereactview

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.SampleConicGradientViewManagerDelegate
import com.facebook.react.viewmanagers.SampleConicGradientViewManagerInterface
import com.facebook.react.views.view.ReactViewGroup
import com.facebook.react.views.view.ReactViewManager

@ReactModule(name = SampleConicGradientView.NAME)
class SampleConicGradientViewManager : ReactViewManager(), SampleConicGradientViewManagerInterface<ReactViewGroup> {
    private var mDelegate = SampleConicGradientViewManagerDelegate(this)

    override fun getName() = SampleConicGradientView.NAME

    override fun getDelegate(): ViewManagerDelegate<ReactViewGroup> = mDelegate

    override fun createViewInstance(reactContext: ThemedReactContext): SampleConicGradientView {
        return SampleConicGradientView(reactContext)
    }

    @ReactProp(name = "colors")
    override fun setColors(view: ReactViewGroup, colors: ReadableArray?) {
        check(view is SampleConicGradientView)
        if (colors == null) {
            return
        }
        view.setColors(colors)
    }

    @ReactProp(name = "locations")
    override fun setLocations(view: ReactViewGroup, locations: ReadableArray?) {
        check(view is SampleConicGradientView)
        if (locations == null) {
            return
        }
        view.setLocations(locations)
    }

    @ReactProp(name = "centerPoint")
    override fun setCenterPoint(view: ReactViewGroup, centerPoint: ReadableMap?) {
        check(view is SampleConicGradientView)
        if (centerPoint == null) {
            return
        }
        view.setCenterPoint(centerPoint)
    }
}
