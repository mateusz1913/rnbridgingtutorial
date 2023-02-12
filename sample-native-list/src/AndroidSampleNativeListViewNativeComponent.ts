import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface AndroidSampleNativeListViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type AndroidSampleNativeListViewComponent = HostComponent<AndroidSampleNativeListViewProps>;

export interface AndroidSampleNativeListViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<AndroidSampleNativeListViewComponent>, index: Int32) => void;
}

export const AndroidSampleNativeListViewCommands = codegenNativeCommands<AndroidSampleNativeListViewNativeCommands>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<AndroidSampleNativeListViewProps>('AndroidSampleNativeListView', {
  excludedPlatforms: [ 'iOS' ],
}) as AndroidSampleNativeListViewComponent;
