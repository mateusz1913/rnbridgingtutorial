import { useRoute } from '@react-navigation/native';
import type { FC } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SampleNativeDatepickerModule } from 'sample-native-datepicker';
import { SampleNativeDatepickerClassicModule } from 'sample-native-datepicker-classic';

import type { SimpleUIModuleRouteProp } from '../navigation';

export const SimpleUIModuleScreen: FC = () => {
  const route = useRoute<SimpleUIModuleRouteProp>();
  const isClassicModule = !!route.params?.isClassic;

  const formatDateResponse = (day: number, month: number, year: number) => {
    const date = new Date();

    date.setUTCFullYear(year, month - 1, day);
    date.setUTCHours(0, 0, 0, 0);

    console.log({ date: date.toISOString() });
  };

  const showDatepickerWithCallback = () => {
    SampleNativeDatepickerModule.showRangeDatepickerWithCallback('OKRUTNIK', (result) => {
      if (!result) {
        console.log('Cancelled');
        return;
      }

      const { from, to } = result;
  
      formatDateResponse(from.day, from.month, from.year);
      formatDateResponse(to.day, to.month, to.year);
    });
  };

  const showDatepickerWithPromise = async () => {
    const result = await SampleNativeDatepickerModule.showRangeDatepickerWithPromise({ title: 'OKRUTNIK' });

    if (!result) {
      console.log('Cancelled');
      return;
    }

    const { from, to } = result;
  
    formatDateResponse(from.day, from.month, from.year);
    formatDateResponse(to.day, to.month, to.year);
  };

  const showClassicDatepickerWithCallback = () => {
    SampleNativeDatepickerClassicModule.showRangeDatepickerWithCallback('OKRUTNIK', (result) => {
      if (!result) {
        console.log('Cancelled');
        return;
      }

      const { from, to } = result;
  
      formatDateResponse(from.day, from.month, from.year);
      formatDateResponse(to.day, to.month, to.year);
    });
  };

  const showClassicDatepickerWithPromise = async () => {
    const result = await SampleNativeDatepickerClassicModule.showRangeDatepickerWithPromise({ title: 'OKRUTNIK' });

    if (!result) {
      console.log('Cancelled');
      return;
    }

    const { from, to } = result;
  
    formatDateResponse(from.day, from.month, from.year);
    formatDateResponse(to.day, to.month, to.year);
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Simple UI module</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? showClassicDatepickerWithCallback : showDatepickerWithCallback} title="Display datepicker (Callback)" />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? showClassicDatepickerWithPromise : showDatepickerWithPromise} title="Display datepicker (Promise)" />
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