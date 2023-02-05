import type { RouteProp } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

import type { ROUTES } from './routes';

export type RootStackParamList = {
  [ROUTES.HOME]: undefined;
  [ROUTES.SIMPLE_MODULE]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_UI_MODULE]: { isClassic: boolean } | undefined;
  [ROUTES.SIMPLE_EVENT_MODULE]: undefined;
  [ROUTES.SIMPLE_REACT_VIEW]: { isClassic: boolean } | undefined;
};

export type RootStackNavigationProp = NativeStackNavigationProp<RootStackParamList>;

export type SimpleModuleRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_MODULE>;
export type SimpleUIModuleRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_UI_MODULE>;
export type SimpleReactViewRouteProp = RouteProp<RootStackParamList, typeof ROUTES.SIMPLE_REACT_VIEW>;
