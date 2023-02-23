import Foundation

@objc(AppInfoModuleImpl)
public class AppInfoModuleImpl : NSObject {
    @objc public func getAppBuildNumber() -> String {
        return Bundle.main.object(forInfoDictionaryKey: "CFBundleVersion") as! String
    }

    @objc public func getAppBundleId() -> String {
        return Bundle.main.bundleIdentifier!
    }

    @objc public func getAppVersion() -> String {
        return Bundle.main.object(forInfoDictionaryKey: "CFBundleShortVersionString") as! String
    }
}
