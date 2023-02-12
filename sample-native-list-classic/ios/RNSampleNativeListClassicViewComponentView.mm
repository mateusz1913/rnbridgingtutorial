#if RCT_NEW_ARCH_ENABLED
#import "RNSampleNativeListClassicViewComponentView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/SampleNativeListClassic/ComponentDescriptors.h>
#import <react/renderer/components/SampleNativeListClassic/EventEmitters.h>
#import <react/renderer/components/SampleNativeListClassic/Props.h>
#import <react/renderer/components/SampleNativeListClassic/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "RNSampleNativeListClassicViewContainerView.h"
#import "RNSampleNativeListClassicViewViewController.h"

using namespace facebook::react;

@interface RNSampleNativeListClassicViewComponentView () <RCTRNSampleNativeListClassicViewViewProtocol>
@end

@implementation RNSampleNativeListClassicViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RNSampleNativeListClassicViewProps>();
        _props = defaultProps;

        RNSampleNativeListClassicViewContainerView *view = [RNSampleNativeListClassicViewContainerView new];
        view.viewController = [RNSampleNativeListClassicViewViewController new];

        self.contentView = view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const RNSampleNativeListClassicViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const RNSampleNativeListClassicViewProps>(props);

    RNSampleNativeListClassicViewContainerView *view = (RNSampleNativeListClassicViewContainerView *)self.contentView;

    auto dataComparator = [](const RNSampleNativeListClassicViewDataStruct &left, const RNSampleNativeListClassicViewDataStruct &right) {
        return left.imageUrl == right.imageUrl && left.description == right.description;
    };

    if (!std::equal(oldViewProps.data.begin(), oldViewProps.data.end(), newViewProps.data.begin(), newViewProps.data.end(), dataComparator)) {
        NSArray *data = RCTConvertVecToArray(newViewProps.data, ^(RNSampleNativeListClassicViewDataStruct item){
            ClassicDataItem *dataItem = [[ClassicDataItem alloc] initWithImageUrl:RCTNSStringFromString(item.imageUrl) itemDescription:RCTNSStringFromString(item.description)];
            return dataItem;
        });
        [view.viewController setData:data];
    }

    if (oldViewProps.options.placeholderImage != newViewProps.options.placeholderImage) {
        [view.viewController setPlaceholderImage:RCTNSStringFromString(newViewProps.options.placeholderImage)];
    }

    if (oldViewProps.backgroundColor != newViewProps.backgroundColor) {
        UIColor *backgroundColor = RCTUIColorFromSharedColor(newViewProps.backgroundColor);
        [view.viewController setBackgroundColor:backgroundColor];
    }

    [super updateProps:props oldProps:oldProps];
}

- (void)handleCommand:(const NSString *)commandName args:(const NSArray *)args
{
    RCTRNSampleNativeListClassicViewHandleCommand(self, commandName, args);
}

- (void)scrollToItem:(NSInteger)index
{
    RNSampleNativeListClassicViewContainerView *view = (RNSampleNativeListClassicViewContainerView *)self.contentView;
    [view.viewController scrollToItem:index];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RNSampleNativeListClassicViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> RNSampleNativeListClassicViewCls(void)
{
    return RNSampleNativeListClassicViewComponentView.class;
}
#endif
