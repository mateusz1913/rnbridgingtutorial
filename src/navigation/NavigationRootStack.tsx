import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import type { FC } from 'react';

import { HomeScreen, SimpleEventModuleScreen, SimpleModuleScreen, SimpleUIModuleScreen } from '../screens';

import { ROUTES } from './routes';
import type { RootStackParamList } from './types';

const RootStack = createNativeStackNavigator<RootStackParamList>();

export const NavigationRootStack: FC = () => {
  return <NavigationContainer>
    <RootStack.Navigator screenOptions={{ headerTransparent: true, title: '', animation: 'slide_from_right' }}>
      <RootStack.Screen name={ROUTES.HOME} component={HomeScreen} options={{ headerShown: false }} />
      <RootStack.Screen name={ROUTES.SIMPLE_MODULE} component={SimpleModuleScreen} />
      <RootStack.Screen name={ROUTES.SIMPLE_UI_MODULE} component={SimpleUIModuleScreen} />
      <RootStack.Screen name={ROUTES.SIMPLE_EVENT_MODULE} component={SimpleEventModuleScreen} />
    </RootStack.Navigator>
  </NavigationContainer>;
};
