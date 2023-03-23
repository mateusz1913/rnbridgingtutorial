#import "ScreenOrientationModule.h"

/**
 * When using Swift classes in ObjC implementation, the classes must be imported
 * from generated Objective-C Interface Header
 *
 * @see https://developer.apple.com/documentation/swift/importing-swift-into-objective-c#Import-Code-Within-an-App-Target
 */
#import "ScreenOrientationPackage-Swift.h"

#if RCT_NEW_ARCH_ENABLED
/**
 * Import header file with codegenerated protocols based on the JS specification
 *
 * The name of the header matches the name provided in codegenConfig's `name` field in package.json
 */
#import "ScreenOrientationPackage.h"

// Each turbo module extends codegenerated spec class
@interface ScreenOrientationModule () <NativeScreenOrientationModuleSpec>
@end
#endif

@interface ScreenOrientationModule () <ScreenOrientationModuleDelegate>
@end

// Declare the ObjC implementation for that native module class
@implementation ScreenOrientationModule {
    ScreenOrientationModuleImpl *moduleImpl;
    BOOL hasListeners;
}

// Return the name of the module - it should match the name provided in JS specification
RCT_EXPORT_MODULE(ScreenOrientationModule)

- (instancetype)init {
    self = [super init];
    if (self) {
        moduleImpl = [ScreenOrientationModuleImpl new];
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
    return [ScreenOrientationModuleImpl supportedEvents];
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
- (facebook::react::ModuleConstants<JS::NativeScreenOrientationModule::Constants::Builder>)constantsToExport
{
    return [self getConstants];
}

- (facebook::react::ModuleConstants<JS::NativeScreenOrientationModule::Constants::Builder>)getConstants {
    return facebook::react::typedConstants<JS::NativeScreenOrientationModule::Constants::Builder>({
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
    return std::make_shared<facebook::react::NativeScreenOrientationModuleSpecJSI>(params);
}
#endif

@end
