#import "SaveFilePickerModule.h"

/**
 * When using Swift classes in ObjC implementation, the classes must be imported
 * from generated Objective-C Interface Header
 *
 * @see https://developer.apple.com/documentation/swift/importing-swift-into-objective-c#Import-Code-Within-an-App-Target
 */
#import "SaveFilePickerPackage-Swift.h"

#if RCT_NEW_ARCH_ENABLED
/**
 * Import header file with codegenerated protocols based on the JS specification
 *
 * The name of the header matches the name provided in codegenConfig's `name` field in package.json
 */
#import "SaveFilePickerPackage.h"

// Each turbo module extends codegenerated spec class
@interface SaveFilePickerModule () <NativeSaveFilePickerModuleSpec>
@end
#endif

@interface SaveFilePickerModule () <SaveFilePickerModuleDelegate>
@end

// Declare the ObjC implementation for that native module class
@implementation SaveFilePickerModule {
    SaveFilePickerModuleImpl *moduleImpl;
    RCTResponseSenderBlock callbackBlock;
    RCTPromiseResolveBlock resolveBlock;
    RCTPromiseRejectBlock rejectBlock;
}

// Return the name of the module - it should match the name provided in JS specification
RCT_EXPORT_MODULE(SaveFilePickerModule)

- (instancetype)init {
    self = [super init];
    if (self) {
        moduleImpl = [SaveFilePickerModuleImpl new];
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

// Exported methods are overriden - based on the spec class
RCT_EXPORT_METHOD(saveFileWithCallback : (NSString *)filename
                              callback : (RCTResponseSenderBlock)callback)
{
    callbackBlock = callback;
    [moduleImpl saveFileWithFilename:filename];
}

RCT_EXPORT_METHOD(saveFileWithPromise : (NSString *)filename
                              resolve : (RCTPromiseResolveBlock)resolve
                               reject : (RCTPromiseRejectBlock)reject)
{
    resolveBlock = resolve;
    rejectBlock = reject;
    [moduleImpl saveFileWithFilename:filename];
}

- (void)onSuccess
{
    if (callbackBlock != nil) {
        callbackBlock(@[@{ @"success": @(YES), @"cancelled": @(NO) }]);
    } else if (resolveBlock != nil) {
        resolveBlock(@(YES));
    }
    callbackBlock = nil;
    resolveBlock = nil;
    rejectBlock = nil;
}

- (void)onCancel
{
    if (callbackBlock != nil) {
        callbackBlock(@[@{ @"success": @(NO), @"cancelled": @(YES) }]);
    } else if (resolveBlock != nil) {
        resolveBlock(@(NO));
    }
    callbackBlock = nil;
    resolveBlock = nil;
    rejectBlock = nil;
}

- (void)onError:(NSError *)error
{
    if (callbackBlock != nil) {
        callbackBlock(@[@{ @"success": @(NO), @"cancelled": @(NO), @"error": @{ @"code": @(error.code), @"message": error.localizedDescription } }]);
    } else if (rejectBlock != nil) {
        rejectBlock([NSString stringWithFormat:@"%@", @(error.code)], error.localizedDescription, error);
    }
    callbackBlock = nil;
    resolveBlock = nil;
    rejectBlock = nil;
}

#if RCT_NEW_ARCH_ENABLED
// Implement RCTTurboModule protocol
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeSaveFilePickerModuleSpecJSI>(params);
}
#endif

@end
