import type { NativeStackNavigationProp } from '@react-navigation/native-stack';

import type { ROUTES } from './routes';

export type RootStackParamList = {
  [ROUTES.HOME]: undefined;
  [ROUTES.SIMPLE_MODULE]: undefined;
};

export type RootStackNavigationProp = NativeStackNavigationProp<RootStackParamList>;
