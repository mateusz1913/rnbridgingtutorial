import * as React from 'react';

import type { AndroidSampleNativeListClassicViewComponent } from './AndroidSampleNativeListClassicViewNativeComponent';
import AndroidSampleNativeListClassicViewNativeComponent, { AndroidSampleNativeListClassicViewCommands } from './AndroidSampleNativeListClassicViewNativeComponent';

type Props = React.ComponentProps<typeof AndroidSampleNativeListClassicViewNativeComponent>;

export class SampleNativeListClassicView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<AndroidSampleNativeListClassicViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      AndroidSampleNativeListClassicViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <AndroidSampleNativeListClassicViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
