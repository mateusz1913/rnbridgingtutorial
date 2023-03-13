import UIKit

extension RNNativeListViewViewController : UICollectionViewDataSource {
    public func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return self.data.count
    }
    
    public func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let myCell = collectionView.dequeueReusableCell(withReuseIdentifier: RNNativeListViewViewController.CELL_IDENTIFIER, for: indexPath) as! NativeListCell
        let item = self.data[indexPath.item]
        myCell.setupCell(with: item, placeholderImage: placeholderImage)
        return myCell
    }
    
    public func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 1
    }
}

@objc(RNNativeListViewViewController)
public class RNNativeListViewViewController : UIViewController {
    private static let CELL_IDENTIFIER = "MyCell"
    private let NUM_OF_COLUMNS = 3
    private var collectionView: UICollectionView? = nil
    private var layout: UICollectionViewFlowLayout = {
        let layout: UICollectionViewFlowLayout = UICollectionViewFlowLayout()
        layout.sectionInset = UIEdgeInsets(top: 20, left: 10, bottom: 10, right: 10)
        layout.minimumLineSpacing = 10
        layout.minimumInteritemSpacing = 10
        return layout
    }()

    override public func viewWillLayoutSubviews() {
        super.viewWillLayoutSubviews()
        
        guard let collectionView = self.collectionView else {
            return
        }
        
        guard let layout = collectionView.collectionViewLayout as? UICollectionViewFlowLayout else {
            return
        }

        let sectionInsetMargins = layout.sectionInset.left + layout.sectionInset.right
        let safeAreaMargins = collectionView.safeAreaInsets.left + collectionView.safeAreaInsets.right
        let marginsAndInsets = sectionInsetMargins + safeAreaMargins + layout.minimumInteritemSpacing * CGFloat(NUM_OF_COLUMNS - 1)
        let itemWidth = (collectionView.bounds.size.width - marginsAndInsets) / CGFloat(NUM_OF_COLUMNS)
        layout.itemSize = CGSize(width: itemWidth, height: itemWidth)
    }
    
    public override func didMove(toParent parent: UIViewController?) {
        if parent != nil {
            let collectionView = UICollectionView(frame: self.view.frame, collectionViewLayout: layout)
            collectionView.dataSource = self
            collectionView.register(NativeListCell.self, forCellWithReuseIdentifier: RNNativeListViewViewController.CELL_IDENTIFIER)
            collectionView.backgroundColor = .init(white: 1, alpha: 0)
            
            self.collectionView = collectionView
            self.view.addSubview(collectionView)
            
            collectionView.translatesAutoresizingMaskIntoConstraints = false
            NSLayoutConstraint.activate([
                collectionView.topAnchor.constraint(equalTo: self.view.topAnchor),
                collectionView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
                collectionView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
                collectionView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor)
            ])
        }
    }
    
    public override func willMove(toParent parent: UIViewController?) {
        if parent == nil {
            self.collectionView?.removeFromSuperview()
            self.collectionView = nil
        }
    }

    @objc public var data: Array<DataItem> = [] {
        didSet {
            self.collectionView?.reloadData()
        }
    }

    @objc public var backgroundColor: UIColor? {
        get {
            return self.view.backgroundColor
        }
        set(newBackgroundColor) {
            self.view.backgroundColor = newBackgroundColor
        }
    }
    
    @objc public var placeholderImage: String = ""
    
    @objc public func scrollToItem(_ index: Int) {
        self.collectionView?.scrollToItem(at: IndexPath(item: index, section: 0), at: .centeredVertically, animated: true)
    }
}
