#import <React/RCTBridgeModule.h>

/**
 * When using Swift classes in ObjC header, the class must have its
 * "forward declaration"
 * 
 * @see https://developer.apple.com/documentation/swift/importing-swift-into-objective-c#Include-Swift-Classes-in-Objective-C-Headers-Using-Forward-Declarations
 */
@class SampleAppInfoModuleImpl;

/**
 * Declare the ObjC interface for that native module class.
 * 
 * It must extend NSObject (like every class in ObjC) and
 * implement RCTBridgeModule (like each RN native module).
 */
@interface SampleAppInfoModule : NSObject<RCTBridgeModule>

@end
