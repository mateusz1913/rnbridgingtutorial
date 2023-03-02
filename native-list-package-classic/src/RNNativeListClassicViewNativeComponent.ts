import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface RNNativeListClassicViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type RNNativeListClassicViewComponent = HostComponent<RNNativeListClassicViewProps>;

export interface RNNativeListClassicViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<RNNativeListClassicViewComponent>, index: Int32) => void;
}

export const RNNativeListClassicViewCommands = codegenNativeCommands<
  RNNativeListClassicViewNativeCommands
>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<RNNativeListClassicViewProps>('RNNativeListClassicView', {
  excludedPlatforms: [ 'android' ],
}) as RNNativeListClassicViewComponent;
