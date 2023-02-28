import { useRoute } from '@react-navigation/native';
import { RangeSliderView } from 'range-slider-package';
import { RangeSliderClassicView } from 'range-slider-package-classic';
import * as React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

import type { RangeSliderRouteProp } from '../navigation';

export const RangeSliderScreen: React.FC = () => {
  const route = useRoute<RangeSliderRouteProp>();
  const isClassic = !!route.params?.isClassic;
  const sliderRef = React.useRef<RangeSliderView>(null);
  const classicSliderRef = React.useRef<RangeSliderClassicView>(null);
  const [ leftKnobValue, setLeftKnobValue ] = React.useState(2);
  const [ rightKnobValue, setRightKnobValue ] = React.useState(8);

  function resetLeftKnobValue() {
    if (isClassic) {
      classicSliderRef.current?.setLeftKnobValueProgrammatically(2);
    } else {
      sliderRef.current?.setLeftKnobValueProgrammatically(2);
    }
  }

  function resetRightKnobValue() {
    if (isClassic) {
      classicSliderRef.current?.setRightKnobValueProgrammatically(8);
    } else {
      sliderRef.current?.setRightKnobValueProgrammatically(8);
    }
  }

  const commonProps = {
    activeColor: 'pink',
    inactiveColor: 'gray',
    leftKnobValue,
    minValue: 0,
    maxValue: 10,
    rightKnobValue,
    // step: 1,
    style: styles.slider,
  };

  return <SafeAreaView style={styles.safeArea}>
    <View style={styles.container}>
      <Text style={styles.header}>Range Slider</Text>
      {isClassic ? <RangeSliderClassicView
        ref={classicSliderRef}
        {...commonProps}
        onRangeSliderClassicViewBeginDrag={() => {
          console.log('BEGIN_DRAG');
        }}
        onRangeSliderClassicViewEndDrag={(e) => {
          console.log('END_DRAG', e.nativeEvent);
          setLeftKnobValue(e.nativeEvent.leftKnobValue ?? 2);
          setRightKnobValue(e.nativeEvent.rightKnobValue ?? 8);
        }}
        onRangeSliderClassicViewValueChange={(e) => {
          console.log('CHANGE', e.nativeEvent);
        }}
      /> : <RangeSliderView
        ref={sliderRef}
        {...commonProps}
        onRangeSliderViewBeginDrag={() => {
          console.log('BEGIN_DRAG');
        }}
        onRangeSliderViewEndDrag={(e) => {
          console.log('END_DRAG', e.nativeEvent);
          setLeftKnobValue(e.nativeEvent.leftKnobValue ?? 2);
          setRightKnobValue(e.nativeEvent.rightKnobValue ?? 8);
        }}
        onRangeSliderViewValueChange={(e) => {
          console.log('CHANGE', e.nativeEvent);
        }}
      />}
      <View style={styles.buttonsContainer}>
        <Button
          onPress={resetLeftKnobValue}
          title="Reset left knob"
        />
        <Button
          onPress={resetRightKnobValue}
          title="Reset right knob"
        />
      </View>
    </View>
  </SafeAreaView>;
};

const styles = StyleSheet.create({
  buttonsContainer: {
    margin: 40,
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
  slider: {
    height: 40,
    width: 250,
  },
});
