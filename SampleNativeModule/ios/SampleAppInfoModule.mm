#import "SampleAppInfoModule.h"

// This piece of code will run only when new arch is enabled.
#if RCT_NEW_ARCH_ENABLED

// Import header file with codegenerated protocols based on the JS specification
//
// The name of the header matches the name provided in codegenConfig's `name` field in package.json
#import "SampleNativeModule.h"

// Make this class conforming to codegenerated protocol
@interface SampleAppInfoModule () <NativeAppInfoSpec>

@end

#endif

// Declare the ObjC implementation for that native module class
//
// It must invoke RCT_EXPORT_MODULE that registers native module
// for usage in JS code
@implementation SampleAppInfoModule

// Takes (optional) single argument which is a module's JS name
//
// If argument is omitted the ObjC class's name is taken as JS-name
//
// Even if the names are the same, it's better to declare the name
// in RCT_EXPORT_MODULE, so that the ObjC can be later changed without
// breaking everything
RCT_EXPORT_MODULE(SampleAppInfoModule)

// Takes two arguments
//
// First is the return value of the method
//
// Second is the ObjC method signature
RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSString *, getAppBuildNumber)
{
    // Here goes native implementation of that method
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleVersion"];
}

RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSString *, getAppBundleId)
{
    return [[NSBundle mainBundle] bundleIdentifier];
}

RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSString *, getAppVersion)
{
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"];
}

// This piece of code will run only when new arch is enabled
#if RCT_NEW_ARCH_ENABLED

// Implement RCTTurboModule protocol
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params {
    return std::make_shared<facebook::react::NativeAppInfoSpecJSI>(params);
}

#endif

@end
