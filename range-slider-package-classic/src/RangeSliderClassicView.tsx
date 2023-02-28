import * as React from 'react';

import type { RangeSliderClassicViewComponent } from './RangeSliderClassicViewNativeComponent';
import RangeSliderClassicViewNativeComponent, { RangeSliderClassicViewCommands } from './RangeSliderClassicViewNativeComponent';

type Props = React.ComponentProps<typeof RangeSliderClassicViewNativeComponent>;

export class RangeSliderClassicView extends React.Component<Props> {
  private innerRef = React.createRef<React.ElementRef<RangeSliderClassicViewComponent>>();

  setLeftKnobValueProgrammatically = (value: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      RangeSliderClassicViewCommands.setLeftKnobValueProgrammatically(ref, value);
    }
  };

  setRightKnobValueProgrammatically = (value: number) => {
    const ref = this.innerRef.current;

    if (ref) {
      RangeSliderClassicViewCommands.setRightKnobValueProgrammatically(ref, value);
    }
  };

  render() {
    return <RangeSliderClassicViewNativeComponent ref={this.innerRef} {...this.props} />;
  }
}
