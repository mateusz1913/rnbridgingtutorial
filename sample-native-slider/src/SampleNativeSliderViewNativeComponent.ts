import type * as React from 'react';
import type {
  ColorValue,
  HostComponent,
  ViewProps,
} from 'react-native';
import type { DirectEventHandler, Double, Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export type OnSampleNativeSliderViewEndDragEventData = Readonly<{ leftKnobValue: Double; rightKnobValue: Double }>;
export type OnSampleNativeSliderViewValueChangeEventData = Readonly<{ leftKnobValue: Double; rightKnobValue: Double }>;

export interface SampleNativeSliderViewProps extends ViewProps {
  activeColor?: ColorValue;
  inactiveColor?: ColorValue;
  leftKnobValue: Double;
  minValue?: Double;
  maxValue?: Double;
  onSampleNativeSliderViewBeginDrag?: DirectEventHandler<null>;
  onSampleNativeSliderViewEndDrag?: DirectEventHandler<OnSampleNativeSliderViewEndDragEventData>;
  onSampleNativeSliderViewValueChange?: DirectEventHandler<OnSampleNativeSliderViewValueChangeEventData>;
  rightKnobValue: Double;
  step?: Int32;
}

export type SampleNativeSliderViewComponent = HostComponent<SampleNativeSliderViewProps>;

export interface SampleNativeSliderViewNativeCommands {
  setLeftKnobValueProgrammatically: (viewRef: React.ElementRef<SampleNativeSliderViewComponent>, value: Double) => void;
  setRightKnobValueProgrammatically: (
    viewRef: React.ElementRef<SampleNativeSliderViewComponent>,
    value: Double,
  ) => void;
}

export const SampleNativeSliderViewCommands = codegenNativeCommands<SampleNativeSliderViewNativeCommands>({
  supportedCommands: [ 'setLeftKnobValueProgrammatically', 'setRightKnobValueProgrammatically' ],
});

export default codegenNativeComponent<SampleNativeSliderViewProps>('SampleNativeSliderView') as SampleNativeSliderViewComponent;
