#import <UIKit/UIKit.h>

@class SliderSwiftWrapper;
@protocol SliderSwiftWrapperDelegate;

@protocol SampleNativeSliderClassicViewDelegate

- (void)sendOnSampleNativeSliderClassicViewBeginDragEvent;
- (void)sendOnSampleNativeSliderClassicViewEndDragEventWithMinValue:(double)minValue
                                                               maxValue:(double)maxValue;
- (void)sendOnSampleNativeSliderClassicViewValueChangeEventWithMinValue:(double)minValue
                                                               maxValue:(double)maxValue;

@end

@interface SampleNativeSliderClassicView : UIView

@property (nonatomic, weak) id <SampleNativeSliderClassicViewDelegate> _Nullable delegate;

@property (nonatomic, strong) UIColor * _Nonnull activeColor;
@property (nonatomic, strong) UIColor * _Nonnull inactiveColor;
@property (nonatomic) double minValue;
@property (nonatomic) double maxValue;
@property (nonatomic) double leftKnobValue;
@property (nonatomic) double rightKnobValue;
@property (nonatomic) NSInteger step;

@end
