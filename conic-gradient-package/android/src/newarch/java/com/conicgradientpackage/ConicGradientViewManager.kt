package com.conicgradientpackage

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.ConicGradientViewManagerDelegate
import com.facebook.react.viewmanagers.ConicGradientViewManagerInterface
import com.facebook.react.views.view.ReactViewGroup
import com.facebook.react.views.view.ReactViewManager

@ReactModule(name = ConicGradientView.NAME)
class ConicGradientViewManager : ReactViewManager(), ConicGradientViewManagerInterface<ReactViewGroup> {
    private var mDelegate = ConicGradientViewManagerDelegate(this)

    override fun getName() = ConicGradientView.NAME

    override fun getDelegate(): ViewManagerDelegate<ReactViewGroup> = mDelegate

    override fun createViewInstance(reactContext: ThemedReactContext): ConicGradientView {
        return ConicGradientView(reactContext)
    }

    @ReactProp(name = "colors")
    override fun setColors(view: ReactViewGroup, colors: ReadableArray?) {
        check(view is ConicGradientView)
        if (colors == null) {
            return
        }
        view.setColors(colors)
    }

    @ReactProp(name = "locations")
    override fun setLocations(view: ReactViewGroup, locations: ReadableArray?) {
        check(view is ConicGradientView)
        if (locations == null) {
            return
        }
        view.setLocations(locations)
    }

    @ReactProp(name = "centerPoint")
    override fun setCenterPoint(view: ReactViewGroup, centerPoint: ReadableMap?) {
        check(view is ConicGradientView)
        if (centerPoint == null) {
            return
        }
        view.setCenterPoint(centerPoint)
    }
}
