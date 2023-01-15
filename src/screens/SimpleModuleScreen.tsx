import type { FC } from 'react';
import { Button, SafeAreaView, StyleSheet, Text, View } from 'react-native';
import { FragmentCustomView, SampleAppInfoModule } from 'samplenativemodule';

import { NavBar } from '../components';

export const SimpleModuleScreen: FC = () => {
  const invokeMethodWithPromise = () => {
    console.log(1234);
  };

  const invokeSyncMethod = () => {
    console.log(SampleAppInfoModule?.getAppBundleId());
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <NavBar title="Simple module" />
      <View style={styles.container}>
        <Text style={styles.header}>Simple module showcase</Text>
        <View style={styles.body}>
          <View style={styles.fragmentWrapper}>
            <FragmentCustomView style={styles.fragment} />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={invokeMethodWithPromise} title="Method with promise" />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={invokeSyncMethod} title="Sync method" />
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
  fragment: {
    backgroundColor: 'orange',
    alignSelf: 'stretch',
    // height: 200,
    flex: 1,
    padding: 10,
    // width: 250,
  },
  fragmentWrapper: {
    alignSelf: 'stretch',
    backgroundColor: 'brown',
    flex: 1,
    paddingVertical: 30,
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