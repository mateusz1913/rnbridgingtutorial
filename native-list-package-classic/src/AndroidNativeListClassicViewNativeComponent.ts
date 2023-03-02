import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface AndroidNativeListClassicViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type AndroidNativeListClassicViewComponent = HostComponent<AndroidNativeListClassicViewProps>;

export interface AndroidNativeListClassicViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<AndroidNativeListClassicViewComponent>, index: Int32) => void;
}

export const AndroidNativeListClassicViewCommands = codegenNativeCommands<
  AndroidNativeListClassicViewNativeCommands
>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<AndroidNativeListClassicViewProps>('AndroidNativeListClassicView', {
  excludedPlatforms: [ 'iOS' ],
}) as AndroidNativeListClassicViewComponent;
