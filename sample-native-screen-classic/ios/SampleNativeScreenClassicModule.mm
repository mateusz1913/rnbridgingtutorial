#import "SampleNativeScreenClassicModule.h"

#import "SampleNativeScreenClassicModuleImpl.h"

#import <React/RCTConvert.h>

#if RCT_NEW_ARCH_ENABLED
/**
 * Import header file with codegenerated protocols based on the JS specification
 *
 * The name of the header matches the name provided in codegenConfig's `name` field in package.json
 */
#import "SampleNativeScreenClassic.h"

// Each turbo module extends codegenerated spec class
@interface SampleNativeScreenClassicModule () <NativeSampleNativeScreenClassicModuleSpec>
@end
#endif

@interface SampleNativeScreenClassicModule () <SampleNativeScreenClassicModuleDelegate>
@end

// Declare the ObjC implementation for that native module class
@implementation SampleNativeScreenClassicModule {
    SampleNativeScreenClassicModuleImpl *moduleImpl;
    BOOL hasListeners;
}

// Return the name of the module - it should match the name provided in JS specification
RCT_EXPORT_MODULE(SampleNativeScreenClassicModule)

- (instancetype)init {
    self = [super init];
    if (self) {
        moduleImpl = [SampleNativeScreenClassicModuleImpl new];
        moduleImpl.delegate = self;
    }
    return self;
}

// Declare if module should be initialized on the main queue
+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

/**
 * If the module interacts with UIKit,
 * it can declare that its methods should be run on main queue
 */
- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

// Declare which events will be emiited by the module
- (NSArray<NSString *> *)supportedEvents
{
    return [SampleNativeScreenClassicModuleImpl supportedEvents];
}

- (void)startObserving
{
    hasListeners = YES;
}

- (void)stopObserving
{
    hasListeners = NO;
}

// Exported methods are overriden - based on the spec class
RCT_EXPORT_METHOD(launchNativeScreen:(NSString *)valueFromJS)
{
    [moduleImpl launchNativeScreen:valueFromJS];
}

- (void)sendEventWithName:(NSString * _Nonnull)eventName
                  payload:(NSDictionary<NSString *,id> * _Nonnull)payload
{
    if (hasListeners) {
        [self sendEventWithName:eventName body:payload];
    }
}

#if RCT_NEW_ARCH_ENABLED
// Implement RCTTurboModule protocol
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeSampleNativeScreenClassicModuleSpecJSI>(params);
}
#endif

@end
