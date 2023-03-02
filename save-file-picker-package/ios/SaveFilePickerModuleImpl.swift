import UIKit

@objc(SaveFilePickerModuleDelegate)
public protocol SaveFilePickerModuleDelegate: AnyObject {
    func onCancel()
    func onError(_ error: Error)
    func onSuccess()
}

/**
 * Native module's shared implementation
 */
@objc(SaveFilePickerModuleImpl)
public class SaveFilePickerModuleImpl : NSObject {
    @objc public weak var delegate: SaveFilePickerModuleDelegate? = nil
    
    static let INVALID_PATH_ERROR_MESSAGE = "Invalid path"
    static let NO_VIEW_CONTROLLER_ERROR_MESSAGE = "No viewcontroller"

    @objc public func saveFileWithFilename(_ filename: String) {
        let filenameComponents = filename.components(separatedBy: ".")
        guard let url = Bundle.main.url(forResource: filenameComponents[0], withExtension: filenameComponents[1]) else {
            let error = SaveFilePickerError.InvalidPath(SaveFilePickerModuleImpl.INVALID_PATH_ERROR_MESSAGE)
            delegate?.onError(error)
            return
        }

        guard let presentedViewController = RCTPresentedViewController() else {
            let error = SaveFilePickerError.NoViewController(SaveFilePickerModuleImpl.NO_VIEW_CONTROLLER_ERROR_MESSAGE)
            delegate?.onError(error)
            return
        }

        let documentPicker = self.createDocumentPicker(with: url)
        documentPicker.delegate = self
        presentedViewController.present(documentPicker, animated: true)
    }
    
    private func createDocumentPicker(with url: URL) -> UIDocumentPickerViewController {
        if #available(iOS 14.0, *) {
            return UIDocumentPickerViewController(forExporting: [url], asCopy: true)
        }
        return UIDocumentPickerViewController(url: url, in: .exportToService)
    }
}

extension SaveFilePickerModuleImpl : UIDocumentPickerDelegate {
    public func documentPicker(_ controller: UIDocumentPickerViewController, didPickDocumentsAt urls: [URL]) {
        delegate?.onSuccess()
        controller.delegate = nil
    }
    
    public func documentPickerWasCancelled(_ controller: UIDocumentPickerViewController) {
        delegate?.onCancel()
        controller.delegate = nil
    }
}

enum SaveFilePickerError: Error {
    case InvalidPath(String)
    case NoViewController(String)
}
