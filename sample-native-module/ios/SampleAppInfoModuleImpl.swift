import Foundation

@objc(SampleAppInfoModuleImpl)
public class SampleAppInfoModuleImpl : NSObject {
  @objc(getAppBuildNumber)
  public func getAppBuildNumber() -> String {
    return Bundle.main.object(forInfoDictionaryKey: "CFBundleVersion") as! String
  }

  @objc(getAppBundleId)
  public func getAppBundleId() -> String {
    return Bundle.main.bundleIdentifier!
  }

  @objc(getAppVersion)
  public func getAppVersion() -> String {
    return Bundle.main.object(forInfoDictionaryKey: "CFBundleShortVersionString") as! String
  }
}
