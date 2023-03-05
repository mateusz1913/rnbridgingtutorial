"use strict";(self.webpackChunkbridging_tutorial_website=self.webpackChunkbridging_tutorial_website||[]).push([[3682],{3905:(e,t,n)=>{n.d(t,{Zo:()=>p,kt:()=>m});var r=n(7294);function i(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function l(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){i(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function a(e,t){if(null==e)return{};var n,r,i=function(e,t){if(null==e)return{};var n,r,i={},o=Object.keys(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||(i[n]=e[n]);return i}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(i[n]=e[n])}return i}var u=r.createContext({}),s=function(e){var t=r.useContext(u),n=t;return e&&(n="function"==typeof e?e(t):l(l({},t),e)),n},p=function(e){var t=s(e.components);return r.createElement(u.Provider,{value:t},e.children)},c="mdxType",d={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},f=r.forwardRef((function(e,t){var n=e.components,i=e.mdxType,o=e.originalType,u=e.parentName,p=a(e,["components","mdxType","originalType","parentName"]),c=s(n),f=i,m=c["".concat(u,".").concat(f)]||c[f]||d[f]||o;return n?r.createElement(m,l(l({ref:t},p),{},{components:n})):r.createElement(m,l({ref:t},p))}));function m(e,t){var n=arguments,i=t&&t.mdxType;if("string"==typeof e||i){var o=n.length,l=new Array(o);l[0]=f;var a={};for(var u in t)hasOwnProperty.call(t,u)&&(a[u]=t[u]);a.originalType=e,a[c]="string"==typeof e?e:i,l[1]=a;for(var s=2;s<o;s++)l[s]=n[s];return r.createElement.apply(null,l)}return r.createElement.apply(null,n)}f.displayName="MDXCreateElement"},304:(e,t,n)=>{n.d(t,{ZP:()=>u});var r=n(7462),i=(n(7294),n(3905));const o=n.p+"assets/images/appinfo-result-e3bc94da23b488270e8f02ebf154dcd8.png",l={toc:[]},a="wrapper";function u(e){let{components:t,...n}=e;return(0,i.kt)(a,(0,r.Z)({},l,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)("div",{style:{display:"flex",flexDirection:"column",alignSelf:"stretch",margin:20}},(0,i.kt)("img",{src:o,alt:"AppInfo module in action",width:"50%",style:{display:"flex",alignSelf:"center"}})))}u.isMDXComponent=!0},3497:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>s,contentTitle:()=>a,default:()=>f,frontMatter:()=>l,metadata:()=>u,toc:()=>p});var r=n(7462),i=(n(7294),n(3905)),o=n(304);const l={sidebar_label:"Intro",sidebar_position:1,title:"Intro"},a=void 0,u={unversionedId:"guides/app-info-module/intro",id:"guides/app-info-module/intro",title:"Intro",description:"In this guide, you'll learn how to create simple module with 3 synchronous methods.",source:"@site/docs/guides/app-info-module/intro.mdx",sourceDirName:"guides/app-info-module",slug:"/guides/app-info-module/intro",permalink:"/rnbridgingtutorial/docs/guides/app-info-module/intro",draft:!1,editUrl:"https://github.com/mateusz1913/rnbridgingtutorial/tree/main/docs/docs/guides/app-info-module/intro.mdx",tags:[],version:"current",sidebarPosition:1,frontMatter:{sidebar_label:"Intro",sidebar_position:1,title:"Intro"},sidebar:"tutorialSidebar",previous:{title:"Introduction",permalink:"/rnbridgingtutorial/docs/guides/guides-intro"},next:{title:"Module boilerplate",permalink:"/rnbridgingtutorial/docs/guides/app-info-module/setup"}},s={},p=[{value:"Difficulty",id:"difficulty",level:3},{value:"Task",id:"task",level:3},{value:"What&#39;s the plan?",id:"whats-the-plan",level:3},{value:"Result?",id:"result",level:3}],c={toc:p},d="wrapper";function f(e){let{components:t,...n}=e;return(0,i.kt)(d,(0,r.Z)({},c,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)("p",null,"In this guide, you'll learn how to create simple module with 3 synchronous methods."),(0,i.kt)("h3",{id:"difficulty"},"Difficulty"),(0,i.kt)("p",null,"Kids' stuff \ud83d\udc76"),(0,i.kt)("h3",{id:"task"},"Task"),(0,i.kt)("p",null,"As a user, I want to see the package name and version, so that I know if I use test or live version of the app."),(0,i.kt)("h3",{id:"whats-the-plan"},"What's the plan?"),(0,i.kt)("ul",null,(0,i.kt)("li",{parentName:"ul"},"create module's boilerplate"),(0,i.kt)("li",{parentName:"ul"},"creating JS spec"),(0,i.kt)("li",{parentName:"ul"},"iOS implementation "),(0,i.kt)("li",{parentName:"ul"},"Android implementation"),(0,i.kt)("li",{parentName:"ul"},"using the module in action")),(0,i.kt)("h3",{id:"result"},"Result?"),(0,i.kt)(o.ZP,{mdxType:"Result"}))}f.isMDXComponent=!0}}]);