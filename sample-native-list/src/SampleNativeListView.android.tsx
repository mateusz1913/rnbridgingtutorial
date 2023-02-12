import * as React from 'react';

import type { AndroidSampleNativeListViewComponent } from './AndroidSampleNativeListViewNativeComponent';
import AndroidSampleNativeListViewNativeComponent, { AndroidSampleNativeListViewCommands } from './AndroidSampleNativeListViewNativeComponent';

type Props = React.ComponentProps<typeof AndroidSampleNativeListViewNativeComponent>;

export class SampleNativeListView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<AndroidSampleNativeListViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      AndroidSampleNativeListViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <AndroidSampleNativeListViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
