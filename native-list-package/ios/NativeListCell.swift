import UIKit

class NativeListCell: UICollectionViewCell {
    private var container = UIStackView()
    private var imageView = UIImageView()
    private var label = UILabel()
    
    override init(frame: CGRect) {
        super.init(frame: CGRect(x: 0, y: 0, width: 100, height: 100))
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        container.removeArrangedSubview(imageView)
        container.removeArrangedSubview(label)
        container.removeFromSuperview()
        imageView.image = nil
    }
    
    func setupCell(with item: DataItem, placeholderImage: String) {
        label.text = item.itemDescription
        label.font = .systemFont(ofSize: 10)
        label.textAlignment = .center
        
        imageView.image = UIImage(systemName: placeholderImage)

        container.axis = .vertical
        container.spacing = 10
        container.addArrangedSubview(imageView)
        container.addArrangedSubview(label)
        self.addSubview(container)

        label.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            label.centerXAnchor.constraint(equalTo: container.centerXAnchor),
            label.widthAnchor.constraint(equalToConstant: 100),
            label.heightAnchor.constraint(equalToConstant: 20)
        ])

        imageView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            imageView.widthAnchor.constraint(equalToConstant: 100),
            imageView.heightAnchor.constraint(equalToConstant: 70)
        ])

        container.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            container.centerXAnchor.constraint(equalTo: self.centerXAnchor),
            container.centerYAnchor.constraint(equalTo: self.centerYAnchor),
            container.widthAnchor.constraint(equalToConstant: 100),
            container.heightAnchor.constraint(equalToConstant: 100)
        ])

        self.backgroundColor = UIColor.init(red: 137 / 255, green: 204 / 255, blue: 101 / 255, alpha: 1)
        self.layer.borderColor = UIColor.blue.cgColor
        self.layer.borderWidth = 1
        self.layer.cornerRadius = 10
        self.layer.masksToBounds = true
        self.layer.shadowColor = UIColor.black.cgColor
        self.layer.shadowOffset = CGSize(width: 0, height: 5)
        self.layer.shadowOpacity = 0.34
        self.layer.shadowRadius = 6.27
        self.clipsToBounds = true

        imageView.layoutIfNeeded()
        self.layoutIfNeeded()
    }
}
