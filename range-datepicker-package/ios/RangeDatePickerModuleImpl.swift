import Fastis
import Foundation

@objc(RangeDatePickerModuleDelegate)
public protocol RangeDatePickerModuleDelegate {
    func onCancel()
    func onError(_ error: Error)
    func onResult(_ resultDictionary: Dictionary<String, Dictionary<String, Int>>)
}

/**
 * Native module's shared implementation
 */
@objc(RangeDatePickerModuleImpl)
public class RangeDatePickerModuleImpl : NSObject {
    @objc public weak var delegate: RangeDatePickerModuleDelegate? = nil

    @objc public func showRangeDatePicker(withTitle title: String) {
        guard let presentedViewController = RCTPresentedViewController() else {
            let error = CustomError.NoViewController("No ViewController")
            self.delegate?.onError(error)
            return
        }
        let fastisController = FastisController(mode: .range)
        fastisController.title = title
        fastisController.doneHandler = { selectedRange in
            guard let selectedRange = selectedRange else {
                self.delegate?.onCancel()
                return
            }
            let fromDateComponents = Calendar.current.dateComponents([.day, .month, .year], from: selectedRange.fromDate)
            let toDateComponents = Calendar.current.dateComponents([.day, .month, .year], from: selectedRange.toDate)
            self.delegate?.onResult([
                "from": [
                    "day": fromDateComponents.day!,
                    "month": fromDateComponents.month!,
                    "year": fromDateComponents.year!
                ],
                "to": [
                    "day": toDateComponents.day!,
                    "month": toDateComponents.month!,
                    "year": toDateComponents.year!
                ]
            ])
        }
        fastisController.dismissHandler = { self.delegate?.onCancel() }
        fastisController.present(above: presentedViewController)
    }
}

enum CustomError: Error {
    case NoViewController(String)
}
