#if RCT_NEW_ARCH_ENABLED
#import "SampleConicGradientClassicViewComponentView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/SampleReactViewClassic/ComponentDescriptors.h>
#import <react/renderer/components/SampleReactViewClassic/EventEmitters.h>
#import <react/renderer/components/SampleReactViewClassic/Props.h>
#import <react/renderer/components/SampleReactViewClassic/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface SampleConicGradientClassicViewComponentView () <RCTSampleConicGradientClassicViewViewProtocol>
@end

@implementation SampleConicGradientClassicViewComponentView {
    NSArray<UIColor *> *colors;
    NSArray<NSNumber *> *locations;
    CGPoint centerPoint;
}

@dynamic layer;

+ (Class)layerClass
{
    return [CAGradientLayer classForCoder];
}

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const SampleConicGradientClassicViewProps>();
        _props = defaultProps;
        
        colors = @[];
        locations = @[];
        centerPoint = CGPointMake(0.5, 0.5);
        
        self.layer.type = kCAGradientLayerConic;
        self.layer.needsDisplayOnBoundsChange = YES;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const SampleConicGradientClassicViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const SampleConicGradientClassicViewProps>(props);

    if (oldViewProps.colors != newViewProps.colors) {
        auto colors = RCTConvertVecToArray(newViewProps.colors, ^id(SharedColor item){
            return (id)RCTUIColorFromSharedColor(item).CGColor;
        });
        self.layer.colors = colors;
    }

    if (oldViewProps.locations != newViewProps.locations) {
        auto locations = RCTConvertVecToArray(newViewProps.locations, ^id(double item){
            return @(item);
        });
        self.layer.locations = locations;
    }

    if (oldViewProps.centerPoint.x != newViewProps.centerPoint.x || oldViewProps.centerPoint.y != newViewProps.centerPoint.y) {
        auto centerPoint = CGPointMake(newViewProps.centerPoint.x, newViewProps.centerPoint.y);
        self.layer.startPoint = centerPoint;
        self.layer.endPoint = CGPointMake(1, centerPoint.y);
    }

    [super updateProps:props oldProps:oldProps];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<SampleConicGradientClassicViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> SampleConicGradientClassicViewCls(void)
{
    return SampleConicGradientClassicViewComponentView.class;
}
#endif
