#import "RNNativeListViewManager.h"

#import <React/RCTConvert.h>

#import "NativeListPackage-Swift.h"

@implementation RNNativeListViewManager

RCT_EXPORT_MODULE(RNNativeListView)

RCT_CUSTOM_VIEW_PROPERTY(data, NSArray, RNNativeListViewContainerView)
{
    [view.viewController setData:[RCTConvert NSArray:json]];
}
RCT_CUSTOM_VIEW_PROPERTY(options, NSDictionary, RNNativeListViewContainerView)
{
    [view.viewController setPlaceholderImage:[RCTConvert NSString:json[@"placeholderImage"]]];
}
RCT_CUSTOM_VIEW_PROPERTY(backgroundColor, UIColor, RNNativeListViewContainerView)
{
    [view.viewController setBackgroundColor:[RCTConvert UIColor:json]];
}

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(scrollToItem:(nonnull NSNumber*) reactTag, index:(NSInteger) index) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNNativeListViewContainerView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RNNativeListViewContainerView class]]) {
            return;
        }
        [view.viewController scrollToItem:index];
    }];
}

- (UIView *)view
{
    RNNativeListViewContainerView *view = [RNNativeListViewContainerView new];
    view.viewController = [RNNativeListViewViewController new];
    return view;
}
#endif

@end
