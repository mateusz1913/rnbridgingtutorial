import type * as React from 'react';
import type {
  ColorValue,
  HostComponent,
  ViewProps,
} from 'react-native';
import type { DirectEventHandler, Double, Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export type OnRangeSliderViewEndDragEventData = Readonly<{ leftKnobValue: Double; rightKnobValue: Double }>;
export type OnRangeSliderViewValueChangeEventData = Readonly<{ leftKnobValue: Double; rightKnobValue: Double }>;

export interface RangeSliderViewProps extends ViewProps {
  activeColor?: ColorValue;
  inactiveColor?: ColorValue;
  leftKnobValue: Double;
  minValue?: Double;
  maxValue?: Double;
  onRangeSliderViewBeginDrag?: DirectEventHandler<null>;
  onRangeSliderViewEndDrag?: DirectEventHandler<OnRangeSliderViewEndDragEventData>;
  onRangeSliderViewValueChange?: DirectEventHandler<OnRangeSliderViewValueChangeEventData>;
  rightKnobValue: Double;
  step?: Int32;
}

export type RangeSliderViewComponent = HostComponent<RangeSliderViewProps>;

export interface RangeSliderViewNativeCommands {
  setLeftKnobValueProgrammatically: (viewRef: React.ElementRef<RangeSliderViewComponent>, value: Double) => void;
  setRightKnobValueProgrammatically: (
    viewRef: React.ElementRef<RangeSliderViewComponent>,
    value: Double,
  ) => void;
}

export const RangeSliderViewCommands = codegenNativeCommands<RangeSliderViewNativeCommands>({
  supportedCommands: [ 'setLeftKnobValueProgrammatically', 'setRightKnobValueProgrammatically' ],
});

export default codegenNativeComponent<RangeSliderViewProps>('RangeSliderView') as RangeSliderViewComponent;
