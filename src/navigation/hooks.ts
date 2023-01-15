import { useContext } from 'react';

import { NavigationContext } from './NavigationRootStack';

export const useNavigationContext = () => {
  const navigationContext = useContext(NavigationContext);

  if (navigationContext === undefined || navigationContext === null) {
    throw new Error('`useNavigationContext` must be used within `NavigationHandler`');
  }

  return navigationContext;
};
