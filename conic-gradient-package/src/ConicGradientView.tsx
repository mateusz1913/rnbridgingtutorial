import * as React from 'react';
import type { ColorValue } from 'react-native';
import { processColor } from 'react-native';

import ConicGradientViewNativeComponent from './ConicGradientViewNativeComponent';

type Props = React.ComponentProps<typeof ConicGradientViewNativeComponent>;

export class ConicGradientView extends React.Component<Props> {
  render() {
    const colors = this.props.colors.map(processColor) as ReadonlyArray<ColorValue>;

    return <ConicGradientViewNativeComponent {...this.props} colors={colors} />;
  }
}
