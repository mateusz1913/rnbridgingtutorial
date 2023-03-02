import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface AndroidNativeListViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type AndroidNativeListViewComponent = HostComponent<AndroidNativeListViewProps>;

export interface AndroidNativeListViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<AndroidNativeListViewComponent>, index: Int32) => void;
}

export const AndroidNativeListViewCommands = codegenNativeCommands<AndroidNativeListViewNativeCommands>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<AndroidNativeListViewProps>('AndroidNativeListView', {
  excludedPlatforms: [ 'iOS' ],
}) as AndroidNativeListViewComponent;
