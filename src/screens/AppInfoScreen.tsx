import { useRoute } from '@react-navigation/native';
import { AppInfoModule } from 'app-info-package';
import { AppInfoModuleClassic } from 'app-info-package-classic';
import type { FC } from 'react';
import { useState } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

import type { AppInfoRouteProp } from '../navigation';

export const AppInfoScreen: FC = () => {
  const route = useRoute<AppInfoRouteProp>();
  const [ appBuildNumber, setAppBuildNumber ] = useState<string | null>(null);
  const [ appBundleId, setAppBundleId ] = useState<string | null>(null);
  const [ appVersion, setAppVersion ] = useState<string | null>(null);
  const isClassicModule = !!route.params?.isClassic;

  const getAppBuildNumber = () => {
    setAppBuildNumber(AppInfoModule.getAppBuildNumber());
  };

  const getAppBundleId = () => {
    setAppBundleId(AppInfoModule.getAppBundleId());
  };

  const getAppVersion = () => {
    setAppVersion(AppInfoModule.getAppVersion());
  };

  const getClassicAppBuildNumber = () => {
    setAppBuildNumber(AppInfoModuleClassic.getAppBuildNumber());
  };

  const getClassicAppBundleId = () => {
    setAppBundleId(AppInfoModuleClassic.getAppBundleId());
  };

  const getClassicAppVersion = () => {
    setAppVersion(AppInfoModuleClassic.getAppVersion());
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>App Info module</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? getClassicAppBuildNumber : getAppBuildNumber} title="Check build number" />
            <Text style={styles.value}>{appBuildNumber}</Text>
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? getClassicAppBundleId : getAppBundleId} title="Check bundle id" />
            <Text style={styles.value}>{appBundleId}</Text>
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? getClassicAppVersion : getAppVersion} title="Check app version" />
            <Text style={styles.value}>{appVersion}</Text>
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
  value: {
    fontSize: 16,
    padding: 8,
  },
});
