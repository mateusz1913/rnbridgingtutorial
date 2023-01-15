import type { FC } from 'react';
import { Button, SafeAreaView, StyleSheet, Text, View } from 'react-native';

import { ROUTES, useNavigationContext } from '../navigation';

export const HomeScreen: FC = () => {
  const { setRoute } = useNavigationContext();
  const navigateToSimpleModule = () => {
    setRoute(ROUTES.SIMPLE_MODULE);
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <Text style={styles.titleBarText}>Demo</Text>
      <View style={styles.container}>
        <View style={styles.header}>
          <Text style={styles.headerText}>Bridging tutorial</Text>
        </View>
        <View style={styles.body}>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSimpleModule} title="Simple module" />
          </View>
        </View>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  body: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  container: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flex: 1,
    justifyContent: 'center',
  },
  header: {
    alignItems: 'center',
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  headerText: {
    fontSize: 30,
    fontWeight: 'bold',
    paddingVertical: 20,
    textTransform: 'capitalize',
  },
  navigateLink: {
    alignSelf: 'stretch',
    paddingVertical: 20,
  },
  safeArea: {
    alignSelf: 'stretch',
    flex: 1,
  },
  titleBarText: {
    fontSize: 16,
    fontWeight: 'bold',
  },
});
