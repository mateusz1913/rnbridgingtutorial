#import "RNSampleNativeListClassicViewManager.h"

#import <React/RCTConvert.h>

#import "RNSampleNativeListClassicViewContainerView.h"
#import "RNSampleNativeListClassicViewViewController.h"

@implementation RNSampleNativeListClassicViewManager

RCT_EXPORT_MODULE(RNSampleNativeListClassicView)

RCT_CUSTOM_VIEW_PROPERTY(data, NSArray, RNSampleNativeListClassicViewContainerView)
{
    [view.viewController setData:[RCTConvert NSArray:json]];
}
RCT_CUSTOM_VIEW_PROPERTY(options, NSDictionary, RNSampleNativeListClassicViewContainerView)
{
    [view.viewController setPlaceholderImage:[RCTConvert NSString:json[@"placeholderImage"]]];
}
RCT_CUSTOM_VIEW_PROPERTY(backgroundColor, UIColor, RNSampleNativeListClassicViewContainerView)
{
    [view.viewController setBackgroundColor:[RCTConvert UIColor:json]];
}

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(scrollToItem:(nonnull NSNumber*) reactTag, index:(NSInteger) index) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNSampleNativeListClassicViewContainerView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RNSampleNativeListClassicViewContainerView class]]) {
            return;
        }
        [view.viewController scrollToItem:index];
    }];
}

- (UIView *)view
{
    RNSampleNativeListClassicViewContainerView *view = [RNSampleNativeListClassicViewContainerView new];
    view.viewController = [RNSampleNativeListClassicViewViewController new];
    return view;
}
#endif

@end
