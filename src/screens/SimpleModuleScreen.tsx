import type { FC } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SampleAppInfoModule } from 'sample-native-module';

export const SimpleModuleScreen: FC = () => {
  const invokeMethodWithPromise = () => {
    console.log(1234);
  };

  const invokeSyncMethod = () => {
    console.log(SampleAppInfoModule?.getAppBundleId());
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Simple module showcase</Text>
        <View style={styles.body}>
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
  header: {
    fontSize: 24,
    fontWeight: 'bold',
    paddingVertical: 20,
    textTransform: 'capitalize',
  },
  safeArea: {
    alignSelf: 'stretch',
    flex: 1,
  },
});