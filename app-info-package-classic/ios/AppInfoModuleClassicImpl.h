#import <Foundation/Foundation.h>

@interface AppInfoModuleClassicImpl : NSObject

- (NSString *)getAppBuildNumber;
- (NSString *)getAppBundleId;
- (NSString *)getAppVersion;

@end
