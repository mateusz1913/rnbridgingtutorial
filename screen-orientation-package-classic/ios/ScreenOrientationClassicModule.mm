#import "ScreenOrientationClassicModule.h"

#import "ScreenOrientationClassicModuleImpl.h"

#if RCT_NEW_ARCH_ENABLED
/**
 * Import header file with codegenerated protocols based on the JS specification
 *
 * The name of the header matches the name provided in codegenConfig's `name` field in package.json
 */
#import "ScreenOrientationPackageClassic.h"

// Each turbo module extends codegenerated spec class
@interface ScreenOrientationClassicModule () <NativeScreenOrientationClassicModuleSpec>
@end
#endif

@interface ScreenOrientationClassicModule () <ScreenOrientationClassicModuleDelegate>
@end

// Declare the ObjC implementation for that native module class
@implementation ScreenOrientationClassicModule {
    ScreenOrientationClassicModuleImpl *moduleImpl;
    BOOL hasListeners;
}

// Return the name of the module - it should match the name provided in JS specification
RCT_EXPORT_MODULE(ScreenOrientationClassicModule)

- (instancetype)init {
    self = [super init];
    if (self) {
        moduleImpl = [ScreenOrientationClassicModuleImpl new];
        moduleImpl.delegate = self;
    }
    return self;
}

// Declare if module should be initialized on the main queue
+ (BOOL)requiresMainQueueSetup
{
    return NO;
}

// Declare which events will be emitted by the module
- (NSArray<NSString *> *)supportedEvents
{
    return [ScreenOrientationClassicModuleImpl supportedEvents];
}

- (void)startObserving
{
    hasListeners = YES;
}

- (void)stopObserving
{
    hasListeners = NO;
}

- (void)sendEventWithName:(NSString * _Nonnull)eventName
                  payload:(NSDictionary<NSString *,id> * _Nonnull)payload
{
    if (hasListeners) {
        [self sendEventWithName:eventName body:payload];
    }
}

/**
 * Declare constants exported by the module
 */
#if RCT_NEW_ARCH_ENABLED
- (facebook::react::ModuleConstants<JS::NativeScreenOrientationClassicModule::Constants::Builder>)constantsToExport
{
    return [self getConstants];
}

- (facebook::react::ModuleConstants<JS::NativeScreenOrientationClassicModule::Constants::Builder>)getConstants {
    return facebook::react::typedConstants<JS::NativeScreenOrientationClassicModule::Constants::Builder>({
        .PORTRAIT = @"portrait",
        .LANDSCAPE = @"landscape"
    });
}
#else
- (NSDictionary *)constantsToExport
{
    return @{ @"PORTRAIT": @"portrait", @"LANDSCAPE": @"landscape" };
}
#endif

#if RCT_NEW_ARCH_ENABLED
// Implement RCTTurboModule protocol
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeScreenOrientationClassicModuleSpecJSI>(params);
}
#endif

@end
