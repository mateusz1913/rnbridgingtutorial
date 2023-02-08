import { useRoute } from '@react-navigation/native';
import * as React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SampleNativeSliderView } from 'sample-native-slider';
import { SampleNativeSliderClassicView } from 'sample-native-slider-classic';

import type { SimpleViewRouteProp } from '../navigation';

export const SimpleViewScreen: React.FC = () => {
  const route = useRoute<SimpleViewRouteProp>();
  const isClassic = !!route.params?.isClassic;
  const sliderRef = React.useRef<SampleNativeSliderView>(null);
  const classicSliderRef = React.useRef<SampleNativeSliderClassicView>(null);
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
      {isClassic ? <SampleNativeSliderClassicView
        ref={classicSliderRef}
        {...commonProps}
        onSampleNativeSliderClassicViewBeginDrag={() => {
          console.log('BEGIN_DRAG');
        }}
        onSampleNativeSliderClassicViewEndDrag={(e) => {
          console.log('END_DRAG', e.nativeEvent);
          setLeftKnobValue(e.nativeEvent.leftKnobValue ?? 2);
          setRightKnobValue(e.nativeEvent.rightKnobValue ?? 8);
        }}
        onSampleNativeSliderClassicViewValueChange={(e) => {
          console.log('CHANGE', e.nativeEvent);
        }}
      /> : <SampleNativeSliderView
        ref={sliderRef}
        {...commonProps}
        onSampleNativeSliderViewBeginDrag={() => {
          console.log('BEGIN_DRAG');
        }}
        onSampleNativeSliderViewEndDrag={(e) => {
          console.log('END_DRAG', e.nativeEvent);
          setLeftKnobValue(e.nativeEvent.leftKnobValue ?? 2);
          setRightKnobValue(e.nativeEvent.rightKnobValue ?? 8);
        }}
        onSampleNativeSliderViewValueChange={(e) => {
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
