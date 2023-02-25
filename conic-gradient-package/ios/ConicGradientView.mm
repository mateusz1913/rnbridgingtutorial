#import "ConicGradientView.h"

@implementation ConicGradientView

@dynamic layer;

+ (Class)layerClass
{
    return [CAGradientLayer classForCoder];
}

- (instancetype)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        [self setup];
    }
    return self;
}

- (void)setup
{
    self.layer.type = kCAGradientLayerConic;
    self.layer.needsDisplayOnBoundsChange = YES;
}

- (void)setColors:(NSArray<UIColor *> *)colors
{
    _colors = colors;
    NSMutableArray *cgColors = [NSMutableArray arrayWithCapacity:colors.count];
    for (int i = 0; i < colors.count; i++) {
        cgColors[i] = (id)colors[i].CGColor;
    }
    self.layer.colors = cgColors;
}

- (void)setLocations:(NSArray<NSNumber *> *)locations
{
    _locations = locations;
    self.layer.locations = locations;
}

- (void)setCenterPoint:(CGPoint)centerPoint
{
    _centerPoint = centerPoint;
    self.layer.startPoint = centerPoint;
    self.layer.endPoint = CGPointMake(1, centerPoint.y);
}

@end
