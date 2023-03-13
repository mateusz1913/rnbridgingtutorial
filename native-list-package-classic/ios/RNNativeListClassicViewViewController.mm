#import <UIKit/UIKit.h>

#import "RNNativeListClassicViewViewController.h"
#import "NativeListClassicCell.h"

@interface RNNativeListClassicViewViewController () <UICollectionViewDataSource>
@end

@implementation RNNativeListClassicViewViewController {
    NSInteger NUM_OF_COLUMNS;
    UICollectionView * _Nullable collectionView;
    UICollectionViewFlowLayout *layout;
}

+ (NSString *)cellIdentifier
{
    return @"MyCell";
}

- (instancetype)init
{
    self = [super initWithNibName:nil bundle:nil];
    if (self) {
        NUM_OF_COLUMNS = 3;
        layout = [UICollectionViewFlowLayout new];
        layout.sectionInset = UIEdgeInsetsMake(20, 10, 10, 10);
        layout.minimumLineSpacing = 10;
        layout.minimumInteritemSpacing = 10;
    }
    return self;
}

- (void)viewWillLayoutSubviews
{
    [super viewWillLayoutSubviews];

    if (collectionView == nil) {
        return;
    }

    UICollectionViewFlowLayout *layout = (UICollectionViewFlowLayout *)collectionView.collectionViewLayout;
    if (layout == nil) {
        return;
    }

    CGFloat sectionInsetMargins = layout.sectionInset.left + layout.sectionInset.right;
    CGFloat safeAreaMargins = collectionView.safeAreaInsets.left + collectionView.safeAreaInsets.right;
    CGFloat marginsAndInsets = sectionInsetMargins + safeAreaMargins + layout.minimumInteritemSpacing * (CGFloat)(NUM_OF_COLUMNS - 1);
    CGFloat itemWidth = (collectionView.bounds.size.width - marginsAndInsets) / (CGFloat)NUM_OF_COLUMNS;
    [layout setItemSize:CGSizeMake(itemWidth, itemWidth)];
}

- (void)didMoveToParentViewController:(UIViewController *)parent
{
    if (parent != nil) {
        UICollectionView *newCollectionView = [[UICollectionView alloc] initWithFrame:self.view.frame collectionViewLayout:layout];
        newCollectionView.dataSource = self;
        [newCollectionView registerClass:[NativeListClassicCell class] forCellWithReuseIdentifier:[RNNativeListClassicViewViewController cellIdentifier]];
        [newCollectionView setBackgroundColor:[[UIColor alloc] initWithWhite:1 alpha:0]];

        collectionView = newCollectionView;
        [self.view addSubview:collectionView];
        
        collectionView.translatesAutoresizingMaskIntoConstraints = NO;
        [NSLayoutConstraint activateConstraints:@[
            [collectionView.topAnchor constraintEqualToAnchor:self.view.topAnchor],
            [collectionView.leadingAnchor constraintEqualToAnchor:self.view.leadingAnchor],
            [collectionView.trailingAnchor constraintEqualToAnchor:self.view.trailingAnchor],
            [collectionView.bottomAnchor constraintEqualToAnchor:self.view.bottomAnchor]
        ]];
    }
}

- (void)willMoveToParentViewController:(UIViewController *)parent
{
    if (parent == nil) {
        [collectionView removeFromSuperview];
        collectionView = nil;
    }
}

- (void)setData:(NSArray<ClassicDataItem *> *)data
{
    _data = data;
    if (collectionView != nil) {
        [collectionView reloadData];
    }
}

- (UIColor *)backgroundColor
{
    return self.view.backgroundColor;
}

- (void)setBackgroundColor:(UIColor *)backgroundColor
{
    [self.view setBackgroundColor:backgroundColor];
}

- (void)scrollToItem:(NSInteger)index
{
    if (collectionView != nil) {
        [collectionView scrollToItemAtIndexPath:[NSIndexPath indexPathForItem:index inSection:0] atScrollPosition:UICollectionViewScrollPositionCenteredVertically animated:YES];
    }
}

- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section
{
    return _data.count;
}

- (__kindof UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath
{
    NativeListClassicCell *myCell = (NativeListClassicCell *)[collectionView dequeueReusableCellWithReuseIdentifier:[RNNativeListClassicViewViewController cellIdentifier] forIndexPath:indexPath];
    ClassicDataItem *item = _data[indexPath.item];
    [myCell setupCellWithItem:item placeholderImage:_placeholderImage];
    return myCell;
}

- (NSInteger)numberOfSectionsInCollectionView:(UICollectionView *)collectionView
{
    return 1;
}

@end
