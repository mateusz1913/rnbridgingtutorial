#import "NativeListClassicCell.h"

@implementation NativeListClassicCell {
    UIStackView *container;
    UIImageView *imageView;
    UILabel *label;
}

- (instancetype)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:CGRectMake(0, 0, 100, 100)];
    if (self) {
        container = [UIStackView new];
        imageView = [UIImageView new];
        label = [UILabel new];
    }
    return self;
}

- (void)prepareForReuse
{
    [super prepareForReuse];
    [container removeArrangedSubview:imageView];
    [container removeArrangedSubview:label];
    [container removeFromSuperview];
    imageView.image = nil;
}

- (void)setupCellWithItem:(ClassicDataItem *)item placeholderImage:(NSString *)placeholderImage
{
    [label setText:item.itemDescription];
    [label setFont:[UIFont systemFontOfSize:10]];
    [label setTextAlignment:NSTextAlignmentCenter];

    imageView.image = [UIImage systemImageNamed:placeholderImage];

    [container setAxis:UILayoutConstraintAxisVertical];
    [container setSpacing:10];
    [container addArrangedSubview:imageView];
    [container addArrangedSubview:label];
    [self addSubview:container];

    label.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
        [label.centerXAnchor constraintEqualToAnchor:container.centerXAnchor],
        [label.widthAnchor constraintEqualToConstant:100],
        [label.heightAnchor constraintEqualToConstant:20]
    ]];

    imageView.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
        [imageView.widthAnchor constraintEqualToConstant:100],
        [imageView.heightAnchor constraintEqualToConstant:70]
    ]];

    container.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
        [container.centerXAnchor constraintEqualToAnchor:self.centerXAnchor],
        [container.centerYAnchor constraintEqualToAnchor:self.centerYAnchor],
        [container.widthAnchor constraintEqualToConstant:100],
        [container.heightAnchor constraintEqualToConstant:100]
    ]];

    [self setBackgroundColor:[[UIColor alloc] initWithRed:137.0 / 255 green: 204.0 / 255 blue:101.0 / 255 alpha:1]];
    self.layer.borderColor = UIColor.blueColor.CGColor;
    self.layer.borderWidth = 1;
    self.layer.cornerRadius = 10;
    self.layer.masksToBounds = YES;
    self.layer.shadowColor = UIColor.blackColor.CGColor;
    self.layer.shadowOffset = CGSizeMake(0, 5);
    self.layer.shadowOpacity = 0.34;
    self.layer.shadowRadius = 6.27;
    self.clipsToBounds = YES;

    [imageView layoutIfNeeded];
    [self layoutIfNeeded];
}

@end
