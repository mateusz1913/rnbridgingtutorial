#import "SampleNativeScreenClassicModuleImpl.h"

#import "SampleNativeClassicViewController.h"

#import <React/RCTUtils.h>

NSString *SampleNativeScreenClassicModuleEventName(SampleNativeScreenClassicModuleEvent event)
{
    switch (event) {
        case OnResultClassic:
            return @"onResultClassic";
    }
}

@interface SampleNativeScreenClassicModuleImpl () <SampleNativeClassicViewControllerDelegate>
@end

/**
 * Native module's shared implementation
 */
@implementation SampleNativeScreenClassicModuleImpl

- (void)launchNativeScreen:(NSString *)valueFromJS
{
    UIViewController *presentedViewController = RCTPresentedViewController();
    if (presentedViewController == nil) {
        return;
    }

    SampleNativeClassicViewController *viewController = [SampleNativeClassicViewController new];
    viewController.delegate = self;
    viewController.headerText = valueFromJS;

    UINavigationController *navigationController = [[UINavigationController alloc] initWithRootViewController:viewController];
    navigationController.modalPresentationStyle = UIModalPresentationFullScreen;

    [presentedViewController presentViewController:navigationController animated:YES completion:nil];
}

/**
 * Example usage:
 *
 * ```objc
 * [self sendEvent:SampleNativeScreenClassicModuleEventName(OnResultClassic) payload:@{ @"value" : result }];
 * ````
 */
- (void)sendEvent:(NSString *)name payload:(NSDictionary<NSString *, id> *)payload {
    [self.delegate sendEventWithName:name payload:payload];
}

+ (NSArray<NSString *> *)supportedEvents
{
    return @[SampleNativeScreenClassicModuleEventName(OnResultClassic)];
}

- (void)onSubmit:(NSString *)text
{
    [self sendEvent:SampleNativeScreenClassicModuleEventName(OnResultClassic) 
            payload:@{ @"text": text, @"success": @(YES) }];
}

- (void)onCancel
{
    [self sendEvent:SampleNativeScreenClassicModuleEventName(OnResultClassic) 
            payload:@{ @"success": @(NO) }];
}

@end
