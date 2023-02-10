import { useRoute } from '@react-navigation/native';
import type { FC } from 'react';
import { useCallback, useEffect } from 'react';
import { Button, NativeEventEmitter, Platform, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SampleNativeScreenModule } from 'sample-native-screen';
import { SampleNativeScreenClassicModule } from 'sample-native-screen-classic';

import type { SimpleLaunchNativeScreenModuleRouteProp } from '../navigation';

const moduleEventEmitter = new NativeEventEmitter(Platform.OS === 'ios' ? SampleNativeScreenModule : undefined);
const classicModuleEventEmitter = new NativeEventEmitter(Platform.OS === 'ios' ? SampleNativeScreenClassicModule : undefined);

export const SimpleLaunchNativeScreenModuleScreen: FC = () => {
  const route = useRoute<SimpleLaunchNativeScreenModuleRouteProp>();
  const isClassicModule = !!route.params?.isClassic;

  const launchNativeScreen = useCallback(() => {
    SampleNativeScreenModule.launchNativeScreen(Platform.select({
      ios: 'Native UIViewController',
      android: 'Native Activity',
      default: '',
    }));
  }, []);
  const launchClassicNativeScreen = useCallback(() => {
    SampleNativeScreenClassicModule.launchNativeScreen(Platform.select({
      ios: 'Native UIViewController (Classic)',
      android: 'Native Activity (Classic)',
      default: '',
    }));
  }, []);

  useEffect(() => {
    const subscription = moduleEventEmitter.addListener('onResult', ({ text, success }: { text?: string, success: boolean }) => {
      console.log({ text, success });
    });
    const classicSubscription = classicModuleEventEmitter.addListener('onResultClassic', ({ text, success }: { text?: string, success: boolean }) => {
      console.log({ text, success, classic: true });
    });

    return () => {
      subscription.remove();
      classicSubscription.remove();
    };
  }, []);

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Display native screen</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? launchClassicNativeScreen : launchNativeScreen} title="Launch native screen" />
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
