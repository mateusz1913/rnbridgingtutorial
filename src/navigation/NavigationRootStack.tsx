import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import type { FC } from 'react';

import {
  AppInfoScreen,
  ConicGradientScreen,
  HomeScreen,
  NativeListScreen,
  SimpleEventModuleScreen,
  SimpleLaunchNativeScreenModuleScreen,
  SimpleUIModuleScreen,
  SimpleViewScreen,
} from '../screens';

import { ROUTES } from './routes';
import type { RootStackParamList } from './types';

const RootStack = createNativeStackNavigator<RootStackParamList>();

export const NavigationRootStack: FC = () => {
  return <NavigationContainer>
    <RootStack.Navigator screenOptions={{ headerTransparent: true, title: '', animation: 'slide_from_right' }}>
      <RootStack.Screen name={ROUTES.HOME} component={HomeScreen} options={{ headerShown: false }} />
      <RootStack.Screen name={ROUTES.APP_INFO} component={AppInfoScreen} />
      <RootStack.Screen name={ROUTES.CONIC_GRADIENT} component={ConicGradientScreen} />
      <RootStack.Screen name={ROUTES.SIMPLE_UI_MODULE} component={SimpleUIModuleScreen} />
      <RootStack.Screen name={ROUTES.SIMPLE_EVENT_MODULE} component={SimpleEventModuleScreen} />
      <RootStack.Screen name={ROUTES.SIMPLE_VIEW} component={SimpleViewScreen} />
      <RootStack.Screen
        name={ROUTES.SIMPLE_LAUNCH_NATIVE_SCREEN_MODULE}
        component={SimpleLaunchNativeScreenModuleScreen}
      />
      <RootStack.Screen name={ROUTES.NATIVE_LIST} component={NativeListScreen} />
    </RootStack.Navigator>
  </NavigationContainer>;
};
