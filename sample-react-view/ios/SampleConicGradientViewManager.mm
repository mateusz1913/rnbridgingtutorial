#import "SampleConicGradientViewManager.h"

#import <React/RCTConvert.h>

#if RCT_NEW_ARCH_ENABLED
#else
#import "SampleConicGradientView.h"
#endif

@implementation SampleConicGradientViewManager

RCT_EXPORT_MODULE(SampleConicGradientView)

RCT_EXPORT_VIEW_PROPERTY(colors, NSArray<UIColor>)
RCT_EXPORT_VIEW_PROPERTY(locations, NSArray<NSNumber *>)
RCT_EXPORT_VIEW_PROPERTY(centerPoint, CGPoint)

#if RCT_NEW_ARCH_ENABLED
#else
- (UIView *)view
{
    SampleConicGradientView *view = [SampleConicGradientView new];
    return view;
}
#endif

@end
