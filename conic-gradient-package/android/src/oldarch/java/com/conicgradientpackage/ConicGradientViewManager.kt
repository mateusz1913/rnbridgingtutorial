package com.conicgradientpackage

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.views.view.ReactViewManager

@ReactModule(name = ConicGradientView.NAME)
class ConicGradientViewManager : ReactViewManager() {
    override fun getName() = ConicGradientView.NAME

    override fun createViewInstance(reactContext: ThemedReactContext): ConicGradientView {
        return ConicGradientView(reactContext)
    }

    @ReactProp(name = "colors")
    fun setColors(view: ConicGradientView, colors: ReadableArray?) {
        if (colors == null) {
            return
        }
        view.setColors(colors)
    }

    @ReactProp(name = "locations")
    fun setLocations(view: ConicGradientView, locations: ReadableArray?) {
        if (locations == null) {
            return
        }
        view.setLocations(locations)
    }

    @ReactProp(name = "centerPoint")
    fun setCenterPoint(view: ConicGradientView, centerPoint: ReadableMap?) {
        if (centerPoint == null) {
            return
        }
        view.setCenterPoint(centerPoint)
    }
}
