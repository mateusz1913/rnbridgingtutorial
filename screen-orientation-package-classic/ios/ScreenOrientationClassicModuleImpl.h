#import <Foundation/Foundation.h>

typedef NS_ENUM(NSUInteger, ScreenOrientationClassicModuleEvent) {
  OnScreenOrientationClassicModuleChange,
};

extern NSString * _Nonnull ScreenOrientationClassicModuleEventName(ScreenOrientationClassicModuleEvent event);

@protocol ScreenOrientationClassicModuleDelegate

- (void)sendEventWithName:(NSString * _Nonnull)eventName
                  payload:(NSDictionary<NSString *, id> * _Nonnull)payload;

@end

@interface ScreenOrientationClassicModuleImpl : NSObject

@property (nonatomic, weak) id <ScreenOrientationClassicModuleDelegate> _Nullable delegate;

@end

@interface ScreenOrientationClassicModuleImpl ()

+ (NSArray<NSString *> * _Nonnull)supportedEvents;

@end
