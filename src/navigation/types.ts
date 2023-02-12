import type { RouteProp } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

import type { ROUTES } from './routes';

export type RootStackParamList = {
  [ROUTES.HOME]: undefined;
  [ROUTES.SIMPLE_MODULE]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_UI_MODULE]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_EVENT_MODULE]: undefined;
  [ROUTES.SIMPLE_REACT_VIEW]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_VIEW]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_LAUNCH_NATIVE_SCREEN_MODULE]: { isClassic: boolean } | undefined;
  [ROUTES.NATIVE_LIST]: { isClassic: boolean } | undefined;
};

export type RootStackNavigationProp = NativeStackNavigationProp<RootStackParamList>;

export type SimpleModuleRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_MODULE>;
export type SimpleUIModuleRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_UI_MODULE>;
export type SimpleReactViewRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_REACT_VIEW>;
export type SimpleViewRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_VIEW>;
export type SimpleLaunchNativeScreenModuleRouteProp = RouteProp<
  RootStackParamList,
  typeof ROUTES.SIMPLE_LAUNCH_NATIVE_SCREEN_MODULE
>;
export type NativeListRouteProp = RouteProp<RootStackParamList, typeof ROUTES.NATIVE_LIST>;
