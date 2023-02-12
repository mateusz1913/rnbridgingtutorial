#import "RNSampleNativeListClassicViewContainerView.h"

#import <React/UIView+React.h>

@implementation RNSampleNativeListClassicViewContainerView {
    RNSampleNativeListClassicViewViewController * _Nullable internalViewController;
}

- (RNSampleNativeListClassicViewViewController *)viewController
{
    return internalViewController;
}

- (void)setViewController:(RNSampleNativeListClassicViewViewController *)newViewController
{
    [self unmountViewController];
    internalViewController = newViewController;
    if (newViewController != nil) {
        [self mountViewController];
    }
}

- (void)layoutSubviews
{
    [super layoutSubviews];
    if (self.viewController != nil) {
        [self.viewController.view setFrame:self.frame];
    }
}

- (void)removeFromSuperview
{
    [self unmountViewController];
    [super removeFromSuperview];
}

- (void)willMoveToWindow:(UIWindow *)newWindow
{
    if (newWindow == nil) {
        [self unmountViewController];
    } else {
        [self mountViewController];
    }
}

- (void)mountViewController
{
    if (self.viewController == nil) {
        return;
    }

    if (self.viewController.parentViewController != nil) {
        return;
    }

    UIViewController *reactViewController = self.reactViewController;
    if (reactViewController == nil) {
        return;
    }

    [reactViewController addChildViewController:self.viewController];
    [self addSubview:self.viewController.view];
    [self.viewController didMoveToParentViewController:reactViewController];
}

- (void)unmountViewController
{
    if (self.viewController == nil) {
        return;
    }

    if (self.viewController.parentViewController == nil) {
        return;
    }

    [self.viewController willMoveToParentViewController:nil];
    [self.viewController.view removeFromSuperview];
    [self.viewController removeFromParentViewController];
}

@end
