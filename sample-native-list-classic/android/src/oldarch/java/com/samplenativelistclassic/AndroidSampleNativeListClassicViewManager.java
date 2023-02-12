package com.samplenativelistclassic;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

@ReactModule(name = AndroidSampleNativeListClassicViewFragment.NAME)
public class AndroidSampleNativeListClassicViewManager extends SimpleViewManager<FragmentContainerView> {
  private var mHeight: Int = 0;
  private var mWidth: Int = 0;
  
  @Override
  public String getName() {
    return AndroidSampleNativeListClassicViewFragment.NAME;
  }

  @Override
  public void receiveCommand(FragmentContainerView root, String commandId, @Nullable ReadableArray args) {
    super.receiveCommand(root, commandId, args);

    switch (commandId) {
      case "scrollToItem":
        final int index = args.getInt(0);
        scrollToItem(root, index);
        break;
    }
  }

  @Override
  public FragmentContainerView createViewInstance(ThemedReactContext reactContext) {
    return new FragmentContainerView(reactContext);
  }

  @Override
  public void onDropViewInstance(FragmentContainerView view) {
    unmountFragment(view);

    super.onDropViewInstance(view);
  }

  @Override
  protected void addEventEmitters(ThemedReactContext reactContext, FragmentContainerView view) {
    super.addEventEmitters(reactContext, view);
    // Mount fragment here, because here the view already has reactTag set as a view.id
    mountFragment(view);
  }

  @ReactProp(name = "data")
  public void setData(FragmentContainerView view, @Nullable ReadableArray data) {
    if (data == null) {
      return;
    }
    final FragmentManager fragmentManager = getFragmentManager(view);

    if (fragmentManager != null) {
      final AndroidSampleNativeListClassicViewFragment fragment = findFragment(fragmentManager, view);

      if (fragment != null) {
        fragment.setData(data);
      }
    }
  }

  @ReactProp(name = "options")
  public void setOptions(FragmentContainerView view, @Nullable ReadableMap options) {
    if (options == null) {
      return;
    }
    final FragmentManager fragmentManager = getFragmentManager(view);

    if (fragmentManager != null) {
      final AndroidSampleNativeListClassicViewFragment fragment = findFragment(fragmentManager, view);

      if (fragment != null) {
        fragment.setOptions(options);
      }
    }
  }

  private void scrollToItem(FragmentContainerView view, int index) {
    final FragmentManager fragmentManager = getFragmentManager(view);

    if (fragmentManager != null) {
      final AndroidSampleNativeListClassicViewFragment fragment = findFragment(fragmentManager, view);

      if (fragment != null) {
        fragment.scrollToItem(index);
      }
    }
  }

  @ReactProp(name = "backgroundColor", customType = "Color")
  public void setBackgroundColor(FragmentContainerView view, @Nullable Integer backgroundColor) {
    final FragmentManager fragmentManager = getFragmentManager(view);

    if (fragmentManager != null) {
      final AndroidSampleNativeListClassicViewFragment fragment = findFragment(fragmentManager, view);

      if (fragment != null) {
        fragment.setBackgroundColor(backgroundColor);
      }
    }
  }

  @ReactPropGroup(names = {"width", "height"}, customType = "Style")
  public void setStyle(FragmentContainerView view, int index, Dynamic value) {
    if (value == null) {
      return;
    }

    if (index == 0) {
      mWidth = (int)PixelUtil.toPixelFromDIP(value.asDouble());
    }

    if (index == 1) {
      mHeight = (int)PixelUtil.toPixelFromDIP(value.asDouble());
    }

    view.post(() -> layoutChildren(view));
  }

  private void mountFragment(FragmentContainerView view) {
    UiThreadUtil.assertOnUiThread();
    final FragmentManager fragmentManager = getFragmentManager(view);

    if (fragmentManager != null) {
      final AndroidSampleNativeListClassicViewFragment fragment = findFragment(fragmentManager, view);

      if (fragment != null) {
        view.post(() -> layoutChildren(view));
        return;
      }

      final AndroidSampleNativeListClassicViewFragment newFragment = new AndroidSampleNativeListClassicViewFragment();
      view.removeAllViews();
      final FragmentTransaction transaction = fragmentManager.beginTransaction();
      transaction.add(newFragment, getFragmentTag(view));
      transaction.runOnCommit(() -> {
        view.addView(newFragment.requireView());
        layoutChildren(view);
      });
      transaction.commitNowAllowingStateLoss();
    }
  }

  private void unmountFragment(FragmentContainerView view) {
    UiThreadUtil.assertOnUiThread();
    final FragmentManager fragmentManager = getFragmentManager(view);

    if (fragmentManager != null) {
      final AndroidSampleNativeListClassicViewFragment fragment = findFragment(fragmentManager, view);

      if (fragment != null) {
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commitNowAllowingStateLoss();
      }
    }
  }

  private void layoutChildren(View view) {
    final int width = mWidth;
    final int height = mHeight;

    view.measure(
      View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
      View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
    );
    view.layout(0, 0, width, height);
  }

  private AndroidSampleNativeListClassicViewFragment findFragment(fragmentManager: FragmentManager, view: View) {
    return (AndroidSampleNativeListClassicViewFragment)fragmentManager.findFragmentByTag(getFragmentTag(view));
  }

  @Nullable
  private FragmentManager getFragmentManager(View view) {
    final ThemedReactContext reactContext = view.getContext();

    if (reactContext == null) {
      return null;
    }

    final FragmentActivity activity = reactContext.getCurrentActivity();
    
    if (activity == null) {
      return null;
    }

    return activity.getSupportFragmentManager();
  }

  private String getFragmentTag(View view) {
    return "AndroidSampleNativeListClassicViewFragment-" + view.getId();
  }
}
