import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface RNSampleNativeListViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type RNSampleNativeListViewComponent = HostComponent<RNSampleNativeListViewProps>;

export interface RNSampleNativeListViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<RNSampleNativeListViewComponent>, index: Int32) => void;
}

export const RNSampleNativeListViewCommands = codegenNativeCommands<RNSampleNativeListViewNativeCommands>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<RNSampleNativeListViewProps>('RNSampleNativeListView', {
  excludedPlatforms: [ 'android' ],
}) as RNSampleNativeListViewComponent;
