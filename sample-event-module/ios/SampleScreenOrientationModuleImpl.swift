import Foundation

@objc(SampleScreenOrientationModuleDelegate)
public protocol SampleScreenOrientationModuleDelegate {
    func sendEvent(name: String, payload: Dictionary<String, Any>)
}

/**
 * Native module's shared implementation
 */
@objc(SampleScreenOrientationModuleImpl)
public class SampleScreenOrientationModuleImpl : NSObject {
    @objc public weak var delegate: SampleScreenOrientationModuleDelegate? = nil

    /**
     * Example usage:
     *
     * ```swift
     * self.sendEvent(name: Event.onSampleScreenOrientationModuleChange.rawValue, payload: [ "value" : result ])
     * ````
     */
    private func sendEvent(name: String, payload: Dictionary<String, Any>) {
        self.delegate?.sendEvent(name: name, payload: payload)
    }

    private var lastOrientation = "unknown"

    public override init() {
        super.init()
        NotificationCenter.default.addObserver(self, selector: #selector(self.handleOrientationChange(notification:)), name: UIDevice.orientationDidChangeNotification, object: UIDevice.current)
        DispatchQueue.main.async {
            UIDevice.current.beginGeneratingDeviceOrientationNotifications()
        }
    }
    
    deinit {
        DispatchQueue.main.async {
            UIDevice.current.endGeneratingDeviceOrientationNotifications()
        }
        NotificationCenter.default.removeObserver(self)
    }
    
    @objc func handleOrientationChange(notification: NSNotification) {
        let currentOrientation = UIDevice.current.orientation
        
        var orientation = "unknown"
        if currentOrientation == UIDeviceOrientation.portrait || currentOrientation == UIDeviceOrientation.portraitUpsideDown {
            orientation = "portrait"
        } else if currentOrientation == UIDeviceOrientation.landscapeLeft || currentOrientation == UIDeviceOrientation.landscapeRight {
            orientation = "landscape"
        }

        if lastOrientation == orientation {
            return
        }
        lastOrientation = orientation
        
        self.sendEvent(name: Event.onSampleScreenOrientationModuleChange.rawValue, payload: ["orientation": orientation])
    }
}

extension SampleScreenOrientationModuleImpl {
    enum Event: String, CaseIterable {
        case onSampleScreenOrientationModuleChange
    }

    @objc(supportedEvents)
    public static var supportedEvents: [String] {
        return Event.allCases.map(\.rawValue);
    }
}
