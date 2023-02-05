#import "SampleConicGradientClassicViewManager.h"

#import <React/RCTConvert.h>

#import "SampleConicGradientClassicView.h"

@implementation SampleConicGradientClassicViewManager

RCT_EXPORT_MODULE(SampleConicGradientClassicView)

RCT_EXPORT_VIEW_PROPERTY(colors, NSArray<UIColor>)
RCT_EXPORT_VIEW_PROPERTY(locations, NSArray<NSNumber *>)
RCT_EXPORT_VIEW_PROPERTY(centerPoint, CGPoint)

#if RCT_NEW_ARCH_ENABLED
#else
- (UIView *)view
{
    SampleConicGradientClassicView *view = [SampleConicGradientClassicView new];
    return view;
}
#endif

@end
