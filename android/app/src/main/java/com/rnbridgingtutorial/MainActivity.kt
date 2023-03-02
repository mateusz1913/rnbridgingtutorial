package com.rnbridgingtutorial

import android.os.Bundle
import androidx.core.view.WindowCompat
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint
import com.facebook.react.defaults.DefaultReactActivityDelegate
import com.samplenativescreen.SampleNativeScreenModuleImpl
import com.samplenativescreenclassic.SampleNativeScreenClassicModuleImpl
import com.savefilepickerpackage.SaveFilePickerModuleImpl
import com.savefilepickerpackageclassic.SaveFilePickerClassicModuleImpl

class MainActivity : ReactActivity() {

    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    override fun getMainComponentName(): String {
        return "rnbridgingtutorial"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
        SampleNativeScreenModuleImpl.registerActivityLauncher(this)
        SampleNativeScreenClassicModuleImpl.registerActivityLauncher(this)
        SaveFilePickerModuleImpl.registerActivityLauncher(this)
        SaveFilePickerClassicModuleImpl.registerActivityLauncher(this)
        WindowCompat.setDecorFitsSystemWindows(this.window, false)
    }

    /**
     * Returns the instance of the {@link ReactActivityDelegate}. Here we use a util class {@link
     * DefaultReactActivityDelegate} which allows you to easily enable Fabric and Concurrent React
     * (aka React 18) with two boolean flags.
     */
    override fun createReactActivityDelegate(): ReactActivityDelegate {
        return DefaultReactActivityDelegate(
            this,
            mainComponentName,
            // If you opted-in for the New Architecture, we enable the Fabric Renderer.
            DefaultNewArchitectureEntryPoint.fabricEnabled, // fabricEnabled
            // If you opted-in for the New Architecture, we enable Concurrent React (i.e. React 18).
            DefaultNewArchitectureEntryPoint.concurrentReactEnabled // concurrentRootEnabled
        )
    }
}
