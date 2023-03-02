#import <UIKit/UIKit.h>

@protocol SaveFilePickerClassicModuleDelegate

- (void)onCancel;
- (void)onError:(NSError *)error;
- (void)onSuccess;

@end

@interface SaveFilePickerClassicModuleImpl : NSObject

@property (nonatomic, weak) id<SaveFilePickerClassicModuleDelegate> delegate;

- (void)saveFileWithFilename:(NSString *)filename;

@end
