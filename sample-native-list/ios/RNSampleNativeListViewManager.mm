#import "RNSampleNativeListViewManager.h"

#import <React/RCTConvert.h>

#import "SampleNativeList-Swift.h"

@implementation RNSampleNativeListViewManager

RCT_EXPORT_MODULE(RNSampleNativeListView)

RCT_CUSTOM_VIEW_PROPERTY(data, NSArray, RNSampleNativeListViewContainerView)
{
    [view.viewController setData:[RCTConvert NSArray:json]];
}
RCT_CUSTOM_VIEW_PROPERTY(options, NSDictionary, RNSampleNativeListViewContainerView)
{
    [view.viewController setPlaceholderImage:[RCTConvert NSString:json[@"placeholderImage"]]];
}
RCT_CUSTOM_VIEW_PROPERTY(backgroundColor, UIColor, RNSampleNativeListViewContainerView)
{
    [view.viewController setBackgroundColor:[RCTConvert UIColor:json]];
}

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(scrollToItem:(nonnull NSNumber*) reactTag, index:(NSInteger) index) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNSampleNativeListViewContainerView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RNSampleNativeListViewContainerView class]]) {
            return;
        }
        [view.viewController scrollToItem:index];
    }];
}

- (UIView *)view
{
    RNSampleNativeListViewContainerView *view = [RNSampleNativeListViewContainerView new];
    view.viewController = [RNSampleNativeListViewViewController new];
    return view;
}
#endif

@end
