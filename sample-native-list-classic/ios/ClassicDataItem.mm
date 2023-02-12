#import "ClassicDataItem.h"

@implementation ClassicDataItem

- (instancetype)initWithImageUrl:(NSString *)imageUrl itemDescription:(NSString *)itemDescription
{
    self = [super init];
    if (self) {
        _imageUrl = imageUrl;
        _itemDescription = itemDescription;
    }
    return self;
}

@end
