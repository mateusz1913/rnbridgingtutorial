#import <Foundation/Foundation.h>

/**
 * When using Swift classes in ObjC header, the class must have its
 * "forward declaration"
 * 
 * @see https://developer.apple.com/documentation/swift/importing-swift-into-objective-c#Include-Swift-Classes-in-Objective-C-Headers-Using-Forward-Declarations
 */
@class FastisWrapper;

@protocol RangeDatePickerClassicModuleDelegate

- (void)onCancel;
- (void)onError:(NSError *)error;
- (void)onResult:(NSDictionary<NSString *, NSDictionary<NSString *, NSNumber *> *> *)resultDictionary;

@end

@interface RangeDatePickerClassicModuleImpl : NSObject

@property (nonatomic, weak) id <RangeDatePickerClassicModuleDelegate> _Nullable delegate;

- (void)showRangeDatePickerWithTitle:(NSString *)title;

@end
