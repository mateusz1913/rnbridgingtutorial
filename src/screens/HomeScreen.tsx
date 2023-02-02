import type { FC } from 'react';
import { Button, ScrollView, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

import { ROUTES, useRootStackNavigation } from '../navigation';

export const HomeScreen: FC = () => {
  const navigation = useRootStackNavigation();

  const navigateToSimpleModule = () => {
    navigation.navigate(ROUTES.SIMPLE_MODULE);
  };

  const navigateToSimpleModuleClassic = () => {
    navigation.navigate(ROUTES.SIMPLE_MODULE, { isClassic: true });
  };

  const navigateToSimpleUIModule = () => {
    navigation.navigate(ROUTES.SIMPLE_UI_MODULE);
  };

  const navigateToSimpleUIModuleClassic = () => {
    navigation.navigate(ROUTES.SIMPLE_UI_MODULE, { isClassic: true });
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <Text style={styles.titleBarText}>Demo</Text>
      <View style={styles.container}>
        <View style={styles.header}>
          <Text style={styles.headerText}>Bridging tutorial</Text>
        </View>
        <ScrollView contentContainerStyle={styles.bodyContent} style={styles.body}>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSimpleModule} title="Simple module" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSimpleModuleClassic} title="Simple module (Classic)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSimpleUIModule} title="Simple UI module" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSimpleUIModuleClassic} title="Simple UI module (Classic)" />
          </View>
        </ScrollView>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  body: {
    alignSelf: 'stretch',
    flex: 1,
  },
  bodyContent: {
    alignItems: 'center',
    alignSelf: 'stretch',
    // flex: 1,
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
    margin: 20,
  },
});
