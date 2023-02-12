package com.samplereactview

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.views.view.ReactViewManager

@ReactModule(name = SampleConicGradientView.NAME)
class SampleConicGradientViewManager : ReactViewManager() {
    override fun getName() = SampleConicGradientView.NAME

    override fun createViewInstance(reactContext: ThemedReactContext): SampleConicGradientView {
        return SampleConicGradientView(reactContext)
    }

    @ReactProp(name = "colors")
    override fun setColors(view: SampleConicGradientView, colors: ReadableArray?) {
        if (colors == null) {
            return
        }
        view.setColors(colors)
    }

    @ReactProp(name = "locations")
    override fun setLocations(view: SampleConicGradientView, locations: ReadableArray?) {
        if (locations == null) {
            return
        }
        view.setLocations(locations)
    }

    @ReactProp(name = "centerPoint")
    override fun setCenterPoint(view: SampleConicGradientView, centerPoint: ReadableMap?) {
        if (centerPoint == null) {
            return
        }
        view.setCenterPoint(centerPoint)
    }
}
