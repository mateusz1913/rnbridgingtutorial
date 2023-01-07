import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

/**
 * https://github.com/facebook/react-native/blob/0.70-stable/packages/react-native-codegen/src/parsers/typescript/modules/errors.js#L16
 * 
 * All TurboModule specs must be called `Spec`
 */
export interface Spec extends TurboModule {
  // Synchronous methods without arguments
  getAppBuildNumber(): string
  getAppBundleId(): string
  getAppVersion(): string
}

// TurboModuleRegistry is backward compatible (to RN 0.65), for old arch it falls back to NativeModules[<name of the module>]
export default TurboModuleRegistry.get<Spec>('SampleAppInfoModule') as Spec | null;
