package com.appinfopackageclassic;

import androidx.annotation.Nullable;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

import java.util.HashMap;
import java.util.Map;

public class AppInfoClassicTurboPackage extends TurboReactPackage {
    /**
     * Initialize and export modules based on the name of the required module
     */
    @Override
    @Nullable
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        if (name.equals(AppInfoModuleClassic.NAME)) {
            return new AppInfoModuleClassic(reactContext);
        }
        return null;
    }

    /**
     * Declare info about exported modules
     */
    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        /**
         * Here declare the array of exported modules
         */
        Class<? extends NativeModule>[] moduleList = new Class[] {
            AppInfoModuleClassic.class
        };
        final Map<String, ReactModuleInfo> reactModuleInfoMap = new HashMap<>();
        /**
         * And here just iterate on that array and produce the info provider instance
         */
        for (Class<? extends NativeModule> moduleClass : moduleList) {
            ReactModule reactModule = moduleClass.getAnnotation(ReactModule.class);

            reactModuleInfoMap.put(
                reactModule.name(),
                new ReactModuleInfo(
                    reactModule.name(),
                    moduleClass.getName(),
                    true,
                    reactModule.needsEagerInit(),
                    reactModule.hasConstants(),
                    reactModule.isCxxModule(),
                    TurboModule.class.isAssignableFrom(moduleClass)
                )
            );
        }

        return new ReactModuleInfoProvider() {
            @Override
            public Map<String, ReactModuleInfo> getReactModuleInfos() {
                return reactModuleInfoMap;
            }
        };
    }
}
