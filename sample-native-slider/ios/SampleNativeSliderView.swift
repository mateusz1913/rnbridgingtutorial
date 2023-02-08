import RangeUISlider
import UIKit

class SliderWrapper {
    public weak var delegate: SampleNativeSliderViewDelegate? = nil
    
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

extension SliderWrapper: RangeUISliderDelegate {
    public func rangeIsChanging(minValueSelected: CGFloat, maxValueSelected: CGFloat, slider: RangeUISlider) {
        self.delegate?.sendOnSampleNativeSliderViewValueChangeEvent(minValue: minValueSelected, maxValue: maxValueSelected)
    }
    
    public func rangeChangeFinished(minValueSelected: CGFloat, maxValueSelected: CGFloat, slider: RangeUISlider) {
        self.delegate?.sendOnSampleNativeSliderViewEndDragEvent(minValue: minValueSelected, maxValue: maxValueSelected)
    }
    
    public func rangeChangeStarted() {
        self.delegate?.sendOnSampleNativeSliderViewBeginDragEvent()
    }
}

@objc(SampleNativeSliderViewDelegate)
public protocol SampleNativeSliderViewDelegate: AnyObject {
    func sendOnSampleNativeSliderViewBeginDragEvent()
    func sendOnSampleNativeSliderViewEndDragEvent(minValue: Double, maxValue: Double)
    func sendOnSampleNativeSliderViewValueChangeEvent(minValue: Double, maxValue: Double)
}

@objc(SampleNativeSliderView)
public class SampleNativeSliderView: UIView {
    @objc public weak var delegate: SampleNativeSliderViewDelegate? = nil {
        didSet {
            sliderWrapper.delegate = delegate
        }
    }

    private var sliderWrapper = SliderWrapper()

    public override init(frame: CGRect) {
        super.init(frame: frame)
        self.sliderWrapper.delegate = self.delegate
        self.addSubview(self.sliderWrapper.slider)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override public var frame: CGRect {
        didSet {
            sliderWrapper.slider.frame = frame
        }
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
