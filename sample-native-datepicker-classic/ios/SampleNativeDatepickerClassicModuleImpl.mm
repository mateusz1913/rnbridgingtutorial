#import "SampleNativeDatepickerClassicModuleImpl.h"

#import "SampleNativeDatepickerClassic-Swift.h"

#import <React/RCTUtils.h>

/**
 * Native module's shared implementation
 */
@implementation SampleNativeDatepickerClassicModuleImpl

- (void)showRangeDatepickerWithTitle:(NSString *)title
{
    UIViewController *_Nullable presentedViewController = RCTPresentedViewController();
    if (presentedViewController == nil) {
        [self.delegate onError:[[NSError alloc] initWithDomain:@"SampleNativeDatepickerClassicModuleImpl" code:1234 userInfo:nil]];
        return;
    }
    [FastisWrapper presentWithTitle:title 
                     viewController:presentedViewController
                           onCancel:^{ [self.delegate onCancel]; }
                           onResult:^(NSDictionary<NSString *, NSDictionary<NSString *, NSNumber *> *> * result) { 
                                [self.delegate onResult:result];}];
}

@end
