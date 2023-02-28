#if RCT_NEW_ARCH_ENABLED
#import "RangeSliderClassicViewComponentView.h"

#import <React/RCTConversions.h>

#import <react/renderer/components/RangeSliderPackageClassic/ComponentDescriptors.h>
#import <react/renderer/components/RangeSliderPackageClassic/EventEmitters.h>
#import <react/renderer/components/RangeSliderPackageClassic/Props.h>
#import <react/renderer/components/RangeSliderPackageClassic/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "RangeSliderClassicView.h"

using namespace facebook::react;

@interface RangeSliderClassicViewComponentView () <RCTRangeSliderClassicViewViewProtocol>
@end

@interface RangeSliderClassicViewComponentView () <RangeSliderClassicViewDelegate>
@end

@implementation RangeSliderClassicViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RangeSliderClassicViewProps>();
        _props = defaultProps;

        RangeSliderClassicView *view = [RangeSliderClassicView new];
        view.delegate = self;

        self.contentView = (UIView *)view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const RangeSliderClassicViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const RangeSliderClassicViewProps>(props);

    RangeSliderClassicView *view = (RangeSliderClassicView *)self.contentView;

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

- (void)sendOnRangeSliderClassicViewValueChangeEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const RangeSliderClassicViewEventEmitter>(_eventEmitter)
            ->onRangeSliderClassicViewValueChange(
                RangeSliderClassicViewEventEmitter::OnRangeSliderClassicViewValueChange{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)sendOnRangeSliderClassicViewBeginDragEvent
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const RangeSliderClassicViewEventEmitter>(_eventEmitter)
            ->onRangeSliderClassicViewBeginDrag(
                RangeSliderClassicViewEventEmitter::OnRangeSliderClassicViewBeginDrag{});
    }
}

- (void)sendOnRangeSliderClassicViewEndDragEventWithMinValue:(double)minValue maxValue:(double)maxValue
{
    if (_eventEmitter != nil) {
        std::dynamic_pointer_cast<const RangeSliderClassicViewEventEmitter>(_eventEmitter)
            ->onRangeSliderClassicViewEndDrag(
                RangeSliderClassicViewEventEmitter::OnRangeSliderClassicViewEndDrag{
                    .leftKnobValue = minValue,
                    .rightKnobValue = maxValue
                });
    }
}

- (void)handleCommand:(const NSString *)commandName args:(const NSArray *)args
{
    RCTRangeSliderClassicViewHandleCommand(self, commandName, args);
}

- (void)setLeftKnobValueProgrammatically:(double)value
{
    RangeSliderClassicView *view = (RangeSliderClassicView *)self.contentView;
    [view setLeftKnobValue:value];
}

- (void)setRightKnobValueProgrammatically:(double)value
{
    RangeSliderClassicView *view = (RangeSliderClassicView *)self.contentView;
    [view setRightKnobValue:value];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RangeSliderClassicViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> RangeSliderClassicViewCls(void)
{
    return RangeSliderClassicViewComponentView.class;
}
#endif
