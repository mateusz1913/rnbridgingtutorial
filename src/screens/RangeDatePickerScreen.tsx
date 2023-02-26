import { useRoute } from '@react-navigation/native';
import { RangeDatePickerModule } from 'range-datepicker-package';
import { RangeDatePickerClassicModule } from 'range-datepicker-package-classic';
import type { FC } from 'react';
import { useState } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

import type { RangeDatePickerRouteProp } from '../navigation';

const DATEPICKER_TITLE = 'Select dates';

export const RangeDatePickerScreen: FC = () => {
  const route = useRoute<RangeDatePickerRouteProp>();
  const isClassicModule = !!route.params?.isClassic;

  const [ selectedStartDate, setSelectedStartDate ] = useState<string | null>(null);
  const [ selectedEndDate, setSelectedEndDate ] = useState<string | null>(null);

  const formatDateResponse = (day: number, month: number, year: number) => {
    const date = new Date();

    date.setUTCFullYear(year, month - 1, day);
    date.setUTCHours(0, 0, 0, 0);

    return date;
  };

  const showDatePickerWithCallback = () => {
    RangeDatePickerModule.showRangeDatePickerWithCallback(DATEPICKER_TITLE, (result) => {
      if (!result) {
        console.log('Cancelled');
        return;
      }

      const { from, to } = result;
  
      setSelectedStartDate(formatDateResponse(from.day, from.month, from.year).toISOString());
      setSelectedEndDate(formatDateResponse(to.day, to.month, to.year).toISOString());
    });
  };

  const showDatePickerWithPromise = async () => {
    const result = await RangeDatePickerModule.showRangeDatePickerWithPromise({ title: DATEPICKER_TITLE });

    if (!result) {
      console.log('Cancelled');
      return;
    }

    const { from, to } = result;
  
    setSelectedStartDate(formatDateResponse(from.day, from.month, from.year).toISOString());
    setSelectedEndDate(formatDateResponse(to.day, to.month, to.year).toISOString());
  };

  const showClassicDatePickerWithCallback = () => {
    RangeDatePickerClassicModule.showRangeDatePickerWithCallback(DATEPICKER_TITLE, (result) => {
      if (!result) {
        console.log('Cancelled');
        return;
      }

      const { from, to } = result;
  
      setSelectedStartDate(formatDateResponse(from.day, from.month, from.year).toISOString());
      setSelectedEndDate(formatDateResponse(to.day, to.month, to.year).toISOString());
    });
  };

  const showClassicDatePickerWithPromise = async () => {
    const result = await RangeDatePickerClassicModule.showRangeDatePickerWithPromise({
      title: DATEPICKER_TITLE,
    });

    if (!result) {
      console.log('Cancelled');
      return;
    }

    const { from, to } = result;
  
    setSelectedStartDate(formatDateResponse(from.day, from.month, from.year).toISOString());
    setSelectedEndDate(formatDateResponse(to.day, to.month, to.year).toISOString());
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Range datepicker</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? showClassicDatePickerWithCallback : showDatePickerWithCallback} title="Display datepicker (Callback)" />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? showClassicDatePickerWithPromise : showDatePickerWithPromise} title="Display datepicker (Promise)" />
          </View>
          <Text style={styles.value}>{selectedStartDate}</Text>
          <Text style={styles.value}>{selectedEndDate}</Text>
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