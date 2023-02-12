import * as React from 'react';

import type { RNSampleNativeListClassicViewComponent } from './RNSampleNativeListClassicViewNativeComponent';
import RNSampleNativeListClassicViewNativeComponent, { RNSampleNativeListClassicViewCommands } from './RNSampleNativeListClassicViewNativeComponent';

type Props = React.ComponentProps<typeof RNSampleNativeListClassicViewNativeComponent>;

export class SampleNativeListClassicView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<RNSampleNativeListClassicViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      RNSampleNativeListClassicViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <RNSampleNativeListClassicViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
