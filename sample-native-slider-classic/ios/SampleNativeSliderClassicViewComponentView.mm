#if RCT_NEW_ARCH_ENABLED
#import "SampleNativeSliderClassicViewComponentView.h"

#import <React/RCTConversions.h>

#import <react/renderer/components/SampleNativeSliderClassic/ComponentDescriptors.h>
#import <react/renderer/components/SampleNativeSliderClassic/EventEmitters.h>
#import <react/renderer/components/SampleNativeSliderClassic/Props.h>
#import <react/renderer/components/SampleNativeSliderClassic/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "SampleNativeSliderClassicView.h"

using namespace facebook::react;

@interface SampleNativeSliderClassicViewComponentView () <RCTSampleNativeSliderClassicViewViewProtocol>
@end

@interface SampleNativeSliderClassicViewComponentView () <SampleNativeSliderClassicViewDelegate>
@end

@implementation SampleNativeSliderClassicViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const SampleNativeSliderClassicViewProps>();
        _props = defaultProps;

        SampleNativeSliderClassicView *view = [SampleNativeSliderClassicView new];
        view.delegate = self;

        self.contentView = (UIView *)view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const SampleNativeSliderClassicViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const SampleNativeSliderClassicViewProps>(props);

    SampleNativeSliderClassicView *view = (SampleNativeSliderClassicView *)self.contentView;

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

- (void)sendOnSampleNativeSliderClassicViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const SampleNativeSliderClassicViewEventEmitter>(_eventEmitter)
            ->onSampleNativeSliderClassicViewValueChange(
                SampleNativeSliderClassicViewEventEmitter::OnSampleNativeSliderClassicViewValueChange{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)sendOnSampleNativeSliderClassicViewBeginDragEvent
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const SampleNativeSliderClassicViewEventEmitter>(_eventEmitter)
            ->onSampleNativeSliderClassicViewBeginDrag(
                SampleNativeSliderClassicViewEventEmitter::OnSampleNativeSliderClassicViewBeginDrag{});
    }
}

- (void)sendOnSampleNativeSliderClassicViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const SampleNativeSliderClassicViewEventEmitter>(_eventEmitter)
            ->onSampleNativeSliderClassicViewEndDrag(
                SampleNativeSliderClassicViewEventEmitter::OnSampleNativeSliderClassicViewEndDrag{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)handleCommand:(const NSString *)commandName args:(const NSArray *)args
{
    RCTSampleNativeSliderClassicViewHandleCommand(self, commandName, args);
}

- (void)setLeftKnobValueProgrammatically:(double)value
{
    SampleNativeSliderClassicView *view = (SampleNativeSliderClassicView *)self.contentView;
    [view setLeftKnobValue:value];
}

- (void)setRightKnobValueProgrammatically:(double)value
{
    SampleNativeSliderClassicView *view = (SampleNativeSliderClassicView *)self.contentView;
    [view setRightKnobValue:value];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<SampleNativeSliderClassicViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> SampleNativeSliderClassicViewCls(void)
{
    return SampleNativeSliderClassicViewComponentView.class;
}
#endif
