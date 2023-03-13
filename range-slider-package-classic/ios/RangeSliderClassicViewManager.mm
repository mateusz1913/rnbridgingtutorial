#import "RangeSliderClassicViewManager.h"

#import "RangeSliderClassicView.h"

#if RCT_NEW_ARCH_ENABLED
#else
@interface RangeSliderClassicViewManager () <RangeSliderClassicViewDelegate>
@end
#endif

@implementation RangeSliderClassicViewManager {
    RangeSliderClassicView *sliderView;
}

RCT_EXPORT_MODULE(RangeSliderClassicView)

RCT_EXPORT_VIEW_PROPERTY(activeColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(inactiveColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(leftKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(minValue, double)
RCT_EXPORT_VIEW_PROPERTY(maxValue, double)
RCT_EXPORT_VIEW_PROPERTY(rightKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(step, NSInteger)
RCT_EXPORT_VIEW_PROPERTY(onRangeSliderClassicViewBeginDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onRangeSliderClassicViewEndDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onRangeSliderClassicViewValueChange, RCTDirectEventBlock)

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(setLeftKnobValueProgrammatically:(nonnull NSNumber*) reactTag value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        UIView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RangeSliderClassicView class]]) {
            return;
        }
        [(RangeSliderClassicView *)view setLeftKnobValue:value];
    }];
}

RCT_EXPORT_METHOD(setRightKnobValueProgrammatically:(nonnull NSNumber*) reactTag value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        UIView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RangeSliderClassicView class]]) {
            return;
        }
        [(RangeSliderClassicView *) view setRightKnobValue:value];
    }];
}

- (void)sendOnRangeSliderClassicViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (sliderView.onRangeSliderClassicViewValueChange) {
        sliderView.onRangeSliderClassicViewValueChange(@{ @"leftKnobValue": @(minValue), @"rightKnobValue": @(maxValue) });
    }
}

- (void)sendOnRangeSliderClassicViewBeginDragEvent
{
    if (sliderView.onRangeSliderClassicViewBeginDrag) {
        sliderView.onRangeSliderClassicViewBeginDrag(nil);
    }
}

- (void)sendOnRangeSliderClassicViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (sliderView.onRangeSliderClassicViewEndDrag) {
        sliderView.onRangeSliderClassicViewEndDrag(@{ @"leftKnobValue": @(minValue), @"rightKnobValue": @(maxValue) });
    }
}

- (UIView *)view
{
    RangeSliderClassicView *view = [RangeSliderClassicView new];
    view.delegate = self;
    sliderView = view;
    return view;
}
#endif

@end
