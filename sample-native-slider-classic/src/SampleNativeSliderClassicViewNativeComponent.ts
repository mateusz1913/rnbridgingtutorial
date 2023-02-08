import type * as React from 'react';
import type {
  ColorValue,
  HostComponent,
  ViewProps,
} from 'react-native';
import type { DirectEventHandler, Double, Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export type OnSampleNativeSliderClassicViewEndDragEventData = Readonly<{
  leftKnobValue: Double;
  rightKnobValue: Double;
}>;
export type OnSampleNativeSliderClassicViewValueChangeEventData = Readonly<{
  leftKnobValue: Double;
  rightKnobValue: Double;
}>;

export interface SampleNativeSliderClassicViewProps extends ViewProps {
  activeColor?: ColorValue;
  inactiveColor?: ColorValue;
  leftKnobValue: Double;
  minValue?: Double;
  maxValue?: Double;
  onSampleNativeSliderClassicViewBeginDrag?: DirectEventHandler<null>;
  onSampleNativeSliderClassicViewEndDrag?: DirectEventHandler<OnSampleNativeSliderClassicViewEndDragEventData>;
  onSampleNativeSliderClassicViewValueChange?: DirectEventHandler<OnSampleNativeSliderClassicViewValueChangeEventData>;
  rightKnobValue: Double;
  step?: Int32;
}

export type SampleNativeSliderClassicViewComponent = HostComponent<SampleNativeSliderClassicViewProps>;

export interface SampleNativeSliderClassicViewNativeCommands {
  setLeftKnobValueProgrammatically: (
    viewRef: React.ElementRef<SampleNativeSliderClassicViewComponent>,
    value: Double,
  ) => void;
  setRightKnobValueProgrammatically: (
    viewRef: React.ElementRef<SampleNativeSliderClassicViewComponent>,
    value: Double,
  ) => void;
}

export const SampleNativeSliderClassicViewCommands =
  codegenNativeCommands<SampleNativeSliderClassicViewNativeCommands>({
    supportedCommands: [ 'setLeftKnobValueProgrammatically', 'setRightKnobValueProgrammatically' ],
  });

export default codegenNativeComponent<SampleNativeSliderClassicViewProps>('SampleNativeSliderClassicView') as SampleNativeSliderClassicViewComponent;
