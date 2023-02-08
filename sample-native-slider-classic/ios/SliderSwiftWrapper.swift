import RangeUISlider
import UIKit

class SliderClassicWrapper {
    public weak var delegate: SliderSwiftWrapperDelegate? = nil

    public var slider: RangeUISlider = {
        let rangeSlider = RangeUISlider()
        rangeSlider.barCorners = 5
        rangeSlider.barHeight = 10
        rangeSlider.leftKnobColor = UIColor.systemBlue
        rangeSlider.leftKnobCorners = 10
        rangeSlider.leftKnobHeight = 20
        rangeSlider.leftKnobWidth = 20
        rangeSlider.rightKnobColor = UIColor.systemBlue
        rangeSlider.rightKnobCorners = 10
        rangeSlider.rightKnobHeight = 20
        rangeSlider.rightKnobWidth = 20
        rangeSlider.showKnobsLabels = true
        return rangeSlider
    }()
    
    init() {
        self.slider.delegate = self
    }
}

extension SliderClassicWrapper: RangeUISliderDelegate {
    public func rangeIsChanging(minValueSelected: CGFloat, maxValueSelected: CGFloat, slider: RangeUISlider) {
        self.delegate?.sendOnSampleNativeSliderClassicViewValueChangeEvent(minValue: minValueSelected, maxValue: maxValueSelected)
    }
    
    public func rangeChangeFinished(minValueSelected: CGFloat, maxValueSelected: CGFloat, slider: RangeUISlider) {
        self.delegate?.sendOnSampleNativeSliderClassicViewEndDragEvent(minValue: minValueSelected, maxValue: maxValueSelected)
    }
    
    public func rangeChangeStarted() {
        self.delegate?.sendOnSampleNativeSliderClassicViewBeginDragEvent()
    }
}

@objc(SliderSwiftWrapperDelegate)
public protocol SliderSwiftWrapperDelegate: AnyObject {
    func sendOnSampleNativeSliderClassicViewBeginDragEvent()
    func sendOnSampleNativeSliderClassicViewEndDragEvent(minValue: Double, maxValue: Double)
    func sendOnSampleNativeSliderClassicViewValueChangeEvent(minValue: Double, maxValue: Double)
}

@objc(SliderSwiftWrapper)
public class SliderSwiftWrapper: NSObject {
    @objc public weak var delegate: SliderSwiftWrapperDelegate? = nil {
        didSet {
            sliderWrapper.delegate = delegate
        }
    }
    
    private var sliderWrapper = SliderClassicWrapper()
    
    @objc public var slider: UIView {
        get {
            return sliderWrapper.slider
        }
    }
    
    @objc public func setSliderFrame(_ frame: CGRect) {
        sliderWrapper.slider.frame = frame
    }
    
    @objc public var activeColor: UIColor = UIColor.systemBlue {
        didSet {
            sliderWrapper.slider.rangeSelectedColor = activeColor
        }
    }
    
    @objc public var inactiveColor: UIColor = UIColor.systemGray {
        didSet {
            sliderWrapper.slider.rangeNotSelectedColor = inactiveColor
        }
    }
    
    @objc public var minValue: Double = 0.0 {
        didSet {
            sliderWrapper.slider.scaleMinValue = minValue
        }
    }
    
    @objc public var maxValue: Double = 1.0 {
        didSet {
            sliderWrapper.slider.scaleMaxValue = maxValue
        }
    }
    
    @objc public var leftKnobValue: Double = 0.0 {
        didSet {
            sliderWrapper.slider.changeLeftKnob(value: leftKnobValue)
            sliderWrapper.slider.defaultValueLeftKnob = leftKnobValue
        }
    }
    
    @objc public var rightKnobValue: Double = 1.0 {
        didSet {
            sliderWrapper.slider.changeRightKnob(value: rightKnobValue)
            sliderWrapper.slider.defaultValueRightKnob = rightKnobValue
        }
    }

    @objc public var step: Int = 0 {
        didSet {
            sliderWrapper.slider.stepIncrement = CGFloat(step)
        }
    }
}
