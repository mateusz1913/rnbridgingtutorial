package com.rnbridgingtutorial

import android.app.Application
import android.content.Context
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.config.ReactFeatureFlags
import com.facebook.soloader.SoLoader
import com.rnbridgingtutorial.newarchitecture.MainApplicationReactNativeHost
import java.lang.reflect.InvocationTargetException

class MainApplication : Application(), ReactApplication {
  private val mReactNativeHost = object : ReactNativeHost(this) {
    override fun getUseDeveloperSupport(): Boolean {
      return BuildConfig.DEBUG
    }

    override fun getPackages(): MutableList<ReactPackage> {
      return PackageList(this).packages.apply {
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // add(MyReactNativePackage())
      }
    }

    override fun getJSMainModuleName(): String {
      return "index"
    }
  }

  private val mNewArchitectureNativeHost: ReactNativeHost = MainApplicationReactNativeHost(this)

  override fun getReactNativeHost(): ReactNativeHost {
    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      return mNewArchitectureNativeHost
    } else {
      return mReactNativeHost
    }
  }

  override fun onCreate() {
    super.onCreate()
    // If you opted-in for the New Architecture, we enable the TurboModule system
    ReactFeatureFlags.useTurboModules = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
    SoLoader.init(this, /* native exopackage */ false)
    initializeFlipper(this, reactNativeHost.reactInstanceManager)
  }

  companion object {
    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, reactNativeHost.reactInstanceManager)
     *
     * @param context
     * @param reactInstanceManager
     */
    private fun initializeFlipper(
      context: Context,
      reactInstanceManager: ReactInstanceManager
    ) {
      if (BuildConfig.DEBUG) {
        try {
          val aClass = Class.forName("com.rnbridgingtutorial.ReactNativeFlipper")
          aClass
            .getMethod(
              "initializeFlipper",
              Context::class.java,
              ReactInstanceManager::class.java
            )
            .invoke(null, context, reactInstanceManager)
        } catch (e: ClassNotFoundException) {
          e.printStackTrace()
        } catch (e: NoSuchMethodException) {
          e.printStackTrace()
        } catch (e: IllegalAccessException) {
          e.printStackTrace()
        } catch (e: InvocationTargetException) {
          e.printStackTrace()
        }
      }
    }
  }
}
