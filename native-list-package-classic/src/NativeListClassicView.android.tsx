import * as React from 'react';

import type { AndroidNativeListClassicViewComponent } from './AndroidNativeListClassicViewNativeComponent';
import AndroidNativeListClassicViewNativeComponent, { AndroidNativeListClassicViewCommands } from './AndroidNativeListClassicViewNativeComponent';

type Props = React.ComponentProps<typeof AndroidNativeListClassicViewNativeComponent>;

export class NativeListClassicView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<AndroidNativeListClassicViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      AndroidNativeListClassicViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <AndroidNativeListClassicViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
