import type * as React from 'react';
import type {
  ColorValue,
  HostComponent,
  ViewProps,
} from 'react-native';
import type { DirectEventHandler, Double, Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export type OnRangeSliderClassicViewEndDragEventData = Readonly<{
  leftKnobValue: Double;
  rightKnobValue: Double;
}>;
export type OnRangeSliderClassicViewValueChangeEventData = Readonly<{
  leftKnobValue: Double;
  rightKnobValue: Double;
}>;

export interface RangeSliderClassicViewProps extends ViewProps {
  activeColor?: ColorValue;
  inactiveColor?: ColorValue;
  leftKnobValue: Double;
  minValue?: Double;
  maxValue?: Double;
  onRangeSliderClassicViewBeginDrag?: DirectEventHandler<null>;
  onRangeSliderClassicViewEndDrag?: DirectEventHandler<OnRangeSliderClassicViewEndDragEventData>;
  onRangeSliderClassicViewValueChange?: DirectEventHandler<OnRangeSliderClassicViewValueChangeEventData>;
  rightKnobValue: Double;
  step?: Int32;
}

export type RangeSliderClassicViewComponent = HostComponent<RangeSliderClassicViewProps>;

export interface RangeSliderClassicViewNativeCommands {
  setLeftKnobValueProgrammatically: (
    viewRef: React.ElementRef<RangeSliderClassicViewComponent>,
    value: Double,
  ) => void;
  setRightKnobValueProgrammatically: (
    viewRef: React.ElementRef<RangeSliderClassicViewComponent>,
    value: Double,
  ) => void;
}

export const RangeSliderClassicViewCommands =
  codegenNativeCommands<RangeSliderClassicViewNativeCommands>({
    supportedCommands: [ 'setLeftKnobValueProgrammatically', 'setRightKnobValueProgrammatically' ],
  });

export default codegenNativeComponent<RangeSliderClassicViewProps>('RangeSliderClassicView') as RangeSliderClassicViewComponent;
