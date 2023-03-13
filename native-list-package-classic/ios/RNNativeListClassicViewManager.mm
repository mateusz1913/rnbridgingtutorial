#import "RNNativeListClassicViewManager.h"

#import <React/RCTConvert.h>

#import "RNNativeListClassicViewContainerView.h"
#import "RNNativeListClassicViewViewController.h"

@implementation RNNativeListClassicViewManager

RCT_EXPORT_MODULE(RNNativeListClassicView)

RCT_CUSTOM_VIEW_PROPERTY(data, NSArray, RNNativeListClassicViewContainerView)
{
    NSArray<NSDictionary *> *array = [RCTConvert NSDictionaryArray:json];
    NSMutableArray<ClassicDataItem *> *data = [NSMutableArray arrayWithCapacity:array.count];
    for (int i = 0; i < array.count; i++) {
        [data insertObject:[[ClassicDataItem alloc] initWithImageUrl:array[i][@"imageUrl"] itemDescription:array[i][@"description"]] atIndex:i];
    }
    [view.viewController setData:data];
}
RCT_CUSTOM_VIEW_PROPERTY(options, NSDictionary, RNNativeListClassicViewContainerView)
{
    [view.viewController setPlaceholderImage:[RCTConvert NSString:json[@"placeholderImage"]]];
}
RCT_CUSTOM_VIEW_PROPERTY(backgroundColor, UIColor, RNNativeListClassicViewContainerView)
{
    [view.viewController setBackgroundColor:[RCTConvert UIColor:json]];
}

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(scrollToItem:(nonnull NSNumber*) reactTag index:(NSInteger) index) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        UIView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RNNativeListClassicViewContainerView class]]) {
            return;
        }
        [((RNNativeListClassicViewContainerView *) view).viewController scrollToItem:index];
    }];
}

- (UIView *)view
{
    RNNativeListClassicViewContainerView *view = [RNNativeListClassicViewContainerView new];
    view.viewController = [RNNativeListClassicViewViewController new];
    return view;
}
#endif

@end
