#import <UIKit/UIKit.h>

#import "ClassicDataItem.h"

@interface RNSampleNativeListClassicViewViewController : UIViewController

@property (nonatomic, copy) NSArray<ClassicDataItem *> * _Nonnull data;
@property (nonatomic, copy) NSString * _Nonnull placeholderImage;
@property (nonatomic, strong) UIColor * _Nullable backgroundColor;

- (void)scrollToItem:(NSInteger)index;

@end
