import { NavigationBar } from 'navigation-react-native';
import type { FC } from 'react';
import { Platform } from 'react-native';

import { arrowBack } from '../assets';
import { useNavigateBack } from '../navigation';

interface Props {
  title: string
}

export const NavBar: FC<Props> = () => {
  const navigateBack = useNavigateBack();

  return <NavigationBar
    title="Simple module"
    {...(Platform.OS === 'android'
      ? {
          navigationImage: arrowBack,
          onNavigationPress: navigateBack,
        }
      : null)}
  />;
};
