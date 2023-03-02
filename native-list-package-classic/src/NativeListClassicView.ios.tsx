import * as React from 'react';

import type { RNNativeListClassicViewComponent } from './RNNativeListClassicViewNativeComponent';
import RNNativeListClassicViewNativeComponent, { RNNativeListClassicViewCommands } from './RNNativeListClassicViewNativeComponent';

type Props = React.ComponentProps<typeof RNNativeListClassicViewNativeComponent>;

export class NativeListClassicView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<RNNativeListClassicViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      RNNativeListClassicViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <RNNativeListClassicViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
