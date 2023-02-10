#import <UIKit/UIKit.h>

typedef NS_ENUM(NSUInteger, SampleNativeScreenClassicModuleEvent) {
    OnResultClassic,
};

extern NSString * _Nonnull SampleNativeScreenClassicModuleEventName(SampleNativeScreenClassicModuleEvent event);

@protocol SampleNativeScreenClassicModuleDelegate

- (void)sendEventWithName:(NSString * _Nonnull)eventName
                  payload:(NSDictionary<NSString *, id> * _Nonnull)payload;

@end

@interface SampleNativeScreenClassicModuleImpl : NSObject

@property (nonatomic, weak) id <SampleNativeScreenClassicModuleDelegate> _Nullable delegate;

- (void)launchNativeScreen:(NSString *_Nonnull)valueFromJS;

@end

@interface SampleNativeScreenClassicModuleImpl ()

+ (NSArray<NSString *> * _Nonnull)supportedEvents;

@end
