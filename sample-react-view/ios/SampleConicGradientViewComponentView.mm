#if RCT_NEW_ARCH_ENABLED
#import "SampleConicGradientViewComponentView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/SampleReactView/ComponentDescriptors.h>
#import <react/renderer/components/SampleReactView/EventEmitters.h>
#import <react/renderer/components/SampleReactView/Props.h>
#import <react/renderer/components/SampleReactView/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "SampleConicGradientView.h"

using namespace facebook::react;

@interface SampleConicGradientViewComponentView () <RCTSampleConicGradientViewViewProtocol>
@end

@implementation SampleConicGradientViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const SampleConicGradientViewProps>();
        _props = defaultProps;

        SampleConicGradientView *view = [[SampleConicGradientView alloc] initWithFrame:CGRectZero];

        self.contentView = (UIView *)view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const SampleConicGradientViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const SampleConicGradientViewProps>(props);

    SampleConicGradientView *view = (SampleConicGradientView *)self.contentView;

    if (oldViewProps.colors != newViewProps.colors) {
        auto colors = RCTConvertVecToArray(newViewProps.colors, ^id(SharedColor item){
            return RCTUIColorFromSharedColor(item);
        });
        [view setColors:colors];
    }

    if (oldViewProps.locations != newViewProps.locations) {
        auto locations = RCTConvertVecToArray(newViewProps.locations, ^id(double item){
            return @(item);
        });
        [view setLocations:locations];
    }

    if (oldViewProps.centerPoint.x != newViewProps.centerPoint.x || oldViewProps.centerPoint.y != newViewProps.centerPoint.y) {
        [view setCenterPoint:CGPointMake(newViewProps.centerPoint.x, newViewProps.centerPoint.y)];
    }

    [super updateProps:props oldProps:oldProps];
}

- (void)mountChildComponentView:(UIView<RCTComponentViewProtocol> *)childComponentView index:(NSInteger)index
{
    // Forward child components to the content view
    [self.contentView insertSubview:childComponentView atIndex:index];
}

- (void)unmountChildComponentView:(UIView<RCTComponentViewProtocol> *)childComponentView index:(NSInteger)index
{
    [childComponentView removeFromSuperview];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<SampleConicGradientViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> SampleConicGradientViewCls(void)
{
    return SampleConicGradientViewComponentView.class;
}
#endif
