import * as React from 'react';

import type { RNNativeListViewComponent } from './RNNativeListViewNativeComponent';
import RNNativeListViewNativeComponent, { RNNativeListViewCommands } from './RNNativeListViewNativeComponent';

type Props = React.ComponentProps<typeof RNNativeListViewNativeComponent>;

export class NativeListView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<RNNativeListViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      RNNativeListViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <RNNativeListViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
