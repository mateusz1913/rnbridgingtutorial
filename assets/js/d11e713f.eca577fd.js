"use strict";(self.webpackChunkbridging_tutorial_website=self.webpackChunkbridging_tutorial_website||[]).push([[9455],{3905:(e,t,n)=>{n.d(t,{Zo:()=>u,kt:()=>b});var r=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function l(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function i(e,t){if(null==e)return{};var n,r,a=function(e,t){if(null==e)return{};var n,r,a={},o=Object.keys(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var m=r.createContext({}),s=function(e){var t=r.useContext(m),n=t;return e&&(n="function"==typeof e?e(t):l(l({},t),e)),n},u=function(e){var t=s(e.components);return r.createElement(m.Provider,{value:t},e.children)},d="mdxType",c={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},p=r.forwardRef((function(e,t){var n=e.components,a=e.mdxType,o=e.originalType,m=e.parentName,u=i(e,["components","mdxType","originalType","parentName"]),d=s(n),p=a,b=d["".concat(m,".").concat(p)]||d[p]||c[p]||o;return n?r.createElement(b,l(l({ref:t},u),{},{components:n})):r.createElement(b,l({ref:t},u))}));function b(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var o=n.length,l=new Array(o);l[0]=p;var i={};for(var m in t)hasOwnProperty.call(t,m)&&(i[m]=t[m]);i.originalType=e,i[d]="string"==typeof e?e:a,l[1]=i;for(var s=2;s<o;s++)l[s]=n[s];return r.createElement.apply(null,l)}return r.createElement.apply(null,n)}p.displayName="MDXCreateElement"},5162:(e,t,n)=>{n.d(t,{Z:()=>l});var r=n(7294),a=n(6010);const o={tabItem:"tabItem_Ymn6"};function l(e){let{children:t,hidden:n,className:l}=e;return r.createElement("div",{role:"tabpanel",className:(0,a.Z)(o.tabItem,l),hidden:n},t)}},4866:(e,t,n)=>{n.d(t,{Z:()=>f});var r=n(7462),a=n(7294),o=n(6010),l=n(2466),i=n(6550),m=n(1980),s=n(7392),u=n(12);function d(e){return function(e){return a.Children.map(e,(e=>{if((0,a.isValidElement)(e)&&"value"in e.props)return e;throw new Error(`Docusaurus error: Bad <Tabs> child <${"string"==typeof e.type?e.type:e.type.name}>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.`)}))}(e).map((e=>{let{props:{value:t,label:n,attributes:r,default:a}}=e;return{value:t,label:n,attributes:r,default:a}}))}function c(e){const{values:t,children:n}=e;return(0,a.useMemo)((()=>{const e=t??d(n);return function(e){const t=(0,s.l)(e,((e,t)=>e.value===t.value));if(t.length>0)throw new Error(`Docusaurus error: Duplicate values "${t.map((e=>e.value)).join(", ")}" found in <Tabs>. Every value needs to be unique.`)}(e),e}),[t,n])}function p(e){let{value:t,tabValues:n}=e;return n.some((e=>e.value===t))}function b(e){let{queryString:t=!1,groupId:n}=e;const r=(0,i.k6)(),o=function(e){let{queryString:t=!1,groupId:n}=e;if("string"==typeof t)return t;if(!1===t)return null;if(!0===t&&!n)throw new Error('Docusaurus error: The <Tabs> component groupId prop is required if queryString=true, because this value is used as the search param name. You can also provide an explicit value such as queryString="my-search-param".');return n??null}({queryString:t,groupId:n});return[(0,m._X)(o),(0,a.useCallback)((e=>{if(!o)return;const t=new URLSearchParams(r.location.search);t.set(o,e),r.replace({...r.location,search:t.toString()})}),[o,r])]}function y(e){const{defaultValue:t,queryString:n=!1,groupId:r}=e,o=c(e),[l,i]=(0,a.useState)((()=>function(e){let{defaultValue:t,tabValues:n}=e;if(0===n.length)throw new Error("Docusaurus error: the <Tabs> component requires at least one <TabItem> children component");if(t){if(!p({value:t,tabValues:n}))throw new Error(`Docusaurus error: The <Tabs> has a defaultValue "${t}" but none of its children has the corresponding value. Available values are: ${n.map((e=>e.value)).join(", ")}. If you intend to show no default tab, use defaultValue={null} instead.`);return t}const r=n.find((e=>e.default))??n[0];if(!r)throw new Error("Unexpected error: 0 tabValues");return r.value}({defaultValue:t,tabValues:o}))),[m,s]=b({queryString:n,groupId:r}),[d,y]=function(e){let{groupId:t}=e;const n=function(e){return e?`docusaurus.tab.${e}`:null}(t),[r,o]=(0,u.Nk)(n);return[r,(0,a.useCallback)((e=>{n&&o.set(e)}),[n,o])]}({groupId:r}),g=(()=>{const e=m??d;return p({value:e,tabValues:o})?e:null})();(0,a.useLayoutEffect)((()=>{g&&i(g)}),[g]);return{selectedValue:l,selectValue:(0,a.useCallback)((e=>{if(!p({value:e,tabValues:o}))throw new Error(`Can't select invalid tab value=${e}`);i(e),s(e),y(e)}),[s,y,o]),tabValues:o}}var g=n(2389);const v={tabList:"tabList__CuJ",tabItem:"tabItem_LNqP"};function h(e){let{className:t,block:n,selectedValue:i,selectValue:m,tabValues:s}=e;const u=[],{blockElementScrollPositionUntilNextRender:d}=(0,l.o5)(),c=e=>{const t=e.currentTarget,n=u.indexOf(t),r=s[n].value;r!==i&&(d(t),m(r))},p=e=>{let t=null;switch(e.key){case"Enter":c(e);break;case"ArrowRight":{const n=u.indexOf(e.currentTarget)+1;t=u[n]??u[0];break}case"ArrowLeft":{const n=u.indexOf(e.currentTarget)-1;t=u[n]??u[u.length-1];break}}t?.focus()};return a.createElement("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,o.Z)("tabs",{"tabs--block":n},t)},s.map((e=>{let{value:t,label:n,attributes:l}=e;return a.createElement("li",(0,r.Z)({role:"tab",tabIndex:i===t?0:-1,"aria-selected":i===t,key:t,ref:e=>u.push(e),onKeyDown:p,onClick:c},l,{className:(0,o.Z)("tabs__item",v.tabItem,l?.className,{"tabs__item--active":i===t})}),n??t)})))}function k(e){let{lazy:t,children:n,selectedValue:r}=e;if(n=Array.isArray(n)?n:[n],t){const e=n.find((e=>e.props.value===r));return e?(0,a.cloneElement)(e,{className:"margin-top--md"}):null}return a.createElement("div",{className:"margin-top--md"},n.map(((e,t)=>(0,a.cloneElement)(e,{key:t,hidden:e.props.value!==r}))))}function M(e){const t=y(e);return a.createElement("div",{className:(0,o.Z)("tabs-container",v.tabList)},a.createElement(h,(0,r.Z)({},e,t)),a.createElement(k,(0,r.Z)({},e,t)))}function f(e){const t=(0,g.Z)();return a.createElement(M,(0,r.Z)({key:String(t)},e))}},2451:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>u,contentTitle:()=>m,default:()=>b,frontMatter:()=>i,metadata:()=>s,toc:()=>d});var r=n(7462),a=(n(7294),n(3905)),o=n(4866),l=n(5162);const i={sidebar_label:"Method types",sidebar_position:2,title:"Method types"},m=void 0,s={unversionedId:"module-reference/module-method-types",id:"module-reference/module-method-types",title:"Method types",description:"Void method",source:"@site/docs/module-reference/module-method-types.mdx",sourceDirName:"module-reference",slug:"/module-reference/module-method-types",permalink:"/rnbridgingtutorial/docs/module-reference/module-method-types",draft:!1,editUrl:"https://github.com/mateusz1913/rnbridgingtutorial/tree/main/docs/docs/module-reference/module-method-types.mdx",tags:[],version:"current",sidebarPosition:2,frontMatter:{sidebar_label:"Method types",sidebar_position:2,title:"Method types"},sidebar:"tutorialSidebar",previous:{title:"Intro",permalink:"/rnbridgingtutorial/docs/module-reference/module-intro"},next:{title:"Method types (old arch)",permalink:"/rnbridgingtutorial/docs/module-reference/module-method-types-old"}},u={},d=[{value:"Void method",id:"void-method",level:3},{value:"Sync method",id:"sync-method",level:3},{value:"Promise method",id:"promise-method",level:3},{value:"Callback method",id:"callback-method",level:3}],c={toc:d},p="wrapper";function b(e){let{components:t,...n}=e;return(0,a.kt)(p,(0,r.Z)({},c,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("h3",{id:"void-method"},"Void method"),(0,a.kt)("p",null,"Void methods can take multiple amount of arguments and does not return any value."),(0,a.kt)(o.Z,{groupId:"specs",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"JS",label:"JS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-tsx",metastring:'title="src/NativeMyAwesomeModule.ts"',title:'"src/NativeMyAwesomeModule.ts"'},"import type { TurboModule } from 'react-native';\nimport { TurboModuleRegistry } from 'react-native';\n\n// ...\n\nexport interface Spec extends TurboModule {\n  myAwesomeVoidMethod(): void\n  myAwesomeVoidMethodWithArguments(numArg: number, objArg: { firstObjProp: string, secondObjProp?: boolean }): void\n}\n\nexport default TurboModuleRegistry.getEnforcing<Spec>('MyAwesomeModule');\n"))),(0,a.kt)(l.Z,{value:"iOS",label:"iOS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-objc",metastring:'title="ios/NativeMyAwesomeModule.mm"',title:'"ios/NativeMyAwesomeModule.mm"'},"RCT_EXPORT_METHOD(myAwesomeVoidMethod)\n{\n    // ...\n}\n\nRCT_EXPORT_METHOD(myAwesomeVoidMethodWithArguments:(NSNumber *) numArg \n                                            objArg:(JS::NativeMyAwesomeModule::SpecMyAwesomeVoidMethodWithArgumentsObjArg &) objArg)\n{\n    // ...\n}\n"))),(0,a.kt)(l.Z,{value:"Android",label:"Android Spec",mdxType:"TabItem"},(0,a.kt)(o.Z,{groupId:"android_lang",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"kotlin",label:"Kotlin",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="android/src/main/newarch/com/myawesomeapp/NativeMyAwesomeModule.kt"',title:'"android/src/main/newarch/com/myawesomeapp/NativeMyAwesomeModule.kt"'},"import com.facebook.react.bridge.ReadableMap\n\n// ...\n\noverride fun myAwesomeVoidMethod() {\n    // ...\n}\n\noverride fun myAwesomeVoidMethodWithArguments(numArg: Double, objArg: ReadableMap) {\n    // ...\n}\n"))),(0,a.kt)(l.Z,{value:"java",label:"Java",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="android/src/main/newarch/com/myawesomeapp/NativeMyAwesomeModule.java"',title:'"android/src/main/newarch/com/myawesomeapp/NativeMyAwesomeModule.java"'},"import com.facebook.react.bridge.ReadableMap;\n\n// ...\n\n@Override\npublic void myAwesomeVoidMethod() {\n    // ...\n}\n\n@Override\npublic void myAwesomeVoidMethodWithArguments(double numArg, ReadableMap objArg) {\n    // ...\n}\n")))))),(0,a.kt)("h3",{id:"sync-method"},"Sync method"),(0,a.kt)("p",null,"Sync methods can take multiple amount of arguments and synchronously return the value."),(0,a.kt)(o.Z,{groupId:"specs",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"JS",label:"JS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-tsx",metastring:'title="src/NativeMyAwesomeModule.ts"',title:'"src/NativeMyAwesomeModule.ts"'},"import type { TurboModule } from 'react-native';\nimport { TurboModuleRegistry } from 'react-native';\n\n// ...\n\nexport interface Spec extends TurboModule {\n  myAwesomeSyncMethod(): number\n  myAwesomeSyncMethodWithArguments(numArg: number, objArg: { firstObjProp: string, secondObjProp?: boolean }): number\n}\n\nexport default TurboModuleRegistry.getEnforcing<Spec>('MyAwesomeModule');\n"))),(0,a.kt)(l.Z,{value:"iOS",label:"iOS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-objc",metastring:'title="ios/NativeMyAwesomeModule.mm"',title:'"ios/NativeMyAwesomeModule.mm"'},"RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(double, myAwesomeSyncMethod)\n{\n    // ...\n    return 42;\n}\n\nRCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(double, myAwesomeSyncMethodWithArguments:(NSNumber *) numArg \n                                                                      objArg:(JS::NativeMyAwesomeModule::SpecMyAwesomeSyncMethodWithArgumentsObjArg &) objArg)\n{\n    // ...\n    return 42;\n}\n"))),(0,a.kt)(l.Z,{value:"Android",label:"Android Spec",mdxType:"TabItem"},(0,a.kt)(o.Z,{groupId:"android_lang",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"kotlin",label:"Kotlin",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="android/src/main/newarch/NativeMyAwesomeModule.kt"',title:'"android/src/main/newarch/NativeMyAwesomeModule.kt"'},"import com.facebook.react.bridge.ReadableMap\n\n// ...\n\noverride fun myAwesomeSyncMethod(): Double {\n    // ...\n    return 42\n}\n\noverride fun myAwesomeSyncMethodWithArguments(numArg: Double, objArg: ReadableMap): Double {\n    // ...\n    return 42\n}\n"))),(0,a.kt)(l.Z,{value:"java",label:"Java",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="android/src/main/newarch/NativeMyAwesomeModule.java"',title:'"android/src/main/newarch/NativeMyAwesomeModule.java"'},"import com.facebook.react.bridge.ReadableMap;\n\n// ...\n\n@Override\npublic double myAwesomeSyncMethod() {\n    // ...\n    return 42;\n}\n\n@Override\npublic double myAwesomeSyncMethodWithArguments(double numArg, ReadableMap objArg) {\n    // ...\n    return 42;\n}\n")))))),(0,a.kt)("h3",{id:"promise-method"},"Promise method"),(0,a.kt)("p",null,"Promise methods can take multiple amount of arguments and asynchronously return the value."),(0,a.kt)(o.Z,{groupId:"specs",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"JS",label:"JS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-tsx",metastring:'title="src/NativeMyAwesomeModule.ts"',title:'"src/NativeMyAwesomeModule.ts"'},"import type { TurboModule } from 'react-native';\nimport { TurboModuleRegistry } from 'react-native';\n\n// ...\n\nexport interface Spec extends TurboModule {\n  myAwesomePromiseMethod(): Promise<boolean>\n  myAwesomePromiseMethodWithArguments(numArg: number, objArg: { firstObjProp: string, secondObjProp?: boolean }): Promise<boolean>\n}\n\nexport default TurboModuleRegistry.getEnforcing<Spec>('MyAwesomeModule');\n"))),(0,a.kt)(l.Z,{value:"iOS",label:"iOS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-objc",metastring:'title="ios/NativeMyAwesomeModule.mm"',title:'"ios/NativeMyAwesomeModule.mm"'},"RCT_EXPORT_METHOD(myAwesomePromiseMethod:(RCTPromiseResolveBlock) resolve\n                                  reject:(RCTPromiseRejectBlock) reject)\n{\n    // ...\n    resolve(@(YES));\n}\n\nRCT_EXPORT_METHOD(myAwesomePromiseMethodWithArguments:(NSNumber *) numArg \n                                               objArg:(JS::NativeMyAwesomeModule::SpecMyAwesomePromiseMethodWithArgumentsObjArg &) objArg\n                                              resolve:(RCTPromiseResolveBlock) resolve\n                                               reject:(RCTPromiseRejectBlock) reject)\n{\n    // ...\n    resolve(@(YES));\n}\n"))),(0,a.kt)(l.Z,{value:"Android",label:"Android Spec",mdxType:"TabItem"},(0,a.kt)(o.Z,{groupId:"android_lang",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"kotlin",label:"Kotlin",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="android/src/main/newarch/NativeMyAwesomeModule.kt"',title:'"android/src/main/newarch/NativeMyAwesomeModule.kt"'},"import com.facebook.react.bridge.Promise\nimport com.facebook.react.bridge.ReadableMap\n\n// ...\n\noverride fun myAwesomePromiseMethod(promise: Promise) {\n    // ...\n    promise.resolve(true)\n}\n\noverride fun myAwesomePromiseMethodWithArguments(numArg: Double, objArg: ReadableMap, promise: Promise) {\n    // ...\n    promise.resolve(true)\n}\n"))),(0,a.kt)(l.Z,{value:"java",label:"Java",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="android/src/main/newarch/NativeMyAwesomeModule.java"',title:'"android/src/main/newarch/NativeMyAwesomeModule.java"'},"import com.facebook.react.bridge.Promise;\nimport com.facebook.react.bridge.ReadableMap;\n\n// ...\n\n@Override\npublic void myAwesomePromiseMethod(Promise promise) {\n    // ...\n    promise.resolve(true);\n}\n\n@Override\npublic void myAwesomePromiseMethodWithArguments(double numArg, ReadableMap objArg, Promise promise) {\n    // ...\n    promise.resolve(true);\n}\n")))))),(0,a.kt)("h3",{id:"callback-method"},"Callback method"),(0,a.kt)("p",null,"Callback methods can take multiple amount of arguments and take callback arguments which are used to communicate from native to JS world. Callbacks should be put as last arguments in the method."),(0,a.kt)(o.Z,{groupId:"specs",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"JS",label:"JS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-tsx",metastring:'title="src/NativeMyAwesomeModule.ts"',title:'"src/NativeMyAwesomeModule.ts"'},"import type { TurboModule } from 'react-native';\nimport { TurboModuleRegistry } from 'react-native';\n\n// ...\n\nexport interface Spec extends TurboModule {\n  myAwesomeCallbackMethod(myResultCallback: () => void): void\n  myAwesomeCallbackMethodWithArguments(numArg: number, objArg: { firstObjProp: string, secondObjProp?: boolean }, myResultCallback: () => void): void\n}\n\nexport default TurboModuleRegistry.getEnforcing<Spec>('MyAwesomeModule');\n"))),(0,a.kt)(l.Z,{value:"iOS",label:"iOS Spec",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-objc",metastring:'title="ios/NativeMyAwesomeModule.mm"',title:'"ios/NativeMyAwesomeModule.mm"'},"RCT_EXPORT_METHOD(myAwesomeCallbackMethod:(RCTResponseSenderBlock) myResultCallback)\n{\n    // ...\n    myResultCallback(@[nil]);\n}\n\nRCT_EXPORT_METHOD(myAwesomeCallbackMethodWithArguments:(NSNumber *) numArg \n                                                objArg:(JS::NativeMyAwesomeModule::SpecMyAwesomePromiseMethodWithArgumentsObjArg &) objArg\n                                      myResultCallback:(RCTResponseSenderBlock) myResultCallback)\n{\n    // ...\n    myResultCallback(@[nil]);\n}\n"))),(0,a.kt)(l.Z,{value:"Android",label:"Android Spec",mdxType:"TabItem"},(0,a.kt)(o.Z,{groupId:"android_lang",mdxType:"Tabs"},(0,a.kt)(l.Z,{value:"kotlin",label:"Kotlin",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="android/src/main/newarch/NativeMyAwesomeModule.kt"',title:'"android/src/main/newarch/NativeMyAwesomeModule.kt"'},"import com.facebook.react.bridge.Callback\nimport com.facebook.react.bridge.ReadableMap\n\n// ...\n\noverride fun myAwesomeCallbackMethod(myResultCallback: Callback) {\n    // ...\n    callback.invoke(null)\n}\n\noverride fun myAwesomeCallbackMethodWithArguments(numArg: Double, objArg: ReadableMap, myResultCallback: Callback) {\n    // ...\n    callback.invoke(null)\n}\n"))),(0,a.kt)(l.Z,{value:"java",label:"Java",mdxType:"TabItem"},(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-java",metastring:'title="android/src/main/newarch/NativeMyAwesomeModule.java"',title:'"android/src/main/newarch/NativeMyAwesomeModule.java"'},"import com.facebook.react.bridge.Callback;\nimport com.facebook.react.bridge.ReadableMap;\n\n// ...\n\n@Override\npublic void myAwesomeCallbackMethod(Callback myResultCallback) {\n    // ...\n    callback.invoke(null);\n}\n\n@Override\npublic void myAwesomeCallbackMethodWithArguments(double numArg, ReadableMap objArg, Callback myResultCallback) {\n    // ...\n    callback.invoke(null);\n}\n")))))))}b.isMDXComponent=!0}}]);