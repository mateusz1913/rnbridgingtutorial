package com.rnbridgingtutorial.samplenativemodule

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.PixelUtil
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.annotations.ReactPropGroup
import com.facebook.react.viewmanagers.FragmentCustomViewManagerDelegate
import com.facebook.react.viewmanagers.FragmentCustomViewManagerInterface

class SampleFragmentCustomViewManager: SimpleViewManager<FragmentContainerView>(), FragmentCustomViewManagerInterface<FragmentContainerView> {
    private val mDelegate: ViewManagerDelegate<FragmentContainerView> = FragmentCustomViewManagerDelegate(this)

    private var mHeight: Int = 0
    private var mWidth: Int = 0

    override fun getName(): String {
        return "FragmentCustomView"
    }

    override fun getDelegate() = mDelegate

    override fun createViewInstance(reactContext: ThemedReactContext): FragmentContainerView {
        return FragmentContainerView(reactContext)
    }

    override fun onDropViewInstance(view: FragmentContainerView) {
        unmountFragment(view)

        super.onDropViewInstance(view)
    }

    override fun addEventEmitters(reactContext: ThemedReactContext, view: FragmentContainerView) {
        super.addEventEmitters(reactContext, view)
        // Mount fragment here, because here the view already has reactTag set as a view.id
        mountFragment(view)
    }

    @ReactProp(name = "backgroundColor", customType = "Color")
    fun setBackgroundColor(view: FragmentContainerView, backgroundColor: Int?) {
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {

            findFragment(fragmentManager, view)?.setBackgroundColor(backgroundColor)
        }
    }

    @ReactPropGroup(names = ["width", "height"], customType = "Style")
    fun setStyle(view: FragmentContainerView, index: Int, value: Dynamic?) {
        if (value == null) {
            return
        }

        if (index == 0) {
            mWidth = PixelUtil.toPixelFromDIP(value.asDouble()).toInt()
        }

        if (index == 1) {
            mHeight = PixelUtil.toPixelFromDIP(value.asDouble()).toInt()
        }

        view.post {
            layoutChildren(view)
        }
    }

    private fun mountFragment(view: FragmentContainerView) {
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            val fragment = findFragment(fragmentManager, view)

            if (fragment != null) {
                view.post {
                    layoutChildren(view)
                }
                return
            }
            val newFragment = SampleFragment()
            view.removeAllViews()
            val transaction = fragmentManager.beginTransaction()
            transaction.add(newFragment, getFragmentTag(view))
            transaction.runOnCommit {
                view.addView(newFragment.requireView())
                layoutChildren(view)
            }
            transaction.commit()
        }
    }

    private fun unmountFragment(view: FragmentContainerView) {
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            val fragment = findFragment(fragmentManager, view)

            if (fragment != null) {
                val transaction = fragmentManager.beginTransaction()
                transaction.remove(fragment)
                transaction.commitNow()
            }
        }
    }

    private fun layoutChildren(view: View) {
        val width = mWidth
        val height = mHeight

        view.measure(
            View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        )
        view.layout(0, 0, width, height)
    }

    private fun findFragment(fragmentManager: FragmentManager, view: View): SampleFragment? {
        return fragmentManager.findFragmentByTag(getFragmentTag(view)) as? SampleFragment
    }

    private fun getFragmentManager(view: View): FragmentManager? {
        val reactContext = view.context as? ThemedReactContext ?: return null
        val activity = reactContext.currentActivity as? FragmentActivity
        return activity?.supportFragmentManager
    }

    private fun getFragmentTag(view: View) = "FragmentCustomView-" + view.id
}
