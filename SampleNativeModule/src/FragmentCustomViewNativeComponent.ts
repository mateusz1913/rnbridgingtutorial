import type { HostComponent, ViewProps } from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface FragmentViewProps extends ViewProps {}

export default codegenNativeComponent<FragmentViewProps>('FragmentCustomView') as HostComponent<FragmentViewProps>;
