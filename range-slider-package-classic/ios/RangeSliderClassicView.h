#import <UIKit/UIKit.h>

/**
 * When using Swift classes in ObjC header, the class must have its
 * "forward declaration"
 * 
 * @see https://developer.apple.com/documentation/swift/importing-swift-into-objective-c#Include-Swift-Classes-in-Objective-C-Headers-Using-Forward-Declarations
 */
@class RangeUISliderWrapper;
@protocol RangeUISliderWrapperDelegate;

@protocol RangeSliderClassicViewDelegate

- (void)sendOnRangeSliderClassicViewBeginDragEvent;
- (void)sendOnRangeSliderClassicViewEndDragEventWithMinValue:(double)minValue
                                                    maxValue:(double)maxValue;
- (void)sendOnRangeSliderClassicViewValueChangeEventWithMinValue:(double)minValue
                                                        maxValue:(double)maxValue;

@end

@interface RangeSliderClassicView : UIView

@property (nonatomic, weak) id <RangeSliderClassicViewDelegate> _Nullable delegate;

@property (nonatomic, strong) UIColor * _Nonnull activeColor;
@property (nonatomic, strong) UIColor * _Nonnull inactiveColor;
@property (nonatomic) double minValue;
@property (nonatomic) double maxValue;
@property (nonatomic) double leftKnobValue;
@property (nonatomic) double rightKnobValue;
@property (nonatomic) NSInteger step;

@end
