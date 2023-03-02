import * as React from 'react';

import type { AndroidNativeListViewComponent } from './AndroidNativeListViewNativeComponent';
import AndroidNativeListViewNativeComponent, { AndroidNativeListViewCommands } from './AndroidNativeListViewNativeComponent';

type Props = React.ComponentProps<typeof AndroidNativeListViewNativeComponent>;

export class NativeListView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<AndroidNativeListViewComponent>>();

  scrollToItem = (index: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      AndroidNativeListViewCommands.scrollToItem(ref, index);
    }
  };

  render() {
    return <AndroidNativeListViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
