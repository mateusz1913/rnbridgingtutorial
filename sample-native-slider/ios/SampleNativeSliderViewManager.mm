#import "SampleNativeSliderViewManager.h"

#import <React/RCTConvert.h>

#import "SampleNativeSlider-Swift.h"

#if RCT_NEW_ARCH_ENABLED
#else
@interface SampleNativeSliderViewManager () <SampleNativeSliderViewDelegate>
@end
#endif

@implementation SampleNativeSliderViewManager

RCT_EXPORT_MODULE(SampleNativeSliderView)

RCT_EXPORT_VIEW_PROPERTY(activeColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(inactiveColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(leftKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(minValue, double)
RCT_EXPORT_VIEW_PROPERTY(maxValue, double)
RCT_EXPORT_VIEW_PROPERTY(rightKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(step, NSInteger)
RCT_EXPORT_VIEW_PROPERTY(onSampleNativeSliderViewBeginDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onSampleNativeSliderViewEndDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onSampleNativeSliderViewValueChange, RCTDirectEventBlock)

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(setLeftKnobValueProgrammatically:(nonnull NSNumber*) reactTag, value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        SampleNativeSliderView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[SampleNativeSliderView class]]) {
            return;
        }
        [view setLeftKnobValue:value];
    }];
}

RCT_EXPORT_METHOD(setRightKnobValueProgrammatically:(nonnull NSNumber*) reactTag, value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        SampleNativeSliderView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[SampleNativeSliderView class]]) {
            return;
        }
        [view setRightKnobValue:value];
    }];
}

- (void)sendOnSampleNativeSliderViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_onSampleNativeSliderViewValueChange) {
        _onSampleNativeSliderViewValueChange(@{ @"leftKnobValue": @(minValue), @"rightKnobValue": @(maxValue) });
    }
}

- (void)sendOnSampleNativeSliderViewBeginDragEvent
{
    if (_onSampleNativeSliderViewBeginDrag) {
        _onSampleNativeSliderViewBeginDrag(nil);
    }
}

- (void)sendOnSampleNativeSliderViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_onSampleNativeSliderViewEndDrag) {
        _onSampleNativeSliderViewEndDrag(@{ @"leftKnobValue": minValue, @"rightKnobValue": maxValue });
    }
}

- (UIView *)view
{
    SampleNativeSliderView *view = [SampleNativeSliderView new];
    view.delegate = self;
    return view;
}
#endif

@end
