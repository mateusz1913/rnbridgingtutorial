#import "SampleScreenOrientationClassicModuleImpl.h"

NSString *SampleScreenOrientationClassicModuleEventName(SampleScreenOrientationClassicModuleEvent event)
{
  switch (event) {
    case OnSampleScreenOrientationClassicModuleChange:
      return @"onSampleScreenOrientationClassicModuleChange";
  }
}

/**
 * Native module's shared implementation
 */
@implementation SampleScreenOrientationClassicModuleImpl {
    NSString *lastOrientation;
}

- (instancetype)init
{
    self = [super init];
    if (self) {
        lastOrientation = @"unknown";
        [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(handleOrientationChange:) name:UIDeviceOrientationDidChangeNotification object:[UIDevice currentDevice]];
        dispatch_async(dispatch_get_main_queue(), ^{
            [[UIDevice currentDevice] beginGeneratingDeviceOrientationNotifications];
        });
    }
    return self;
}

- (void)dealloc
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [[UIDevice currentDevice] endGeneratingDeviceOrientationNotifications];
    });
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}

/**
 * Example usage:
 *
 * ```objc
 * [self sendEvent:<%- moduleName %>EventName(On<%- moduleName %>Change) payload:@{ @"value" : result }];
 * ````
 */
- (void)sendEvent:(NSString *)name payload:(NSDictionary<NSString *, id> *)payload {
    [self.delegate sendEventWithName:name payload:payload];
}

+ (NSArray<NSString *> *)supportedEvents
{
    return @[SampleScreenOrientationClassicModuleEventName(OnSampleScreenOrientationClassicModuleChange)];
}

- (void)handleOrientationChange:(NSNotification *)notification
{
    UIDeviceOrientation currentOrientation = [[UIDevice currentDevice] orientation];
    
    NSString *orientation = @"unknown";
    if (currentOrientation == UIDeviceOrientationPortrait || currentOrientation == UIDeviceOrientationPortraitUpsideDown) {
        orientation = @"portrait";
    } else if (currentOrientation == UIDeviceOrientationLandscapeLeft || currentOrientation == UIDeviceOrientationLandscapeRight) {
        orientation = @"landscape";
    }
    
    if (lastOrientation == orientation) {
        return;
    }
    lastOrientation = orientation;
    
    [self sendEvent:SampleScreenOrientationClassicModuleEventName(OnSampleScreenOrientationClassicModuleChange)
            payload:@{@"orientation": orientation}];
}

@end
