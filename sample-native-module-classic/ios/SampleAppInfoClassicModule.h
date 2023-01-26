#import <React/RCTBridgeModule.h>

/**
 * Declare the ObjC interface for that native module class.
 * 
 * It must extend NSObject (like every class in ObjC) and
 * implement RCTBridgeModule (like each RN native module).
 * 
 * If the module emits events, it must extend RCTEventEmitter class.
 */
@interface SampleAppInfoClassicModule : NSObject<RCTBridgeModule>

@end
