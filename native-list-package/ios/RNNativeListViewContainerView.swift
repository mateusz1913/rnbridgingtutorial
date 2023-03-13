import UIKit

@objc(RNNativeListViewContainerView)
public class RNNativeListViewContainerView : UIView {
    private var internalViewController: RNNativeListViewViewController? = nil

    @objc public var viewController: RNNativeListViewViewController? {
        get {
            return internalViewController
        }
        set(newViewController) {
            unmountViewController()
            self.internalViewController = newViewController
            if newViewController != nil {
                mountViewController()
            }
        }
    }

    override public func removeFromSuperview() {
        unmountViewController()
        super.removeFromSuperview()
    }

    override public func willMove(toWindow window: UIWindow?) {
        if window == nil {
            unmountViewController()
        } else {
            mountViewController()
        }
    }

    private func mountViewController() {
        guard let viewController = viewController else {
            return
        }

        if viewController.parent != nil {
            return
        }

        guard let reactViewController = self.reactViewController() else {
            return
        }

        reactViewController.addChild(viewController)
        self.addSubview(viewController.view)
        
        viewController.view.translatesAutoresizingMaskIntoConstraints = false;
        NSLayoutConstraint.activate([
            viewController.view.topAnchor.constraint(equalTo: self.topAnchor),
            viewController.view.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            viewController.view.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            viewController.view.bottomAnchor.constraint(equalTo: self.bottomAnchor)
        ])
        
        viewController.didMove(toParent: reactViewController)
    }

    private func unmountViewController() {
        guard let viewController = viewController else {
            return
        }

        if viewController.parent == nil {
            return
        }

        viewController.willMove(toParent: nil)
        viewController.view.removeFromSuperview()
        viewController.removeFromParent()
    }
}
