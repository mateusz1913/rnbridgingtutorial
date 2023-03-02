import Foundation

@objc(DataItem)
public class DataItem: NSObject {
    @objc public var imageUrl: String = ""
    @objc public var itemDescription: String = ""
    
    @objc public init(imageUrl: String, itemDescription: String) {
        self.imageUrl = imageUrl
        self.itemDescription = itemDescription
    }
}
