import type {
  ColorValue,
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Double } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export interface ConicGradientClassicViewProps extends ViewProps {
  colors: ReadonlyArray<ColorValue>;
  locations: ReadonlyArray<Double>;
  centerPoint?: Readonly<{ x: Double, y: Double }>;
}

export type ConicGradientClassicViewComponent = HostComponent<ConicGradientClassicViewProps>;

export default codegenNativeComponent<ConicGradientClassicViewProps>('ConicGradientClassicView') as ConicGradientClassicViewComponent;
