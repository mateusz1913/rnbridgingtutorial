#import "SampleNativeScreenModule.h"

/**
 * When using Swift classes in ObjC implementation, the classes must be imported
 * from generated Objective-C Interface Header
 *
 * @see https://developer.apple.com/documentation/swift/importing-swift-into-objective-c#Import-Code-Within-an-App-Target
 */
#import "SampleNativeScreen-Swift.h"

#import <React/RCTConvert.h>

#if RCT_NEW_ARCH_ENABLED
/**
 * Import header file with codegenerated protocols based on the JS specification
 *
 * The name of the header matches the name provided in codegenConfig's `name` field in package.json
 */
#import "SampleNativeScreen.h"

// Each turbo module extends codegenerated spec class
@interface SampleNativeScreenModule () <NativeSampleNativeScreenModuleSpec>
@end
#endif

@interface SampleNativeScreenModule () <SampleNativeScreenModuleDelegate>
@end

// Declare the ObjC implementation for that native module class
@implementation SampleNativeScreenModule {
    SampleNativeScreenModuleImpl *moduleImpl;
    BOOL hasListeners;
}

// Return the name of the module - it should match the name provided in JS specification
RCT_EXPORT_MODULE(SampleNativeScreenModule)

- (instancetype)init
{
    self = [super init];
    if (self) {
        moduleImpl = [SampleNativeScreenModuleImpl new];
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

- (NSArray<NSString *> *)supportedEvents
{
    return [SampleNativeScreenModuleImpl supportedEvents];
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

// Exported methods are overriden - based on the spec class
RCT_EXPORT_METHOD(launchNativeScreen:(NSString *)valueFromJS)
{
    [moduleImpl launchNativeScreen:valueFromJS];
}

#if RCT_NEW_ARCH_ENABLED
// Implement RCTTurboModule protocol
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeSampleNativeScreenModuleSpecJSI>(params);
}
#endif

@end
