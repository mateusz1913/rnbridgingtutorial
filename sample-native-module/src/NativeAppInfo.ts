import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  getAppBuildNumber(): string
  getAppBundleId(): string
  getAppVersion(): string
}

export default TurboModuleRegistry.getEnforcing<Spec>('SampleAppInfoModule');
