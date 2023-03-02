#if RCT_NEW_ARCH_ENABLED
#import "RNNativeListClassicViewComponentView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/NativeListPackageClassic/ComponentDescriptors.h>
#import <react/renderer/components/NativeListPackageClassic/EventEmitters.h>
#import <react/renderer/components/NativeListPackageClassic/Props.h>
#import <react/renderer/components/NativeListPackageClassic/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "RNNativeListClassicViewContainerView.h"
#import "RNNativeListClassicViewViewController.h"

using namespace facebook::react;

@interface RNNativeListClassicViewComponentView () <RCTRNNativeListClassicViewViewProtocol>
@end

@implementation RNNativeListClassicViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RNNativeListClassicViewProps>();
        _props = defaultProps;

        RNNativeListClassicViewContainerView *view = [RNNativeListClassicViewContainerView new];
        view.viewController = [RNNativeListClassicViewViewController new];

        self.contentView = view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const RNNativeListClassicViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const RNNativeListClassicViewProps>(props);

    RNNativeListClassicViewContainerView *view = (RNNativeListClassicViewContainerView *)self.contentView;

    auto dataComparator = [](const RNNativeListClassicViewDataStruct &left, const RNNativeListClassicViewDataStruct &right) {
        return left.imageUrl == right.imageUrl && left.description == right.description;
    };

    if (!std::equal(oldViewProps.data.begin(), oldViewProps.data.end(), newViewProps.data.begin(), newViewProps.data.end(), dataComparator)) {
        NSArray *data = RCTConvertVecToArray(newViewProps.data, ^(RNNativeListClassicViewDataStruct item){
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
    RCTRNNativeListClassicViewHandleCommand(self, commandName, args);
}

- (void)scrollToItem:(NSInteger)index
{
    RNNativeListClassicViewContainerView *view = (RNNativeListClassicViewContainerView *)self.contentView;
    [view.viewController scrollToItem:index];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RNNativeListClassicViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> RNNativeListClassicViewCls(void)
{
    return RNNativeListClassicViewComponentView.class;
}
#endif
