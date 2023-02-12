import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface RNSampleNativeListClassicViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type RNSampleNativeListClassicViewComponent = HostComponent<RNSampleNativeListClassicViewProps>;

export interface RNSampleNativeListClassicViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<RNSampleNativeListClassicViewComponent>, index: Int32) => void;
}

export const RNSampleNativeListClassicViewCommands = codegenNativeCommands<
  RNSampleNativeListClassicViewNativeCommands
>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<RNSampleNativeListClassicViewProps>('RNSampleNativeListClassicView', {
  excludedPlatforms: [ 'android' ],
}) as RNSampleNativeListClassicViewComponent;
