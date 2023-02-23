#import "AppInfoModuleClassicImpl.h"

/**
 * Native module's shared implementation
 */
@implementation AppInfoModuleClassicImpl

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
