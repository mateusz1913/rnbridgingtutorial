#import <Foundation/Foundation.h>

@interface ClassicDataItem : NSObject

@property (nonatomic, copy) NSString * _Nonnull imageUrl;
@property (nonatomic, copy) NSString * _Nonnull itemDescription;

- (instancetype)initWithImageUrl:(NSString * _Nonnull)imageUrl itemDescription:(NSString * _Nonnull)itemDescription;

@end
