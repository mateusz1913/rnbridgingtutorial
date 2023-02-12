#import <UIKit/UIKit.h>
#import <RNSampleNativeListClassicViewViewController.h>

@interface NativeListClassicCell : UICollectionViewCell

- (void)setupCellWithItem:(ClassicDataItem *)item placeholderImage:(NSString *)placeholderImage;

@end
