package com.sampleeventmoduleclassic;

import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Objects;

/**
 * Native module's shared implementation
 */
public class SampleScreenOrientationClassicModuleImpl {
  private final ReactApplicationContext reactContext;

  public static final String NAME = "SampleScreenOrientationClassicModule";
  public static final String EVENT_NAME = "onSampleScreenOrientationClassicModuleChange";
  public static final String EVENT_KEY = "value";

  public SampleScreenOrientationClassicModuleImpl(ReactApplicationContext reactContext) {
    this.reactContext = reactContext;
  }

  /**
   * Example usage:
   * 
   * ```java
   * WritableMap payload = Arguments.createMap();
   * payload.putDouble(EVENT_KEY, 42);
   * sendEvent(EVENT_NAME, payload);
   * ```
   */
  private void sendEvent(String eventName, WritableMap params) {
    reactContext
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, params);
  }

  private OrientationEventListener mOrientationDidChangeListener = null;
  private String mLastOrientation = "unknown";

  public void onInitialize() {
    mOrientationDidChangeListener = new OrientationEventListener(reactContext, SensorManager.SENSOR_DELAY_NORMAL) {
      @Override
      public void onOrientationChanged(int orientation) {
        String screenOrientation;
        if (orientation > 315 || orientation < 45 || (orientation > 135 && orientation < 225)) {
          screenOrientation = "portrait";
        } else {
          screenOrientation = "landscape";
        }

        if (Objects.equals(mLastOrientation, screenOrientation)) {
          return;
        }
        mLastOrientation = screenOrientation;

        WritableMap payload = Arguments.createMap();
        payload.putString("orientation", screenOrientation);
        sendEvent(EVENT_NAME, payload);
      }
    };
    mOrientationDidChangeListener.enable();
  }

  public void onInvalidate() {
    if (mOrientationDidChangeListener != null) {
      mOrientationDidChangeListener.disable();
    }
    mOrientationDidChangeListener = null;
  }
}
