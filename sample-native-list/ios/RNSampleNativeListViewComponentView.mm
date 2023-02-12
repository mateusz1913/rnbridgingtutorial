#if RCT_NEW_ARCH_ENABLED
#import "RNSampleNativeListViewComponentView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/SampleNativeList/ComponentDescriptors.h>
#import <react/renderer/components/SampleNativeList/EventEmitters.h>
#import <react/renderer/components/SampleNativeList/Props.h>
#import <react/renderer/components/SampleNativeList/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "SampleNativeList-Swift.h"

using namespace facebook::react;

@interface RNSampleNativeListViewComponentView () <RCTRNSampleNativeListViewViewProtocol>
@end

@implementation RNSampleNativeListViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RNSampleNativeListViewProps>();
        _props = defaultProps;

        RNSampleNativeListViewContainerView *view = [RNSampleNativeListViewContainerView new];
        view.viewController = [RNSampleNativeListViewViewController new];

        self.contentView = view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const RNSampleNativeListViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const RNSampleNativeListViewProps>(props);

    RNSampleNativeListViewContainerView *view = (RNSampleNativeListViewContainerView *)self.contentView;

    auto dataComparator = [](const RNSampleNativeListViewDataStruct &left, const RNSampleNativeListViewDataStruct &right) {
        return left.imageUrl == right.imageUrl && left.description == right.description;
    };
    
    if (!std::equal(oldViewProps.data.begin(), oldViewProps.data.end(), newViewProps.data.begin(), newViewProps.data.end(), dataComparator)) {
        NSArray *data = RCTConvertVecToArray(newViewProps.data, ^(RNSampleNativeListViewDataStruct item){
            DataItem *dataItem = [[DataItem alloc] initWithImageUrl:RCTNSStringFromString(item.imageUrl) itemDescription:RCTNSStringFromString(item.description)];
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
    RCTRNSampleNativeListViewHandleCommand(self, commandName, args);
}

- (void)scrollToItem:(NSInteger)index
{
    RNSampleNativeListViewContainerView *view = (RNSampleNativeListViewContainerView *)self.contentView;
    [view.viewController scrollToItem:index];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RNSampleNativeListViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> RNSampleNativeListViewCls(void)
{
    return RNSampleNativeListViewComponentView.class;
}
#endif
