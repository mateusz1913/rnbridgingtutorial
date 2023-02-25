import * as React from 'react';
import type { ColorValue } from 'react-native';
import { processColor } from 'react-native';

import ConicGradientClassicViewNativeComponent from './ConicGradientClassicViewNativeComponent';

type Props = React.ComponentProps<typeof ConicGradientClassicViewNativeComponent>;

export class ConicGradientClassicView extends React.Component<Props> {
  render() {
    const colors = this.props.colors.map(processColor) as ReadonlyArray<ColorValue>;

    return <ConicGradientClassicViewNativeComponent {...this.props} colors={colors} />;
  }
}
