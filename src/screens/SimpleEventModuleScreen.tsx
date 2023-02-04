import type { FC } from 'react';
import { useEffect, useState } from 'react';
import { NativeEventEmitter, Platform, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SampleScreenOrientationModule } from 'sample-event-module';
import { SampleScreenOrientationClassicModule } from 'sample-event-module-classic';

const moduleEventEmitter = new NativeEventEmitter(Platform.OS === 'ios' ? SampleScreenOrientationModule : undefined);
const classicModuleEventEmitter = new NativeEventEmitter(Platform.OS === 'ios' ? SampleScreenOrientationClassicModule : undefined);

export const SimpleEventModuleScreen: FC = () => {
  const [ screenOrientation, setScreenOrientation ] = useState<'portrait' | 'landscape' | 'unknown'>('unknown');
  const [ classicScreenOrientation, setClassicScreenOrientation ] = useState<'portrait' | 'landscape' | 'unknown'>('unknown');

  useEffect(() => {
    const subscription = moduleEventEmitter.addListener('onSampleScreenOrientationModuleChange', ({ orientation }: { orientation: 'portrait' | 'landscape' | 'unknown' }) => {
      console.log({ orientation });
      setScreenOrientation(orientation);
    });
    const classicSubscription = classicModuleEventEmitter.addListener('onSampleScreenOrientationClassicModuleChange', ({ orientation }: { orientation: 'portrait' | 'landscape' | 'unknown' }) => {
      console.log({ classicOrientation: orientation });
      setClassicScreenOrientation(orientation);
    });

    return () => {
      subscription.remove();
      classicSubscription.remove();
    };
  }, []);

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Simple event module</Text>
        <View style={styles.body}>
          <Text style={styles.content}>Constants: {JSON.stringify(SampleScreenOrientationModule.getConstants())}</Text>
          <Text style={styles.content}>
            Classic Constants: {JSON.stringify(SampleScreenOrientationClassicModule.getConstants())}
          </Text>
          <Text style={styles.content}>Screen orientation: {screenOrientation}</Text>
          <Text style={styles.content}>Classic Screen orientation: {classicScreenOrientation}</Text>
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
  content: {
    fontSize: 20,
    fontWeight: '600',
    paddingVertical: 20,
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
