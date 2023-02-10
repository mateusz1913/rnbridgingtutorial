import Foundation

@objc(SampleNativeScreenModuleDelegate)
public protocol SampleNativeScreenModuleDelegate {
    func sendEvent(name: String, payload: Dictionary<String, Any>)
}

extension SampleNativeScreenModuleImpl : SampleNativeViewControllerDelegate {
    func onSubmit(_ text: String) {
        self.sendEvent(name: Event.onResult.rawValue, payload: ["text": text, "success": true])
    }
    
    func onCancel() {
        self.sendEvent(name: Event.onResult.rawValue, payload: ["success": false])
    }
}

/**
 * Native module's shared implementation
 */
@objc(SampleNativeScreenModuleImpl)
public class SampleNativeScreenModuleImpl : NSObject {
    @objc public weak var delegate: SampleNativeScreenModuleDelegate? = nil

    @objc public func launchNativeScreen(_ valueFromJS: String) {
        guard let presentedViewController = RCTPresentedViewController() else {
            return
        }

        let viewController = SampleNativeViewController()
        viewController.delegate = self
        viewController.headerText = valueFromJS

        let navigationController = UINavigationController(rootViewController: viewController)
        navigationController.modalPresentationStyle = .fullScreen

        presentedViewController.present(navigationController, animated: true)
    }
    
    /**
     * Example usage:
     *
     * ```swift
     * self.sendEvent(name: Event.onResult.rawValue, payload: [ "value" : result ])
     * ````
     */
    private func sendEvent(name: String, payload: Dictionary<String, Any>) {
        self.delegate?.sendEvent(name: name, payload: payload)
    }
}

extension SampleNativeScreenModuleImpl {
    enum Event: String, CaseIterable {
        case onResult
    }

    @objc(supportedEvents)
    public static var supportedEvents: [String] {
        return Event.allCases.map(\.rawValue);
    }
}
