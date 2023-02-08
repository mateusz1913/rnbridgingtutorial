#import "SampleNativeSliderClassicView.h"

#import "SampleNativeSliderClassic-Swift.h"

@implementation SampleNativeSliderClassicView {
    SliderSwiftWrapper *swiftWrapper;
}

- (instancetype)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        swiftWrapper = [SliderSwiftWrapper new];
        [self addSubview:swiftWrapper.slider];
    }
    return self;
}

- (void)setDelegate:(id<SampleNativeSliderClassicViewDelegate>)delegate
{
    _delegate = delegate;
    swiftWrapper.delegate = (id<SliderSwiftWrapperDelegate>) delegate;
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
