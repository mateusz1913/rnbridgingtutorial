import type { FC } from 'react';
import { StatusBar } from 'react-native';
import { SafeAreaProvider } from 'react-native-safe-area-context';

import { NavigationRootStack } from './navigation';

export const App: FC = () => {
  return (
    <SafeAreaProvider>
      <StatusBar animated backgroundColor="transparent" translucent />
      <NavigationRootStack />
    </SafeAreaProvider>
  );
};