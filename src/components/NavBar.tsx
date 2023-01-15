import type { FC } from 'react';
import { Button } from 'react-native';

import { ROUTES, useNavigationContext } from '../navigation';

interface Props {
  title: string
}

export const NavBar: FC<Props> = () => {
  const { setRoute } = useNavigationContext();

  return <Button onPress={() => setRoute(ROUTES.HOME)} title="Go back" />;
};
