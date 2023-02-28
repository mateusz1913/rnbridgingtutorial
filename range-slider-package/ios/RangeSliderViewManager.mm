#import "RangeSliderViewManager.h"

#import "RangeSliderPackage-Swift.h"

#if RCT_NEW_ARCH_ENABLED
#else
@interface RangeSliderViewManager () <RangeSliderViewDelegate>
@end
#endif

@implementation RangeSliderViewManager

RCT_EXPORT_MODULE(RangeSliderView)

RCT_EXPORT_VIEW_PROPERTY(activeColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(inactiveColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(leftKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(minValue, double)
RCT_EXPORT_VIEW_PROPERTY(maxValue, double)
RCT_EXPORT_VIEW_PROPERTY(rightKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(step, NSInteger)
RCT_EXPORT_VIEW_PROPERTY(onRangeSliderViewBeginDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onRangeSliderViewEndDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onRangeSliderViewValueChange, RCTDirectEventBlock)

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(setLeftKnobValueProgrammatically:(nonnull NSNumber*) reactTag, value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RangeSliderView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RangeSliderView class]]) {
            return;
        }
        [view setLeftKnobValue:value];
    }];
}

RCT_EXPORT_METHOD(setRightKnobValueProgrammatically:(nonnull NSNumber*) reactTag, value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RangeSliderView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[RangeSliderView class]]) {
            return;
        }
        [view setRightKnobValue:value];
    }];
}

- (void)sendOnRangeSliderViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_onRangeSliderViewValueChange) {
        _onRangeSliderViewValueChange(@{ @"leftKnobValue": @(minValue), @"rightKnobValue": @(maxValue) });
    }
}

- (void)sendOnRangeSliderViewBeginDragEvent
{
    if (_onRangeSliderViewBeginDrag) {
        _onRangeSliderViewBeginDrag(nil);
    }
}

- (void)sendOnRangeSliderViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_onRangeSliderViewEndDrag) {
        _onRangeSliderViewEndDrag(@{ @"leftKnobValue": minValue, @"rightKnobValue": maxValue });
    }
}

- (UIView *)view
{
    RangeSliderView *view = [RangeSliderView new];
    view.delegate = self;
    return view;
}
#endif

@end
