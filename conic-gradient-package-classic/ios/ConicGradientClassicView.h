#import <UIKit/UIKit.h>
#import <QuartzCore/QuartzCore.h>
#import <React/RCTView.h>

@interface ConicGradientClassicView : RCTView

@property(nonatomic, readonly, strong) CAGradientLayer * _Nonnull layer;

@property (nonatomic, copy) NSArray<UIColor *> * _Nonnull colors;
@property (nonatomic, copy) NSArray<NSNumber *> * _Nonnull locations;
@property (nonatomic, assign) CGPoint centerPoint;

@end
