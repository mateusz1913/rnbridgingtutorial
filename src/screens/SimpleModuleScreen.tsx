import { useRoute } from '@react-navigation/native';
import type { FC } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SampleAppInfoModule } from 'sample-native-module';
import { SampleAppInfoClassicModule } from 'sample-native-module-classic';

import type { SimpleModuleRouteProp } from '../navigation';

export const SimpleModuleScreen: FC = () => {
  const route = useRoute<SimpleModuleRouteProp>();
  const isClassicModule = !!route.params?.isClassic;

  const getAppBuildNumber = () => {
    console.log(SampleAppInfoModule.getAppBuildNumber());
  };

  const getAppBundleId = () => {
    console.log(SampleAppInfoModule.getAppBundleId());
  };

  const getAppVersion = () => {
    console.log(SampleAppInfoModule.getAppVersion());
  };

  const getClassicAppBuildNumber = () => {
    console.log(SampleAppInfoClassicModule.getAppBuildNumber());
  };

  const getClassicAppBundleId = () => {
    console.log(SampleAppInfoClassicModule.getAppBundleId());
  };

  const getClassicAppVersion = () => {
    console.log(SampleAppInfoClassicModule.getAppVersion());
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Simple module showcase</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? getClassicAppBuildNumber : getAppBuildNumber} title="Check build number" />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? getClassicAppBundleId : getAppBundleId} title="Check bundle id" />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? getClassicAppVersion : getAppVersion} title="Check app version" />
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
