import * as React from 'react';
import type { ViewProps } from 'react-native';
import { View } from 'react-native';

type Props = ViewProps & {
  data: ReadonlyArray<{ imageUrl: string; description: string }>
  options: Readonly<{ placeholderImage: string }>
};

export class SampleNativeListClassicView extends React.Component<Props> {
  scrollToItem = (index: number) => {
    console.log(index);
  };

  render() {
    return <View {...this.props} />;
  }
}
