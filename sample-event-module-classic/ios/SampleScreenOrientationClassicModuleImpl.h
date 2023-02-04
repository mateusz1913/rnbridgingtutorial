#import <Foundation/Foundation.h>

typedef NS_ENUM(NSUInteger, SampleScreenOrientationClassicModuleEvent) {
  OnSampleScreenOrientationClassicModuleChange,
};

extern NSString * _Nonnull SampleScreenOrientationClassicModuleEventName(SampleScreenOrientationClassicModuleEvent event);

@protocol SampleScreenOrientationClassicModuleDelegate

- (void)sendEventWithName:(NSString * _Nonnull)eventName
                  payload:(NSDictionary<NSString *, id> * _Nonnull)payload;

@end

@interface SampleScreenOrientationClassicModuleImpl : NSObject

@property (nonatomic, weak) id <SampleScreenOrientationClassicModuleDelegate> _Nullable delegate;

@end

@interface SampleScreenOrientationClassicModuleImpl ()

+ (NSArray<NSString *> * _Nonnull)supportedEvents;

@end
