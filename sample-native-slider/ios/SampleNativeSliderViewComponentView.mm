#if RCT_NEW_ARCH_ENABLED
#import "SampleNativeSliderViewComponentView.h"

#import <React/RCTConversions.h>

#import <react/renderer/components/SampleNativeSlider/ComponentDescriptors.h>
#import <react/renderer/components/SampleNativeSlider/EventEmitters.h>
#import <react/renderer/components/SampleNativeSlider/Props.h>
#import <react/renderer/components/SampleNativeSlider/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "SampleNativeSlider-Swift.h"

using namespace facebook::react;

@interface SampleNativeSliderViewComponentView () <RCTSampleNativeSliderViewViewProtocol>
@end

@interface SampleNativeSliderViewComponentView () <SampleNativeSliderViewDelegate>
@end

@implementation SampleNativeSliderViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const SampleNativeSliderViewProps>();
        _props = defaultProps;

        SampleNativeSliderView *view = [SampleNativeSliderView new];
        view.delegate = self;

        self.contentView = (UIView *)view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const SampleNativeSliderViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const SampleNativeSliderViewProps>(props);

    SampleNativeSliderView *view = (SampleNativeSliderView *)self.contentView;

    if (oldViewProps.activeColor != newViewProps.activeColor) {
        [view setActiveColor:RCTUIColorFromSharedColor(newViewProps.activeColor)];
    }
    
    if (oldViewProps.inactiveColor != newViewProps.inactiveColor) {
        [view setInactiveColor:RCTUIColorFromSharedColor(newViewProps.inactiveColor)];
    }

    if (oldViewProps.step != newViewProps.step) {
        [view setStep:newViewProps.step];
    }
    
    if (oldViewProps.minValue != newViewProps.minValue) {
        [view setMinValue:newViewProps.minValue];
    }
    
    if (oldViewProps.maxValue != newViewProps.maxValue) {
        [view setMaxValue:newViewProps.maxValue];
    }
    
    if (oldViewProps.leftKnobValue != newViewProps.leftKnobValue) {
        [view setLeftKnobValue:newViewProps.leftKnobValue];
    }
    
    if (oldViewProps.rightKnobValue != newViewProps.rightKnobValue) {
        [view setRightKnobValue:newViewProps.rightKnobValue];
    }

    [super updateProps:props oldProps:oldProps];
}

- (void)mountChildComponentView:(UIView<RCTComponentViewProtocol> *)childComponentView index:(NSInteger)index
{
    // That component does not accept child views
}

- (void)unmountChildComponentView:(UIView<RCTComponentViewProtocol> *)childComponentView index:(NSInteger)index
{
    // That component does not accept child views
}

- (void)sendOnSampleNativeSliderViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const SampleNativeSliderViewEventEmitter>(_eventEmitter)
            ->onSampleNativeSliderViewValueChange(
                SampleNativeSliderViewEventEmitter::OnSampleNativeSliderViewValueChange{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)sendOnSampleNativeSliderViewBeginDragEvent
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const SampleNativeSliderViewEventEmitter>(_eventEmitter)
            ->onSampleNativeSliderViewBeginDrag(
                SampleNativeSliderViewEventEmitter::OnSampleNativeSliderViewBeginDrag{});
    }
}

- (void)sendOnSampleNativeSliderViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const SampleNativeSliderViewEventEmitter>(_eventEmitter)
            ->onSampleNativeSliderViewEndDrag(
                SampleNativeSliderViewEventEmitter::OnSampleNativeSliderViewEndDrag{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)handleCommand:(const NSString *)commandName args:(const NSArray *)args
{
    RCTSampleNativeSliderViewHandleCommand(self, commandName, args);
}

- (void)setLeftKnobValueProgrammatically:(double)value
{
    SampleNativeSliderView *view = (SampleNativeSliderView *)self.contentView;
    [view setLeftKnobValue:value];
}

- (void)setRightKnobValueProgrammatically:(double)value
{
    SampleNativeSliderView *view = (SampleNativeSliderView *)self.contentView;
    [view setRightKnobValue:value];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<SampleNativeSliderViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> SampleNativeSliderViewCls(void)
{
    return SampleNativeSliderViewComponentView.class;
}
#endif
