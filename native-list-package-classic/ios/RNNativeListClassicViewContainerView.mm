#import "RNNativeListClassicViewContainerView.h"

#import <React/UIView+React.h>

@implementation RNNativeListClassicViewContainerView {
    RNNativeListClassicViewViewController * _Nullable internalViewController;
}

- (RNNativeListClassicViewViewController *)viewController
{
    return internalViewController;
}

- (void)setViewController:(RNNativeListClassicViewViewController *)newViewController
{
    [self unmountViewController];
    internalViewController = newViewController;
    if (newViewController != nil) {
        [self mountViewController];
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
    
    self.viewController.view.translatesAutoresizingMaskIntoConstraints = NO;
    [NSLayoutConstraint activateConstraints:@[
        [self.viewController.view.topAnchor constraintEqualToAnchor:self.topAnchor],
        [self.viewController.view.leadingAnchor constraintEqualToAnchor:self.leadingAnchor],
        [self.viewController.view.trailingAnchor constraintEqualToAnchor:self.trailingAnchor],
        [self.viewController.view.bottomAnchor constraintEqualToAnchor:self.bottomAnchor]
    ]];
    
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
