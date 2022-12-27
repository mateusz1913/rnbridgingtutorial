import { NavigationBar } from 'navigation-react-native';
import type { FC } from 'react';
import { Button, Platform, SafeAreaView, StyleSheet, Text, View } from 'react-native';

import { arrowBack } from '../assets';
import { useNavigateBack } from '../navigation/hooks';

export const SimpleModuleScreen: FC = () => {
  const navigateBack = useNavigateBack();

  const invokeMethodWithPromise = () => {
    console.log(1234);
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <NavigationBar
        title="Simple module"
        {...(Platform.OS === 'android'
          ? {
              navigationImage: arrowBack,
              onNavigationPress: navigateBack,
            }
          : null)}
      />
      <View style={styles.container}>
        <Text style={styles.header}>Simple module showcase</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={invokeMethodWithPromise} title="Method with promise" />
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
  buttonWrapper: {
    alignSelf: 'stretch',
    paddingVertical: 30,
  },
  container: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flex: 1,
    justifyContent: 'center',
  },
  header: {
    fontSize: 30,
    fontWeight: 'bold',
    paddingVertical: 20,
    textTransform: 'capitalize',
  },
  safeArea: {
    alignSelf: 'stretch',
    flex: 1,
  },
});