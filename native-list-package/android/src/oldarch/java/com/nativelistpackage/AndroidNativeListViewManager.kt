package com.nativelistpackage

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.facebook.react.bridge.Dynamic
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.UiThreadUtil
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.PixelUtil
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.annotations.ReactPropGroup

@ReactModule(name = AndroidNativeListViewFragment.NAME)
class AndroidNativeListViewManager : SimpleViewManager<FragmentContainerView>() {
    private var mHeight: Int = 0
    private var mWidth: Int = 0
  
    override fun getName() = AndroidNativeListViewFragment.NAME

    override fun receiveCommand(root: FragmentContainerView, commandId: String?, args: ReadableArray?) {
        super.receiveCommand(root, commandId, args)

        when (commandId) {
            "scrollToItem" -> {
                val index = args!!.getInt(0)
                scrollToItem(root, index)
            }
        }
    }

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

    @ReactProp(name = "data")
    fun setData(view: FragmentContainerView, data: ReadableArray?) {
        if (data == null) {
            return
        }
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            findFragment(fragmentManager, view)?.setData(data)
        }
    }

    @ReactProp(name = "options")
    fun setOptions(view: FragmentContainerView, options: ReadableMap?) {
        if (options == null) {
            return
        }
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            findFragment(fragmentManager, view)?.setOptions(options)
        }
    }

    private fun scrollToItem(view: FragmentContainerView, index: Int) {
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            findFragment(fragmentManager, view)?.scrollToItem(index)
        }
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
        UiThreadUtil.assertOnUiThread()
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            val fragment = findFragment(fragmentManager, view)

            if (fragment != null) {
                view.post {
                    layoutChildren(view)
                }
                return
            }

            val newFragment = AndroidNativeListViewFragment()
            view.removeAllViews()
            val transaction = fragmentManager.beginTransaction()
            transaction.add(newFragment, getFragmentTag(view))
            transaction.runOnCommit {
                view.addView(newFragment.requireView())
                layoutChildren(view)
            }
            transaction.commitNowAllowingStateLoss()
        }
    }

    private fun unmountFragment(view: FragmentContainerView) {
        UiThreadUtil.assertOnUiThread()
        val fragmentManager = getFragmentManager(view)

        if (fragmentManager != null) {
            val fragment = findFragment(fragmentManager, view)

            if (fragment != null) {
                val transaction = fragmentManager.beginTransaction()
                transaction.remove(fragment)
                transaction.commitNowAllowingStateLoss()
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

    private fun findFragment(fragmentManager: FragmentManager, view: View): AndroidNativeListViewFragment? {
        return fragmentManager.findFragmentByTag(getFragmentTag(view)) as? AndroidNativeListViewFragment
    }

    private fun getFragmentManager(view: View): FragmentManager? {
        val reactContext = view.context as? ThemedReactContext ?: return null
        val activity = reactContext.currentActivity as? FragmentActivity ?: return null

        return activity.supportFragmentManager
    }

    private fun getFragmentTag(view: View) = "AndroidNativeListViewFragment-" + view.id
}
