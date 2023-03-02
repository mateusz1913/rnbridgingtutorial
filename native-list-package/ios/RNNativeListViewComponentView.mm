#if RCT_NEW_ARCH_ENABLED
#import "RNNativeListViewComponentView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/NativeListPackage/ComponentDescriptors.h>
#import <react/renderer/components/NativeListPackage/EventEmitters.h>
#import <react/renderer/components/NativeListPackage/Props.h>
#import <react/renderer/components/NativeListPackage/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

#import "NativeListPackage-Swift.h"

using namespace facebook::react;

@interface RNNativeListViewComponentView () <RCTRNNativeListViewViewProtocol>
@end

@implementation RNNativeListViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RNNativeListViewProps>();
        _props = defaultProps;

        RNNativeListViewContainerView *view = [RNNativeListViewContainerView new];
        view.viewController = [RNNativeListViewViewController new];

        self.contentView = view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const RNNativeListViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const RNNativeListViewProps>(props);

    RNNativeListViewContainerView *view = (RNNativeListViewContainerView *)self.contentView;

    auto dataComparator = [](const RNNativeListViewDataStruct &left, const RNNativeListViewDataStruct &right) {
        return left.imageUrl == right.imageUrl && left.description == right.description;
    };
    
    if (!std::equal(oldViewProps.data.begin(), oldViewProps.data.end(), newViewProps.data.begin(), newViewProps.data.end(), dataComparator)) {
        NSArray *data = RCTConvertVecToArray(newViewProps.data, ^(RNNativeListViewDataStruct item){
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
    RCTRNNativeListViewHandleCommand(self, commandName, args);
}

- (void)scrollToItem:(NSInteger)index
{
    RNNativeListViewContainerView *view = (RNNativeListViewContainerView *)self.contentView;
    [view.viewController scrollToItem:index];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RNNativeListViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> RNNativeListViewCls(void)
{
    return RNNativeListViewComponentView.class;
}
#endif
