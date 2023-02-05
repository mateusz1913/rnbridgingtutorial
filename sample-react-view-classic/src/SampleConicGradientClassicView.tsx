import * as React from 'react';
import type { ColorValue } from 'react-native';
import { processColor } from 'react-native';

import SampleConicGradientClassicViewNativeComponent from './SampleConicGradientClassicViewNativeComponent';

type Props = React.ComponentProps<typeof SampleConicGradientClassicViewNativeComponent>;

export class SampleConicGradientClassicView extends React.Component<Props> {
  render() {
    const colors = this.props.colors.map(processColor) as ReadonlyArray<ColorValue>;

    return <SampleConicGradientClassicViewNativeComponent {...this.props} colors={colors} />;
  }
}
