#if RCT_NEW_ARCH_ENABLED
#import "RangeSliderViewComponentView.h"

#import <React/RCTConversions.h>

#import <react/renderer/components/RangeSliderPackage/ComponentDescriptors.h>
#import <react/renderer/components/RangeSliderPackage/EventEmitters.h>
#import <react/renderer/components/RangeSliderPackage/Props.h>
#import <react/renderer/components/RangeSliderPackage/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "RangeSliderPackage-Swift.h"

using namespace facebook::react;

@interface RangeSliderViewComponentView () <RCTRangeSliderViewViewProtocol>
@end

@interface RangeSliderViewComponentView () <RangeSliderViewDelegate>
@end

@implementation RangeSliderViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RangeSliderViewProps>();
        _props = defaultProps;

        RangeSliderView *view = [RangeSliderView new];
        view.delegate = self;

        self.contentView = (UIView *)view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const RangeSliderViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const RangeSliderViewProps>(props);

    RangeSliderView *view = (RangeSliderView *)self.contentView;

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

- (void)sendOnRangeSliderViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const RangeSliderViewEventEmitter>(_eventEmitter)
            ->onRangeSliderViewValueChange(
                RangeSliderViewEventEmitter::OnRangeSliderViewValueChange{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)sendOnRangeSliderViewBeginDragEvent
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const RangeSliderViewEventEmitter>(_eventEmitter)
            ->onRangeSliderViewBeginDrag(
                RangeSliderViewEventEmitter::OnRangeSliderViewBeginDrag{});
    }
}

- (void)sendOnRangeSliderViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const RangeSliderViewEventEmitter>(_eventEmitter)
            ->onRangeSliderViewEndDrag(
                RangeSliderViewEventEmitter::OnRangeSliderViewEndDrag{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)handleCommand:(const NSString *)commandName args:(const NSArray *)args
{
    RCTRangeSliderViewHandleCommand(self, commandName, args);
}

- (void)setLeftKnobValueProgrammatically:(double)value
{
    RangeSliderView *view = (RangeSliderView *)self.contentView;
    [view setLeftKnobValue:value];
}

- (void)setRightKnobValueProgrammatically:(double)value
{
    RangeSliderView *view = (RangeSliderView *)self.contentView;
    [view setRightKnobValue:value];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RangeSliderViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> RangeSliderViewCls(void)
{
    return RangeSliderViewComponentView.class;
}
#endif
