import type { RouteProp } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

import type { ROUTES } from './routes';

export type RootStackParamList = {
  [ROUTES.HOME]: undefined;
  [ROUTES.APP_INFO]: { isClassic: boolean } | undefined;
  [ROUTES.RANGE_DATEPICKER]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_EVENT_MODULE]: undefined;
  [ROUTES.CONIC_GRADIENT]: { isClassic: boolean } | undefined;
  [ROUTES.RANGE_SLIDER]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_LAUNCH_NATIVE_SCREEN_MODULE]: { isClassic: boolean } | undefined;
  [ROUTES.NATIVE_LIST]: { isClassic: boolean } | undefined;
};

export type RootStackNavigationProp = NativeStackNavigationProp<RootStackParamList>;

export type AppInfoRouteProp = RouteProp<RootStackParamList, typeof ROUTES.APP_INFO>;
export type ConicGradientRouteProp = RouteProp<RootStackParamList, typeof ROUTES.CONIC_GRADIENT>;
export type RangeDatePickerRouteProp = RouteProp<RootStackParamList, typeof ROUTES.RANGE_DATEPICKER>;
export type RangeSliderRouteProp = RouteProp<RootStackParamList, typeof ROUTES.RANGE_SLIDER>;
export type SimpleLaunchNativeScreenModuleRouteProp = RouteProp<
  RootStackParamList,
  typeof ROUTES.SIMPLE_LAUNCH_NATIVE_SCREEN_MODULE
>;
export type NativeListRouteProp = RouteProp<RootStackParamList, typeof ROUTES.NATIVE_LIST>;
