#import "ConicGradientViewManager.h"

#if RCT_NEW_ARCH_ENABLED
#else
#import "ConicGradientView.h"
#endif

@implementation ConicGradientViewManager

RCT_EXPORT_MODULE(ConicGradientView)

RCT_EXPORT_VIEW_PROPERTY(colors, NSArray<UIColor>)
RCT_EXPORT_VIEW_PROPERTY(locations, NSArray<NSNumber *>)
RCT_EXPORT_VIEW_PROPERTY(centerPoint, CGPoint)

#if RCT_NEW_ARCH_ENABLED
#else
- (UIView *)view
{
    ConicGradientView *view = [ConicGradientView new];
    return view;
}
#endif

@end
