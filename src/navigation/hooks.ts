import { useNavigation } from '@react-navigation/native';

import type { RootStackNavigationProp } from './types';

export const useRootStackNavigation = () => {
  const navigation = useNavigation<RootStackNavigationProp>();

  return navigation;
};
