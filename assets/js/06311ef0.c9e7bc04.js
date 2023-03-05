"use strict";(self.webpackChunkbridging_tutorial_website=self.webpackChunkbridging_tutorial_website||[]).push([[6598],{5162:(e,n,t)=>{t.d(n,{Z:()=>l});var a=t(7294),o=t(6010);const r={tabItem:"tabItem_Ymn6"};function l(e){let{children:n,hidden:t,className:l}=e;return a.createElement("div",{role:"tabpanel",className:(0,o.Z)(r.tabItem,l),hidden:t},n)}},4866:(e,n,t)=>{t.d(n,{Z:()=>I});var a=t(7462),o=t(7294),r=t(6010),l=t(2466),i=t(6550),p=t(1980),d=t(7392),c=t(12);function u(e){return function(e){return o.Children.map(e,(e=>{if((0,o.isValidElement)(e)&&"value"in e.props)return e;throw new Error(`Docusaurus error: Bad <Tabs> child <${"string"==typeof e.type?e.type:e.type.name}>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.`)}))}(e).map((e=>{let{props:{value:n,label:t,attributes:a,default:o}}=e;return{value:n,label:t,attributes:a,default:o}}))}function s(e){const{values:n,children:t}=e;return(0,o.useMemo)((()=>{const e=n??u(t);return function(e){const n=(0,d.l)(e,((e,n)=>e.value===n.value));if(n.length>0)throw new Error(`Docusaurus error: Duplicate values "${n.map((e=>e.value)).join(", ")}" found in <Tabs>. Every value needs to be unique.`)}(e),e}),[n,t])}function m(e){let{value:n,tabValues:t}=e;return t.some((e=>e.value===n))}function g(e){let{queryString:n=!1,groupId:t}=e;const a=(0,i.k6)(),r=function(e){let{queryString:n=!1,groupId:t}=e;if("string"==typeof n)return n;if(!1===n)return null;if(!0===n&&!t)throw new Error('Docusaurus error: The <Tabs> component groupId prop is required if queryString=true, because this value is used as the search param name. You can also provide an explicit value such as queryString="my-search-param".');return t??null}({queryString:n,groupId:t});return[(0,p._X)(r),(0,o.useCallback)((e=>{if(!r)return;const n=new URLSearchParams(a.location.search);n.set(r,e),a.replace({...a.location,search:n.toString()})}),[r,a])]}function f(e){const{defaultValue:n,queryString:t=!1,groupId:a}=e,r=s(e),[l,i]=(0,o.useState)((()=>function(e){let{defaultValue:n,tabValues:t}=e;if(0===t.length)throw new Error("Docusaurus error: the <Tabs> component requires at least one <TabItem> children component");if(n){if(!m({value:n,tabValues:t}))throw new Error(`Docusaurus error: The <Tabs> has a defaultValue "${n}" but none of its children has the corresponding value. Available values are: ${t.map((e=>e.value)).join(", ")}. If you intend to show no default tab, use defaultValue={null} instead.`);return n}const a=t.find((e=>e.default))??t[0];if(!a)throw new Error("Unexpected error: 0 tabValues");return a.value}({defaultValue:n,tabValues:r}))),[p,d]=g({queryString:t,groupId:a}),[u,f]=function(e){let{groupId:n}=e;const t=function(e){return e?`docusaurus.tab.${e}`:null}(n),[a,r]=(0,c.Nk)(t);return[a,(0,o.useCallback)((e=>{t&&r.set(e)}),[t,r])]}({groupId:a}),k=(()=>{const e=p??u;return m({value:e,tabValues:r})?e:null})();(0,o.useLayoutEffect)((()=>{k&&i(k)}),[k]);return{selectedValue:l,selectValue:(0,o.useCallback)((e=>{if(!m({value:e,tabValues:r}))throw new Error(`Can't select invalid tab value=${e}`);i(e),d(e),f(e)}),[d,f,r]),tabValues:r}}var k=t(2389);const h={tabList:"tabList__CuJ",tabItem:"tabItem_LNqP"};function M(e){let{className:n,block:t,selectedValue:i,selectValue:p,tabValues:d}=e;const c=[],{blockElementScrollPositionUntilNextRender:u}=(0,l.o5)(),s=e=>{const n=e.currentTarget,t=c.indexOf(n),a=d[t].value;a!==i&&(u(n),p(a))},m=e=>{let n=null;switch(e.key){case"Enter":s(e);break;case"ArrowRight":{const t=c.indexOf(e.currentTarget)+1;n=c[t]??c[0];break}case"ArrowLeft":{const t=c.indexOf(e.currentTarget)-1;n=c[t]??c[c.length-1];break}}n?.focus()};return o.createElement("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,r.Z)("tabs",{"tabs--block":t},n)},d.map((e=>{let{value:n,label:t,attributes:l}=e;return o.createElement("li",(0,a.Z)({role:"tab",tabIndex:i===n?0:-1,"aria-selected":i===n,key:n,ref:e=>c.push(e),onKeyDown:m,onClick:s},l,{className:(0,r.Z)("tabs__item",h.tabItem,l?.className,{"tabs__item--active":i===n})}),t??n)})))}function b(e){let{lazy:n,children:t,selectedValue:a}=e;if(t=Array.isArray(t)?t:[t],n){const e=t.find((e=>e.props.value===a));return e?(0,o.cloneElement)(e,{className:"margin-top--md"}):null}return o.createElement("div",{className:"margin-top--md"},t.map(((e,n)=>(0,o.cloneElement)(e,{key:n,hidden:e.props.value!==a}))))}function v(e){const n=f(e);return o.createElement("div",{className:(0,r.Z)("tabs-container",h.tabList)},o.createElement(M,(0,a.Z)({},e,n)),o.createElement(b,(0,a.Z)({},e,n)))}function I(e){const n=(0,k.Z)();return o.createElement(v,(0,a.Z)({key:String(n)},e))}},6105:(e,n,t)=>{t.d(n,{ZP:()=>p});var a=t(7462),o=(t(7294),t(3905)),r=t(814);const l={toc:[]},i="wrapper";function p(e){let{components:n,...t}=e;return(0,o.kt)(i,(0,a.Z)({},l,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("h4",null,(0,o.kt)("code",null,t.packageClass,".","java"===t.language?"java":"kt")),(0,o.kt)("p",null,"The last thing we need to do is to export ",(0,o.kt)("code",null,t.moduleClass)," in the ",(0,o.kt)("code",null,"TurboReactPackage")," instance. Let's go to ",(0,o.kt)("code",null,t.packageClass,".","java"===t.language?"java":"kt")," and add our new module."),(0,o.kt)(r.Z,{language:t.language,title:`android/src/main/java/com/${t.namespace}/${t.packageClass}.${"java"===t.language?"java":"kt"}`,mdxType:"CodeBlock"},"java"===t.language?`package com.${t.namespace};\n\nimport androidx.annotation.Nullable;\n\nimport com.facebook.react.TurboReactPackage;\nimport com.facebook.react.bridge.NativeModule;\nimport com.facebook.react.bridge.ReactApplicationContext;\nimport com.facebook.react.module.annotations.ReactModule;\nimport com.facebook.react.module.model.ReactModuleInfo;\nimport com.facebook.react.module.model.ReactModuleInfoProvider;\nimport com.facebook.react.turbomodule.core.interfaces.TurboModule;\n\nimport java.util.HashMap;\nimport java.util.Map;\n\npublic class ${t.packageClass} extends TurboReactPackage {\n    /**\n     * Initialize and export modules based on the name of the required module\n     */\n    @Override\n    @Nullable\n    public NativeModule getModule(String name, ReactApplicationContext reactContext) {\n        ${t.moduleClass?`// highlight-start\n        if (name.equals(${t.moduleClass}.NAME)) {\n            return new ${t.moduleClass}(reactContext);\n        }\n        return null;\n// highlight-end`:"return null;"}\n    }\n\n    /**\n     * Declare info about exported modules\n     */\n    @Override\n    public ReactModuleInfoProvider getReactModuleInfoProvider() {\n        /**\n         * Here declare the array of exported modules\n         */\n        Class<? extends NativeModule>[] moduleList = new Class[] {${t.moduleClass?`\n// highlight-start\n            ${t.moduleClass}.class\n            // highlight-end`:""}\n        };\n        final Map<String, ReactModuleInfo> reactModuleInfoMap = new HashMap<>();\n        /**\n         * And here just iterate on that array and produce the info provider instance\n         */\n        for (Class<? extends NativeModule> moduleClass : moduleList) {\n            ReactModule reactModule = moduleClass.getAnnotation(ReactModule.class);\n\n            reactModuleInfoMap.put(\n                reactModule.name(),\n                new ReactModuleInfo(\n                    reactModule.name(),\n                    moduleClass.getName(),\n                    true,\n                    reactModule.needsEagerInit(),\n                    reactModule.hasConstants(),\n                    reactModule.isCxxModule(),\n                    TurboModule.class.isAssignableFrom(moduleClass)\n                )\n            );\n        }\n\n        return new ReactModuleInfoProvider() {\n            @Override\n            public Map<String, ReactModuleInfo> getReactModuleInfos() {\n                return reactModuleInfoMap;\n            }\n        };\n    }${t.viewManagerClass?`\n\n// highlight-start\n    @Override\n    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {\n        /**\n        * Here declare the list of exported native components\n        */\n        return Arrays.<ViewManager>asList(new ${t.viewManagerClass}());\n    }\n    // highlight-end`:""}\n}`:`package com.${t.namespace}\n\nimport com.facebook.react.TurboReactPackage\nimport com.facebook.react.bridge.NativeModule\nimport com.facebook.react.bridge.ReactApplicationContext\nimport com.facebook.react.module.annotations.ReactModule\nimport com.facebook.react.module.model.ReactModuleInfo\nimport com.facebook.react.module.model.ReactModuleInfoProvider\nimport com.facebook.react.turbomodule.core.interfaces.TurboModule\n\nclass ${t.packageClass} : TurboReactPackage() {\n    /**\n     * Initialize and export modules based on the name of the required module\n     */\n    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {\n        ${t.moduleClass?`// highlight-start\n        return when (name) {\n            ${t.moduleClass}.NAME -> ${t.moduleClass}(reactContext)\n            else -> null\n        }\n        // highlight-end`:"return null;"}\n    }\n\n    /**\n     * Declare info about exported modules\n     */\n    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {\n        /**\n         * Here declare the array of exported modules\n         */\n        val moduleList: Array<Class<out NativeModule?>> = arrayOf(${t.moduleClass?`\n// highlight-start\n            ${t.moduleClass}::class.java\n            // highlight-end`:""}\n        )\n        val reactModuleInfoMap: MutableMap<String, ReactModuleInfo> = HashMap()\n        /**\n         * And here just iterate on that array and produce the info provider instance\n         */\n        for (moduleClass in moduleList) {\n            val reactModule = moduleClass.getAnnotation(ReactModule::class.java) ?: continue\n            reactModuleInfoMap[reactModule.name] =\n                ReactModuleInfo(\n                    reactModule.name,\n                    moduleClass.name,\n                    true,\n                    reactModule.needsEagerInit,\n                    reactModule.hasConstants,\n                    reactModule.isCxxModule,\n                    TurboModule::class.java.isAssignableFrom(moduleClass)\n                )\n        }\n        return ReactModuleInfoProvider { reactModuleInfoMap }\n    }${t.viewManagerClass?`\n\n// highlight-start\n    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {\n        /**\n        * Here declare the list of exported native components\n        */\n        return listOf(${t.viewManagerClass}())\n    }\n    // highlight-end`:""}\n}`),(0,o.kt)("div",null,t.moduleClass?(0,o.kt)("div",null,(0,o.kt)("p",null,"To export the module, as the first step, we need to return it from ",(0,o.kt)("code",null,"getModule")," method inside ",(0,o.kt)("code",null,t.packageClass),", if it's requested (the method takes name as a parameter and makes decision which module should be served)."),(0,o.kt)("p",null,"The second step is to implement ",(0,o.kt)("code",null,"getReactModuleInfoProvider")," method, where the module is injected to the info provider instance.")):t.viewManagerClass?(0,o.kt)("p",null,"Here the most important bit is ",(0,o.kt)("code",null,"createViewManagers")," method, which returns collection of view manager classes. Because our package exports only a single view, we register one-element list, with ",(0,o.kt)("code",null,t.viewManagerClass)," class."):null))}p.isMDXComponent=!0},5259:(e,n,t)=>{t.d(n,{ZP:()=>p});var a=t(7462),o=(t(7294),t(3905)),r=t(814);const l={toc:[]},i="wrapper";function p(e){let{components:n,...t}=e;return(0,o.kt)(i,(0,a.Z)({},l,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("details",null,(0,o.kt)("summary",null,"Old architecture module"),(0,o.kt)("div",null,"The implementation of old architecture module won't be visible in Android Studio when you have new architecture enabled. To handle that, you can open ",(0,o.kt)("code",null,t.filename)," at other text editor and paste following content:",(0,o.kt)("br",null),(0,o.kt)("br",null),(0,o.kt)(r.Z,{language:t.language,mdxType:"CodeBlock"},t.children))))}p.isMDXComponent=!0},4800:(e,n,t)=>{t.r(n),t.d(n,{assets:()=>P,contentTitle:()=>y,default:()=>V,frontMatter:()=>R,metadata:()=>S,toc:()=>E});var a=t(7462),o=(t(7294),t(3905)),r=t(4866),l=t(5162),i=t(6105),p=t(5259);const d={toc:[{value:"<code>AppInfoModule.java</code>",id:"appinfomodulejava",level:4}]},c="wrapper";function u(e){let{components:n,...t}=e;return(0,o.kt)(c,(0,a.Z)({},d,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("h4",{id:"appinfomodulejava"},(0,o.kt)("inlineCode",{parentName:"h4"},"AppInfoModule.java")),(0,o.kt)("p",null,"Now, let's move to the module that will manage function calls from the JS world:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="android/src/newarch/java/com/appinfopackage/AppInfoModule.java"',title:'"android/src/newarch/java/com/appinfopackage/AppInfoModule.java"'},"package com.appinfopackage;\n\nimport com.facebook.react.bridge.ReactApplicationContext;\nimport com.facebook.react.module.annotations.ReactModule;\n\n/**\n * Declare Java class for new arch native module implementation\n *\n * Each turbo module extends codegenerated spec class\n *\n * Class should be annotated with @ReactModule decorator\n */\n@ReactModule(name = AppInfoModule.NAME)\npublic class AppInfoModule extends NativeAppInfoModuleSpec {\n    public static final String NAME = AppInfoModuleImpl.NAME;\n\n    // Use shared module implementation and forward react application context\n    private final AppInfoModuleImpl moduleImpl;\n\n    public AppInfoModule(ReactApplicationContext reactContext) {\n        super(reactContext);\n        this.moduleImpl = new AppInfoModuleImpl(reactContext);\n    }\n\n    // Return the name of the module - it should match the name provided in JS specification\n    @Override\n    public String getName() {\n        return NAME;\n    }\n\n    // Exported methods are overriden - based on the spec class\n    @Override\n    public String getAppBuildNumber() {\n        return moduleImpl.getAppBuildNumber();\n    }\n\n    @Override\n    public String getAppBundleId() {\n        return moduleImpl.getAppBundleId();\n    }\n\n    @Override\n    public String getAppVersion() {\n        return moduleImpl.getAppVersion();\n    }\n}\n")),(0,o.kt)("p",null,"Here we declare the ",(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModule")," class.\nIt extends codegenerated spec class and takes ",(0,o.kt)("inlineCode",{parentName:"p"},"ReactApplicationContext")," instance as constructor parameter.\nAdditionally, ",(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModule")," is annotated with ",(0,o.kt)("inlineCode",{parentName:"p"},"ReactModule")," decorator.\nStatic constant ",(0,o.kt)("inlineCode",{parentName:"p"},"NAME")," matches the value declared in JS specification."),(0,o.kt)("p",null,"To implement codegenerated spec class, we are using methods from ",(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModuleImpl")," class."),(0,o.kt)(p.ZP,{filename:"android/src/oldarch/java/com/appinfopackage/AppInfoModule.java",language:"java",mdxType:"OldArchAndroidModuleFile"},(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre"},"package com.appinfopackage;\n\nimport com.facebook.react.bridge.ReactApplicationContext;\nimport com.facebook.react.bridge.ReactContextBaseJavaModule;\nimport com.facebook.react.bridge.ReactMethod;\nimport com.facebook.react.module.annotations.ReactModule;\n\n/**\n* Declare Java class for old arch native module implementation\n*\n* Each native module extends ReactContextBaseJavaModule class\n*\n* Class should be annotated with @ReactModule decorator\n*/\n@ReactModule(name = AppInfoModule.NAME)\npublic class AppInfoModule extends ReactContextBaseJavaModule {\n    public static final String NAME = AppInfoModuleImpl.NAME;\n\n    // Use shared module implementation and forward react application context\n    private final AppInfoModuleImpl moduleImpl;\n\n    public AppInfoModule(ReactApplicationContext reactContext) {\n        super(reactContext);\n        this.moduleImpl = new AppInfoModuleImpl(reactContext);\n    }\n\n    // Return the name of the module - it should match the name provided in JS specification\n    @Override\n    public String getName() {\n        return NAME;\n    }\n\n    // Exported methods must be annotated with @ReactMethod decorator\n    @ReactMethod(isBlockingSynchronousMethod = true)\n    public String getAppBuildNumber() {\n        return moduleImpl.getAppBuildNumber();\n    }\n\n    @ReactMethod(isBlockingSynchronousMethod = true)\n    public String getAppBundleId() {\n        return moduleImpl.getAppBundleId();\n    }\n\n    @ReactMethod(isBlockingSynchronousMethod = true)\n    public String getAppVersion() {\n        return moduleImpl.getAppVersion();\n    }\n}\n"))),(0,o.kt)("p",null,"Let's finalize it by exporting the module in the ",(0,o.kt)("inlineCode",{parentName:"p"},"TurboReactPackage")," instance."))}u.isMDXComponent=!0;const s={toc:[{value:"<code>AppInfoModuleImpl.java</code>",id:"appinfomoduleimpljava",level:4}]},m="wrapper";function g(e){let{components:n,...t}=e;return(0,o.kt)(m,(0,a.Z)({},s,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("h4",{id:"appinfomoduleimpljava"},(0,o.kt)("inlineCode",{parentName:"h4"},"AppInfoModuleImpl.java")),(0,o.kt)("p",null,"Let's start by creating a small pure Java class that will directly retrieve all application informations:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="android/src/main/java/com/appinfopackage/AppInfoModuleImpl.java"',title:'"android/src/main/java/com/appinfopackage/AppInfoModuleImpl.java"'},'package com.appinfopackage;\n\nimport android.content.pm.PackageInfo;\nimport android.content.pm.PackageManager;\nimport android.os.Build;\n\nimport com.facebook.react.bridge.ReactApplicationContext;\n\n/**\n * Native module\'s shared implementation\n */\npublic class AppInfoModuleImpl {\n    private final ReactApplicationContext reactContext;\n\n    public static final String NAME = "AppInfoModule";\n\n    public AppInfoModuleImpl(ReactApplicationContext reactContext) {\n        this.reactContext = reactContext;\n    }\n\n    public String getAppBuildNumber() {\n        String buildNumber = "unknown";\n        try {\n            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {\n                buildNumber = Long.toString(getPackageInfo().getLongVersionCode());\n            } else {\n                buildNumber = Long.toString(getPackageInfo().versionCode);\n            }\n        } catch (Exception ignored) {}\n\n        return buildNumber;\n    }\n\n    public String getAppBundleId() {\n        return reactContext.getPackageName();\n    }\n\n    public String getAppVersion() {\n        String appVersion = "unknown";\n        try {\n            appVersion = getPackageInfo().versionName;\n        } catch (Exception ignored) {}\n        return appVersion;\n    }\n\n    private PackageInfo getPackageInfo() throws PackageManager.NameNotFoundException {\n        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {\n            return reactContext\n                .getPackageManager()\n                .getPackageInfo(\n                        reactContext.getPackageName(),\n                        PackageManager.PackageInfoFlags.of(0L)\n                );\n        } else {\n            return reactContext\n                .getPackageManager()\n                .getPackageInfo(reactContext.getPackageName(), 0);\n        }\n    }\n}\n')),(0,o.kt)("p",null,(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModuleImpl")," declares 3 methods, each of them returns string value. It also declares static ",(0,o.kt)("inlineCode",{parentName:"p"},"NAME")," constant which will be used in RN's module wrapper."),(0,o.kt)("p",null,"To retrieve bundle id, we will use ",(0,o.kt)("a",{parentName:"p",href:"https://developer.android.com/reference/android/content/Context#getPackageName()"},"Context#getPackageName")," method.\nFor other app informations we will be calling ",(0,o.kt)("a",{parentName:"p",href:"https://developer.android.com/reference/android/content/pm/PackageManager#getPackageInfo(java.lang.String,%20android.content.pm.PackageManager.PackageInfoFlags)"},"PackageManager#getPackageInfo")," (which can be obtained with ",(0,o.kt)("a",{parentName:"p",href:"https://developer.android.com/reference/android/content/Context#getPackageManager()"},"Context#getPackageManager"),")."))}g.isMDXComponent=!0;const f={toc:[]},k="wrapper";function h(e){let{components:n,...t}=e;return(0,o.kt)(k,(0,a.Z)({},f,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)(g,{mdxType:"AndroidJavaModuleImpl"}),(0,o.kt)(u,{mdxType:"AndroidJavaModule"}),(0,o.kt)(i.ZP,{language:"java",moduleClass:"AppInfoModule",namespace:"appinfopackage",packageClass:"AppInfoTurboPackage",mdxType:"AndroidTurboPackage"}))}h.isMDXComponent=!0;const M={toc:[{value:"<code>AppInfoModule.kt</code>",id:"appinfomodulekt",level:4}]},b="wrapper";function v(e){let{components:n,...t}=e;return(0,o.kt)(b,(0,a.Z)({},M,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("h4",{id:"appinfomodulekt"},(0,o.kt)("inlineCode",{parentName:"h4"},"AppInfoModule.kt")),(0,o.kt)("p",null,"Now, let's move to the module that will manage function calls from the JS world:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="android/src/newarch/java/com/appinfopackage/AppInfoModule.kt"',title:'"android/src/newarch/java/com/appinfopackage/AppInfoModule.kt"'},"package com.appinfopackage\n\nimport com.facebook.react.bridge.ReactApplicationContext\nimport com.facebook.react.module.annotations.ReactModule\n\n/**\n * Declare Kotlin class for new arch native module implementation\n *\n * Each turbo module extends codegenerated spec class\n *\n * Class should be annotated with @ReactModule decorator\n */\n@ReactModule(name = AppInfoModule.NAME)\nclass AppInfoModule(\n    // Each native module class consumes react application context\n    reactContext: ReactApplicationContext\n) : NativeAppInfoModuleSpec(reactContext) {\n    // Use shared module implementation and forward react application context\n    private val moduleImpl = AppInfoModuleImpl(reactContext)\n\n    // Return the name of the module - it should match the name provided in JS specification\n    override fun getName() = NAME\n\n    // Exported methods are overriden - based on the spec class\n    override fun getAppBuildNumber() = moduleImpl.getAppBuildNumber()\n\n    override fun getAppBundleId() = moduleImpl.getAppBundleId()\n\n    override fun getAppVersion() = moduleImpl.getAppVersion()\n\n    companion object {\n        const val NAME = AppInfoModuleImpl.NAME\n    }\n}\n")),(0,o.kt)("p",null,"Here we declare the ",(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModule")," class.\nIt extends codegenerated spec class and takes ",(0,o.kt)("inlineCode",{parentName:"p"},"ReactApplicationContext")," instance as constructor parameter.\nAdditionally, ",(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModule")," is annotated with ",(0,o.kt)("inlineCode",{parentName:"p"},"ReactModule")," decorator.\nStatic constant ",(0,o.kt)("inlineCode",{parentName:"p"},"NAME")," matches the value declared in JS specification."),(0,o.kt)("p",null,"To implement codegenerated spec class, we are using methods from ",(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModuleImpl")," class."),(0,o.kt)(p.ZP,{filename:"android/src/oldarch/java/com/appinfopackage/AppInfoModule.kt",language:"kotlin",mdxType:"OldArchAndroidModuleFile"},(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre"},"package com.appinfopackage\n\nimport com.facebook.react.bridge.ReactApplicationContext\nimport com.facebook.react.bridge.ReactContextBaseJavaModule\nimport com.facebook.react.bridge.ReactMethod\nimport com.facebook.react.module.annotations.ReactModule\n\n/**\n * Declare Kotlin class for old arch native module implementation\n *\n * Each native module extends ReactContextBaseJavaModule class\n *\n * Class should be annotated with @ReactModule decorator\n */\n@ReactModule(name = AppInfoModule.NAME)\nclass AppInfoModule(\n    // Each native module class consumes react application context\n    reactContext: ReactApplicationContext\n) : ReactContextBaseJavaModule(reactContext) {\n    // Use shared module implementation and forward react application context\n    private val moduleImpl = AppInfoModuleImpl(reactContext)\n\n    // Return the name of the module - it should match the name provided in JS specification\n    override fun getName() = NAME\n\n    // Exported methods must be annotated with @ReactMethod decorator\n    @ReactMethod(isBlockingSynchronousMethod = true)\n    fun getAppBuildNumber() = moduleImpl.getAppBuildNumber()\n\n    @ReactMethod(isBlockingSynchronousMethod = true)\n    fun getAppBundleId() = moduleImpl.getAppBundleId()\n\n    @ReactMethod(isBlockingSynchronousMethod = true)\n    fun getAppVersion() = moduleImpl.getAppVersion()\n\n    companion object {\n        const val NAME = AppInfoModuleImpl.NAME\n    }\n}\n"))),(0,o.kt)("p",null,"Let's finalize it by exporting the module in the ",(0,o.kt)("inlineCode",{parentName:"p"},"TurboReactPackage")," instance."))}v.isMDXComponent=!0;const I={toc:[{value:"<code>AppInfoModuleImpl.kt</code>",id:"appinfomoduleimplkt",level:4}]},A="wrapper";function C(e){let{components:n,...t}=e;return(0,o.kt)(A,(0,a.Z)({},I,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("h4",{id:"appinfomoduleimplkt"},(0,o.kt)("inlineCode",{parentName:"h4"},"AppInfoModuleImpl.kt")),(0,o.kt)("p",null,"Let's start by creating a small pure Kotlin class that will directly retrieve all application informations:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="android/src/main/java/com/appinfopackage/AppInfoModuleImpl.kt"',title:'"android/src/main/java/com/appinfopackage/AppInfoModuleImpl.kt"'},'package com.appinfopackage\n\nimport android.content.pm.PackageInfo\nimport android.content.pm.PackageManager\nimport android.os.Build\n\nimport com.facebook.react.bridge.ReactApplicationContext\n\n/**\n * Native module\'s shared implementation\n */\nclass AppInfoModuleImpl(\n    private val reactContext: ReactApplicationContext\n) {\n    fun getAppBuildNumber(): String {\n        var buildNumber = "unknown"\n        try {\n            buildNumber = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {\n                getPackageInfo().longVersionCode.toString()\n            } else {\n                @Suppress("DEPRECATION")\n                getPackageInfo().versionCode.toString()\n            }\n        } catch (_: Exception) {}\n        return buildNumber\n    }\n\n    fun getAppBundleId() = reactContext.packageName as String\n\n    fun getAppVersion(): String {\n        var appVersion = "unknown"\n        try {\n            appVersion = getPackageInfo().versionName\n        } catch (_: Exception) {}\n        return appVersion\n    }\n\n    private fun getPackageInfo(): PackageInfo {\n        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {\n            reactContext\n                .packageManager\n                .getPackageInfo(\n                    reactContext.packageName,\n                    PackageManager.PackageInfoFlags.of(0L)\n                )\n        } else {\n            @Suppress("DEPRECATION")\n            reactContext\n                .packageManager\n                .getPackageInfo(reactContext.packageName, 0)\n        }\n    }\n\n    companion object {\n        const val NAME = "AppInfoModule"\n    }\n}\n')),(0,o.kt)("p",null,(0,o.kt)("inlineCode",{parentName:"p"},"AppInfoModuleImpl")," declares 3 methods, each of them returns string value. It also declares static ",(0,o.kt)("inlineCode",{parentName:"p"},"NAME")," constant which will be used in RN's module wrapper."),(0,o.kt)("p",null,"To retrieve bundle id, we will use ",(0,o.kt)("a",{parentName:"p",href:"https://developer.android.com/reference/kotlin/android/content/Context#getPackageName()"},"Context#getPackageName")," method.\nFor other app informations we will be calling ",(0,o.kt)("a",{parentName:"p",href:"https://developer.android.com/reference/kotlin/android/content/pm/PackageManager#getPackageInfo(kotlin.String,%20android.content.pm.PackageManager.PackageInfoFlags)"},"PackageManager#getPackageInfo")," (which can be obtained with ",(0,o.kt)("a",{parentName:"p",href:"https://developer.android.com/reference/kotlin/android/content/Context#getPackageManager()"},"Context#getPackageManager"),")."))}C.isMDXComponent=!0;const N={toc:[]},x="wrapper";function w(e){let{components:n,...t}=e;return(0,o.kt)(x,(0,a.Z)({},N,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)(C,{mdxType:"AndroidKotlinModuleImpl"}),(0,o.kt)(v,{mdxType:"AndroidKotlinModule"}),(0,o.kt)(i.ZP,{language:"kotlin",moduleClass:"AppInfoModule",namespace:"appinfopackage",packageClass:"AppInfoTurboPackage",mdxType:"AndroidTurboPackage"}))}w.isMDXComponent=!0;const R={sidebar_label:"Android implementation",sidebar_position:5,title:"Android implementation"},y=void 0,S={unversionedId:"guides/app-info-module/android-impl",id:"guides/app-info-module/android-impl",title:"Android implementation",description:"Let's use Android Studio for writing Android code. Launch Android Studio and open the project under /android path.",source:"@site/docs/guides/app-info-module/android-impl.mdx",sourceDirName:"guides/app-info-module",slug:"/guides/app-info-module/android-impl",permalink:"/rnbridgingtutorial/docs/guides/app-info-module/android-impl",draft:!1,editUrl:"https://github.com/mateusz1913/rnbridgingtutorial/tree/main/docs/docs/guides/app-info-module/android-impl.mdx",tags:[],version:"current",sidebarPosition:5,frontMatter:{sidebar_label:"Android implementation",sidebar_position:5,title:"Android implementation"},sidebar:"tutorialSidebar",previous:{title:"iOS implementation",permalink:"/rnbridgingtutorial/docs/guides/app-info-module/ios-impl"},next:{title:"Usage in practice",permalink:"/rnbridgingtutorial/docs/guides/app-info-module/usage"}},P={},E=[],T={toc:E},j="wrapper";function V(e){let{components:n,...t}=e;return(0,o.kt)(j,(0,a.Z)({},T,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"Let's use Android Studio for writing Android code. Launch Android Studio and open the project under ",(0,o.kt)("inlineCode",{parentName:"p"},"<your-project-dir>/android")," path.\nWhen the project is opened, find ",(0,o.kt)("inlineCode",{parentName:"p"},"app-info-package")," inside project-tree"),(0,o.kt)("p",null,"The ",(0,o.kt)("inlineCode",{parentName:"p"},"app-info-package")," contains 3 packages with the same name ",(0,o.kt)("inlineCode",{parentName:"p"},"com.appinfopackage"),". After expanding them, you'll notice that these contain following things:"),(0,o.kt)("ul",null,(0,o.kt)("li",{parentName:"ul"},"code-generated Java spec files"),(0,o.kt)("li",{parentName:"ul"},(0,o.kt)("inlineCode",{parentName:"li"},"AppInfoModule")," class stub files"),(0,o.kt)("li",{parentName:"ul"},(0,o.kt)("inlineCode",{parentName:"li"},"AppInfoModuleImpl")," class stub file"),(0,o.kt)("li",{parentName:"ul"},(0,o.kt)("inlineCode",{parentName:"li"},"AppInfoTurboPackage")," class stub file")),(0,o.kt)("p",null,"Let's start implementing!"),(0,o.kt)(r.Z,{groupId:"android_lang",mdxType:"Tabs"},(0,o.kt)(l.Z,{value:"kotlin",label:"Kotlin",mdxType:"TabItem"},(0,o.kt)(w,{mdxType:"AndroidKotlinImpl"})),(0,o.kt)(l.Z,{value:"java",label:"Java",mdxType:"TabItem"},(0,o.kt)(h,{mdxType:"AndroidJavaImpl"}))),(0,o.kt)("p",null,"You can check training repo for Kotlin implementation ",(0,o.kt)("a",{parentName:"p",href:"https://github.com/mateusz1913/rnbridgingtutorial/tree/main/app-info-package"},"here")," and Java implementation ",(0,o.kt)("a",{parentName:"p",href:"https://github.com/mateusz1913/rnbridgingtutorial/tree/main/app-info-package-classic"},"here"),"."),(0,o.kt)("p",null,"That's Android part, now let's wrap things up and try to use AppInfo module in action!"))}V.isMDXComponent=!0}}]);