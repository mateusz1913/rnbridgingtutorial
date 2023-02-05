import * as React from 'react';
import type { ColorValue } from 'react-native';
import { processColor } from 'react-native';

import SampleConicGradientViewNativeComponent from './SampleConicGradientViewNativeComponent';

type Props = React.ComponentProps<typeof SampleConicGradientViewNativeComponent>;

export class SampleConicGradientView extends React.Component<Props> {
  render() {
    const colors = this.props.colors.map(processColor) as ReadonlyArray<ColorValue>;

    return <SampleConicGradientViewNativeComponent {...this.props} colors={colors} />;
  }
}
