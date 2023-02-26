import Fastis
import Foundation

@objc(FastisWrapper)
public class FastisWrapper : NSObject {
    @objc public static func present(
        withTitle title: String,
        viewController: UIViewController,
        onCancel: @escaping () -> Void,
        onResult: @escaping (Dictionary<String, Dictionary<String, Int>>) -> Void
    ) {
        let fastisController = FastisController(mode: .range)
        fastisController.title = title
        fastisController.doneHandler = { selectedRange in
            guard let selectedRange = selectedRange else {
                onCancel()
                return
            }
            let fromDateComponents = Calendar.current.dateComponents([.day, .month, .year], from: selectedRange.fromDate)
            let toDateComponents = Calendar.current.dateComponents([.day, .month, .year], from: selectedRange.toDate)
            onResult([
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
        fastisController.dismissHandler = { onCancel() }
        fastisController.present(above: viewController)
    } 
}
