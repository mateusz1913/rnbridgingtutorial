import type { RouteProp } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

import type { ROUTES } from './routes';

export type RootStackParamList = {
  [ROUTES.HOME]: undefined;
  [ROUTES.APP_INFO]: { isClassic: boolean } | undefined;
  [ROUTES.CONIC_GRADIENT]: { isClassic: boolean } | undefined;
  [ROUTES.RANGE_SLIDER]: { isClassic: boolean } | undefined;
  [ROUTES.SAVE_FILE]: { isClassic: boolean } | undefined;
  [ROUTES.SCREEN_ORIENTATION]: undefined;
  [ROUTES.NATIVE_LIST]: { isClassic: boolean } | undefined;
};

export type RootStackNavigationProp = NativeStackNavigationProp<RootStackParamList>;

export type AppInfoRouteProp = RouteProp<RootStackParamList, typeof ROUTES.APP_INFO>;
export type ConicGradientRouteProp = RouteProp<RootStackParamList, typeof ROUTES.CONIC_GRADIENT>;
export type RangeSliderRouteProp = RouteProp<RootStackParamList, typeof ROUTES.RANGE_SLIDER>;
export type SaveFileRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SAVE_FILE>;
export type NativeListRouteProp = RouteProp<RootStackParamList, typeof ROUTES.NATIVE_LIST>;
