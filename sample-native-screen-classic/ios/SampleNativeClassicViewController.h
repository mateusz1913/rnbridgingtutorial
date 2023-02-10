#import <UIKit/UIKit.h>

@protocol SampleNativeClassicViewControllerDelegate

- (void)onSubmit:(NSString *)text;
- (void)onCancel;

@end

@interface SampleNativeClassicViewController : UIViewController

@property (nonatomic, weak) id <SampleNativeClassicViewControllerDelegate> _Nullable delegate;

@property (nonatomic, copy) NSString *headerText;

@end
