#import "ConicGradientClassicViewManager.h"

#if RCT_NEW_ARCH_ENABLED
#else
#import "ConicGradientClassicView.h"
#endif

@implementation ConicGradientClassicViewManager

RCT_EXPORT_MODULE(ConicGradientClassicView)

RCT_EXPORT_VIEW_PROPERTY(colors, NSArray<UIColor>)
RCT_EXPORT_VIEW_PROPERTY(locations, NSArray<NSNumber *>)
RCT_EXPORT_VIEW_PROPERTY(centerPoint, CGPoint)

#if RCT_NEW_ARCH_ENABLED
#else
- (UIView *)view
{
    ConicGradientClassicView *view = [ConicGradientClassicView new];
    return view;
}
#endif

@end
