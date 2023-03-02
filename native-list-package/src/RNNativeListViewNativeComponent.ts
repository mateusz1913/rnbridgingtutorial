import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface RNNativeListViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type RNNativeListViewComponent = HostComponent<RNNativeListViewProps>;

export interface RNNativeListViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<RNNativeListViewComponent>, index: Int32) => void;
}

export const RNNativeListViewCommands = codegenNativeCommands<RNNativeListViewNativeCommands>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<RNNativeListViewProps>('RNNativeListView', {
  excludedPlatforms: [ 'android' ],
}) as RNNativeListViewComponent;
