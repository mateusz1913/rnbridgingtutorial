import type { FC } from 'react';
import { createContext } from 'react';
import { useState } from 'react';

import { HomeScreen, SimpleModuleScreen } from '../screens';

import { ROUTES } from './routes';

type NavContextT = {
  route: typeof ROUTES[keyof typeof ROUTES],
  setRoute: (route: typeof ROUTES[keyof typeof ROUTES]) => void
}

export const NavigationContext = createContext<NavContextT | null>(null);

export const NavigationRootStack: FC = () => {
  const [ route, setRoute ] = useState<typeof ROUTES[keyof typeof ROUTES]>(ROUTES.HOME);

  function renderScreen() {
    if (route === ROUTES.SIMPLE_MODULE) {
      return <SimpleModuleScreen />;
    }
  
    return <HomeScreen />;
  }

  return <NavigationContext.Provider value={{ route, setRoute }}>
    {renderScreen()}
  </NavigationContext.Provider>;
};
