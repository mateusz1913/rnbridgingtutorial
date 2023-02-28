#import "RangeSliderClassicView.h"

#import "RangeSliderPackageClassic-Swift.h"

@implementation RangeSliderClassicView {
    RangeUISliderWrapper *swiftWrapper;
}

- (instancetype)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        swiftWrapper = [RangeUISliderWrapper new];
        [self addSubview:swiftWrapper.slider];
    }
    return self;
}

- (void)setDelegate:(id<RangeSliderClassicViewDelegate>)delegate
{
    _delegate = delegate;
    swiftWrapper.delegate = (id<RangeUISliderWrapperDelegate>) delegate;
}

- (void)setFrame:(CGRect)frame
{
    [super setFrame:frame];
    [swiftWrapper setSliderFrame:frame];
}

- (void)setActiveColor:(UIColor *)activeColor
{
    _activeColor = activeColor;
    [swiftWrapper setActiveColor:activeColor];
}

- (void)setInactiveColor:(UIColor *)inactiveColor
{
    _inactiveColor = inactiveColor;
    [swiftWrapper setInactiveColor:inactiveColor];
}

- (void)setMinValue:(double)minValue
{
    _minValue = minValue;
    [swiftWrapper setMinValue:minValue];
}

- (void)setMaxValue:(double)maxValue
{
    _maxValue = maxValue;
    [swiftWrapper setMaxValue:maxValue];
}

- (void)setLeftKnobValue:(double)leftKnobValue
{
    _leftKnobValue = leftKnobValue;
    [swiftWrapper setLeftKnobValue:leftKnobValue];
}

- (void)setRightKnobValue:(double)rightKnobValue
{
    _rightKnobValue = rightKnobValue;
    [swiftWrapper setRightKnobValue:rightKnobValue];
}

- (void)setStep:(NSInteger)step
{
    _step = step;
    [swiftWrapper setStep:step];
}

@end
