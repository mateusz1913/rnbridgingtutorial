#import <UIKit/UIKit.h>
#import <RNNativeListClassicViewViewController.h>

@interface NativeListClassicCell : UICollectionViewCell

- (void)setupCellWithItem:(ClassicDataItem *)item placeholderImage:(NSString *)placeholderImage;

@end
