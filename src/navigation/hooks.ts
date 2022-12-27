import { NavigationContext } from 'navigation-react';
import type { NavigationEvent } from 'navigation-react';
import { useContext } from 'react';

import type { RootStack } from './types';

export const useNavigationContext = () => {
  const navigationContext: NavigationEvent<RootStack> = useContext(NavigationContext);

  if (navigationContext === undefined) {
    throw new Error('`useNavigationContext` must be used within `NavigationHandler`');
  }

  return navigationContext;
};

export const useNavigateBack = (distance = 1, historyAction?: 'replace' | 'add' | 'none') => {
  const { stateNavigator } = useNavigationContext();

  const navigateBack = () => {
    stateNavigator.navigateBack(distance, historyAction);
  };

  return navigateBack;
};
