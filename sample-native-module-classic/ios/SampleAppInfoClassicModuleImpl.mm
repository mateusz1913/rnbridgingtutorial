#import "SampleAppInfoClassicModuleImpl.h"

/**
 * Native module's shared implementation
 */
@implementation SampleAppInfoClassicModuleImpl

- (NSString *)getAppBuildNumber
{
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleVersion"];
}

- (NSString *)getAppBundleId
{
    return [[NSBundle mainBundle] bundleIdentifier];
}

- (NSString *)getAppVersion
{
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"];
}

@end
