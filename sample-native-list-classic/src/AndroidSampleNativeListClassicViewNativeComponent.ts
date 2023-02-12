import type * as React from 'react';
import type {
  HostComponent,
  ViewProps,
} from 'react-native';
import type { Int32 } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeCommands from 'react-native/Libraries/Utilities/codegenNativeCommands';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type DataItem = { imageUrl: string; description: string }

export interface AndroidSampleNativeListClassicViewProps extends ViewProps {
  data: ReadonlyArray<Readonly<DataItem>>;
  options: { placeholderImage: string };
}

export type AndroidSampleNativeListClassicViewComponent = HostComponent<AndroidSampleNativeListClassicViewProps>;

export interface AndroidSampleNativeListClassicViewNativeCommands {
  scrollToItem: (viewRef: React.ElementRef<AndroidSampleNativeListClassicViewComponent>, index: Int32) => void;
}

export const AndroidSampleNativeListClassicViewCommands = codegenNativeCommands<
  AndroidSampleNativeListClassicViewNativeCommands
>({
  supportedCommands: [ 'scrollToItem' ],
});

export default codegenNativeComponent<AndroidSampleNativeListClassicViewProps>('AndroidSampleNativeListClassicView', {
  excludedPlatforms: [ 'iOS' ],
}) as AndroidSampleNativeListClassicViewComponent;
