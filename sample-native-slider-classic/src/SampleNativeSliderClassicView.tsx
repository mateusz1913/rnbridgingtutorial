import * as React from 'react';

import type { SampleNativeSliderClassicViewComponent } from './SampleNativeSliderClassicViewNativeComponent';
import SampleNativeSliderClassicViewNativeComponent, { SampleNativeSliderClassicViewCommands } from './SampleNativeSliderClassicViewNativeComponent';

type Props = React.ComponentProps<typeof SampleNativeSliderClassicViewNativeComponent>;

export class SampleNativeSliderClassicView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<SampleNativeSliderClassicViewComponent>>();

  setLeftKnobValueProgrammatically = (value: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      SampleNativeSliderClassicViewCommands.setLeftKnobValueProgrammatically(ref, value);
    }
  };

  setRightKnobValueProgrammatically = (value: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      SampleNativeSliderClassicViewCommands.setRightKnobValueProgrammatically(ref, value);
    }
  };

  render() {
    return <SampleNativeSliderClassicViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
