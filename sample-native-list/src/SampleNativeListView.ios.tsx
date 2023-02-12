import * as React from 'react';

import type { RNSampleNativeListViewComponent } from './RNSampleNativeListViewNativeComponent';
import RNSampleNativeListViewNativeComponent, { RNSampleNativeListViewCommands } from './RNSampleNativeListViewNativeComponent';

type Props = React.ComponentProps<typeof RNSampleNativeListViewNativeComponent>;

export class SampleNativeListView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<RNSampleNativeListViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      RNSampleNativeListViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <RNSampleNativeListViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
