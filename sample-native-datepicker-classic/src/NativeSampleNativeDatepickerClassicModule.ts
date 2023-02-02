import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

type DateResult = Readonly<{ day: number, month: number, year: number }>
type RangeDateResult = Readonly<{ from: DateResult, to: DateResult }>

export interface Spec extends TurboModule {
  showRangeDatepickerWithCallback(
    title: string,
    onResult: (result: RangeDateResult | null) => void
  ): void
  showRangeDatepickerWithPromise(config: { title: string }): Promise<RangeDateResult | null>
}

export default TurboModuleRegistry.getEnforcing<Spec>('SampleNativeDatepickerClassicModule');