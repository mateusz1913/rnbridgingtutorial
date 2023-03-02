import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  saveFileWithCallback(
    filename: string,
    callback: (result: {
      success: boolean,
      cancelled: boolean,
      error?: { code: number, message: string }
    }) => void
    ): void
  saveFileWithPromise(filename: string): Promise<boolean>
}

export default TurboModuleRegistry.getEnforcing<Spec>('SaveFilePickerModule');