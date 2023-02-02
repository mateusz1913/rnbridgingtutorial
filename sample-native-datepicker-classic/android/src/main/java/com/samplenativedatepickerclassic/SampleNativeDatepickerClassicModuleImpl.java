package com.samplenativedatepickerclassic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.material.datepicker.MaterialDatePicker;
import java.util.*;

/**
 * Native module's shared implementation
 */
public class SampleNativeDatepickerClassicModuleImpl {
  private final ReactApplicationContext reactContext;
  
  @Nullable
  private Callback mCallback = null;

  public static final String NAME = "SampleNativeDatepickerClassicModule";

  interface OnCancelFunction {
    void run();
  }

  interface OnErrorFunction {
    void run(Exception e);
  }

  interface OnResultFunction {
    void run(WritableMap result);
  }

  public SampleNativeDatepickerClassicModuleImpl(ReactApplicationContext reactContext) {
    this.reactContext = reactContext;
  }

  public void showRangeDatepickerWithCallback(String title, Callback onResult) {
    mCallback = onResult;
    showRangeDatepicker(
      title,
      () -> {
        if (mCallback != null) {
          mCallback.invoke(null);
        }
        mCallback = null;
      },
      (error) -> {
        if (mCallback != null) {
          mCallback.invoke(null);
        }
        mCallback = null;
      },
      (result) -> {
        if (mCallback != null) {
          mCallback.invoke(result);
        }
        mCallback = null;
      }
    );
  }

  public void showRangeDatepickerWithPromise(ReadableMap config, Promise promise) {
    showRangeDatepicker(
      config.getString("title"),
      () -> {
        promise.resolve(null);
      },
      (error) -> {
        promise.reject(error);
      },
      (result) -> {
        promise.resolve(result);
      }
    );
  }

  private void showRangeDatepicker(
    String title,
    OnCancelFunction onCancel,
    OnErrorFunction onError,
    OnResultFunction onResult
  ) {
    AppCompatActivity activity = (AppCompatActivity)reactContext.getCurrentActivity();
    if (activity == null) {
      onError.run(new Exception("No activity"));
      return;
    }

    MaterialDatePicker<Pair<Long, Long>> picker = MaterialDatePicker.Builder.dateRangePicker()
      .setTitleText(title)
      .build();
    picker.addOnCancelListener((dialog) -> { onCancel.run(); });
    picker.addOnDismissListener((dialog) -> { onCancel.run(); });
    picker.addOnNegativeButtonClickListener((dialog) -> { onCancel.run(); });
    picker.addOnPositiveButtonClickListener((result) -> {
      Calendar fromCalendar = Calendar.getInstance();
      fromCalendar.setTimeInMillis(result.first);
      int fromYear = fromCalendar.get(Calendar.YEAR);
      int fromMonth = fromCalendar.get(Calendar.MONTH);
      int fromDay = fromCalendar.get(Calendar.DAY_OF_MONTH);
      Calendar toCalendar = Calendar.getInstance();
      toCalendar.setTimeInMillis(result.second);
      int toYear = toCalendar.get(Calendar.YEAR);
      int toMonth = toCalendar.get(Calendar.MONTH);
      int toDay = toCalendar.get(Calendar.DAY_OF_MONTH);

      WritableMap payload = Arguments.createMap();
      WritableMap from = Arguments.createMap();
      from.putInt("day", fromDay);
      from.putInt("month", fromMonth + 1);
      from.putInt("year", fromYear);
      payload.putMap("from", from);
      WritableMap to = Arguments.createMap();
      to.putInt("day", toDay);
      to.putInt("month", toMonth + 1);
      to.putInt("year", toYear);
      payload.putMap("to", to);

      onResult.run(payload);
    });

    UiThreadUtil.runOnUiThread(() -> {
      picker.show(activity.getSupportFragmentManager(), NAME);
    });
  }
}
