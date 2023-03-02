#import "SaveFilePickerClassicModuleImpl.h"

#import <React/RCTUtils.h>

@interface SaveFilePickerClassicModuleImpl () <UIDocumentPickerDelegate>
@end

/**
 * Native module's shared implementation
 */
@implementation SaveFilePickerClassicModuleImpl

static NSString *INVALID_PATH_ERROR_MESSAGE = @"Invalid path";
static NSString *NO_VIEW_CONTROLLER_ERROR_MESSAGE = @"No viewcontroller";

- (void)saveFileWithFilename:(NSString *)filename
{
    NSArray<NSString *> *filenameComponents = [filename componentsSeparatedByString:@"."];
    NSURL *url = [[NSBundle mainBundle] URLForResource:filenameComponents[0] withExtension:filenameComponents[1]];
    if (url == nil) {
        [self.delegate onError:[NSError errorWithDomain:@"SaveFilePickerClassicModuleImpl"
                                                   code:1234
                                               userInfo:@{ NSLocalizedDescriptionKey: INVALID_PATH_ERROR_MESSAGE }]];
        return;
    }

    UIViewController *_Nullable presentedViewController = RCTPresentedViewController();
    if (presentedViewController == nil) {
        [self.delegate onError:[NSError errorWithDomain:@"SaveFilePickerClassicModuleImpl"
                                                   code:1234
                                               userInfo:@{ NSLocalizedDescriptionKey: NO_VIEW_CONTROLLER_ERROR_MESSAGE }]];
        return;
    }
    
    UIDocumentPickerViewController *documentPicker = [self createDocumentPickerWithUrl:url];
    documentPicker.delegate = self;
    [presentedViewController presentViewController:documentPicker animated:YES completion:nil];
}

- (void)documentPicker:(UIDocumentPickerViewController *)controller didPickDocumentsAtURLs:(NSArray<NSURL *> *)urls
{
    [self.delegate onSuccess];
    controller.delegate = nil;
}

- (void)documentPickerWasCancelled:(UIDocumentPickerViewController *)controller
{
    [self.delegate onCancel];
    controller.delegate = nil;
}

- (UIDocumentPickerViewController *)createDocumentPickerWithUrl:(NSURL *)url
{
    if (@available(iOS 14.0, *)) {
        return [[UIDocumentPickerViewController alloc] initForExportingURLs:@[url] asCopy:true];
    }
    return [[UIDocumentPickerViewController alloc] initWithURL:url inMode:UIDocumentPickerModeExportToService];
}

@end
