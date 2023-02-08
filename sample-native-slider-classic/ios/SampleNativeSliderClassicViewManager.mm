#import "SampleNativeSliderClassicViewManager.h"

#import <React/RCTConvert.h>

#import "SampleNativeSliderClassicView.h"

#if RCT_NEW_ARCH_ENABLED
#else
@interface SampleNativeSliderClassicViewManager () <SampleNativeSliderClassicViewDelegate>
@end
#endif

@implementation SampleNativeSliderClassicViewManager

RCT_EXPORT_MODULE(SampleNativeSliderClassicView)

RCT_EXPORT_VIEW_PROPERTY(activeColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(inactiveColor, UIColor)
RCT_EXPORT_VIEW_PROPERTY(leftKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(minValue, double)
RCT_EXPORT_VIEW_PROPERTY(maxValue, double)
RCT_EXPORT_VIEW_PROPERTY(rightKnobValue, double)
RCT_EXPORT_VIEW_PROPERTY(step, NSInteger)
RCT_EXPORT_VIEW_PROPERTY(onSampleNativeSliderClassicViewBeginDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onSampleNativeSliderClassicViewEndDrag, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onSampleNativeSliderClassicViewValueChange, RCTDirectEventBlock)

#if RCT_NEW_ARCH_ENABLED
#else
RCT_EXPORT_METHOD(setLeftKnobValueProgrammatically:(nonnull NSNumber*) reactTag, value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        SampleNativeSliderClassicView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[SampleNativeSliderClassicView class]]) {
            return;
        }
        [view setLeftKnobValue:value];
    }];
}

RCT_EXPORT_METHOD(setRightKnobValueProgrammatically:(nonnull NSNumber*) reactTag, value:(NSInteger) value) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        SampleNativeSliderClassicView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[SampleNativeSliderClassicView class]]) {
            return;
        }
        [view setRightKnobValue:value];
    }];
}

- (void)sendOnSampleNativeSliderClassicViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_onSampleNativeSliderClassicViewValueChange) {
        _onSampleNativeSliderClassicViewValueChange(@{ @"leftKnobValue": @(minValue), @"rightKnobValue": @(maxValue) });
    }
}

- (void)sendOnSampleNativeSliderClassicViewBeginDragEvent
{
    if (_onSampleNativeSliderClassicViewBeginDrag) {
        _onSampleNativeSliderClassicViewBeginDrag(nil);
    }
}

- (void)sendOnSampleNativeSliderClassicViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_onSampleNativeSliderClassicViewEndDrag) {
        _onSampleNativeSliderClassicViewEndDrag(@{ @"leftKnobValue": minValue, @"rightKnobValue": maxValue });
    }
}

- (UIView *)view
{
    SampleNativeSliderClassicView *view = [SampleNativeSliderClassicView new];
    view.delegate = self;
    return view;
}
#endif

@end
