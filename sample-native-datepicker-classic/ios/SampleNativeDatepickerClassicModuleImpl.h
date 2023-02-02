#import <Foundation/Foundation.h>

@class FastisWrapper;

@protocol SampleNativeDatepickerClassicModuleDelegate

- (void)onCancel;
- (void)onError:(NSError *)error;
- (void)onResult:(NSDictionary<NSString *, NSDictionary<NSString *, NSNumber *> *> *)resultDictionary;

@end

@interface SampleNativeDatepickerClassicModuleImpl : NSObject

@property (nonatomic, weak) id <SampleNativeDatepickerClassicModuleDelegate> _Nullable delegate;

- (void)showRangeDatepickerWithTitle:(NSString *)title;

@end
