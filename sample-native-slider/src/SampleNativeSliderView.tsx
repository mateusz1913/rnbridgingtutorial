import * as React from 'react';

import type { SampleNativeSliderViewComponent } from './SampleNativeSliderViewNativeComponent';
import SampleNativeSliderViewNativeComponent, { SampleNativeSliderViewCommands } from './SampleNativeSliderViewNativeComponent';

type Props = React.ComponentProps<typeof SampleNativeSliderViewNativeComponent>;

export class SampleNativeSliderView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<SampleNativeSliderViewComponent>>();

  setLeftKnobValueProgrammatically = (value: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      SampleNativeSliderViewCommands.setLeftKnobValueProgrammatically(ref, value);
    }
  };

  setRightKnobValueProgrammatically = (value: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      SampleNativeSliderViewCommands.setRightKnobValueProgrammatically(ref, value);
    }
  };

  render() {
    return <SampleNativeSliderViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
