import { StateNavigator } from 'navigation';
import { NavigationHandler } from 'navigation-react';
import { NavigationStack, Scene } from 'navigation-react-native';
import type { FC } from 'react';

import { HomeScreen, SimpleModuleScreen } from '../screens';

import { ROUTES } from './routes';
import type { RootStack } from './types';

const stateNavigator = new StateNavigator<RootStack>([
  { key: ROUTES.HOME },
  { key: ROUTES.SIMPLE_MODULE, trackCrumbTrail: true },
]);

export const NavigationRootStack: FC = () => {
  return <NavigationHandler stateNavigator={stateNavigator}>
    <NavigationStack>
      <Scene<RootStack> stateKey={ROUTES.HOME}>
        <HomeScreen />
      </Scene>
      <Scene<RootStack> stateKey={ROUTES.SIMPLE_MODULE}>
        <SimpleModuleScreen />
      </Scene>
    </NavigationStack>
  </NavigationHandler>;
};
