import UIKit

protocol SampleNativeViewControllerDelegate : AnyObject {
    func onSubmit(_ text: String)
    func onCancel()
}

class SampleNativeViewController: UIViewController, UITextFieldDelegate {
    public weak var delegate: SampleNativeViewControllerDelegate? = nil
    
    var headerText: String? = nil
    
    private var textFieldValue: String = ""
    
    override func viewDidLoad() {
        let header = prepareHeader()
        let textInput = prepareTextInput()
        let button = prepareButton()

        let container = UIStackView(arrangedSubviews: [
            header,
            textInput,
            button
        ])
        
        self.view.addSubview(container)
        self.view.backgroundColor = .white
        
        let safeArea = self.view.safeAreaLayoutGuide

        container.translatesAutoresizingMaskIntoConstraints = false
        container.spacing = 20
        container.axis = .vertical
        NSLayoutConstraint.activate([
            container.centerXAnchor.constraint(equalTo: safeArea.centerXAnchor),
            container.centerYAnchor.constraint(equalTo: safeArea.centerYAnchor),
            container.widthAnchor.constraint(greaterThanOrEqualToConstant: 100),
            container.heightAnchor.constraint(greaterThanOrEqualToConstant: 100)
        ])

        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(dismissKeyboard))
        self.view.addGestureRecognizer(tapGesture)
        
        prepareNavigationBar()
    }
    
    @objc func submit() {
        self.delegate?.onSubmit(textFieldValue)
        self.dismiss(animated: true)
    }
    
    @objc func cancel() {
        self.delegate?.onCancel()
        self.dismiss(animated: true)
    }
    
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
    
    @objc func textFieldDidChange(_ textField: UITextField) {
        self.textFieldValue = textField.text ?? ""
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        self.submit()
        return true
    }
    
    private func prepareHeader() -> UILabel {
        let header = UILabel()
        header.text = headerText ?? "Default header text"

        header.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            header.widthAnchor.constraint(equalToConstant: 200),
            header.heightAnchor.constraint(equalToConstant: 50),
        ])
        
        return header
    }
    
    private func prepareTextInput() -> UITextField {
        let textInput = UITextField()
        textInput.addTarget(self, action: #selector(textFieldDidChange), for: .editingChanged)
        textInput.delegate = self
        textInput.keyboardType = .default
        textInput.placeholder = "Type sth"
        
        textInput.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            textInput.widthAnchor.constraint(equalToConstant: 200),
            textInput.heightAnchor.constraint(equalToConstant: 50),
        ])
        
        return textInput
    }
    
    private func prepareButton() -> UIButton {
        let button = UIButton(type: .system)
        button.addTarget(self, action: #selector(submit), for: .touchUpInside)
        button.backgroundColor = .magenta
        button.layer.cornerRadius = 10
        button.setTitle("Submit", for: .normal)
        button.setTitleColor(.white, for: .normal)
        
        button.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            button.widthAnchor.constraint(equalToConstant: 200),
            button.heightAnchor.constraint(equalToConstant: 50),
        ])
        
        return button
    }
    
    private func prepareNavigationBar() {
        let backButton = UIButton(type: .custom)
        backButton.setImage(.init(systemName: "chevron.backward"), for: .normal)
        backButton.tintColor = .magenta
        backButton.addTarget(self, action: #selector(cancel), for: .touchUpInside)

        self.navigationItem.leftBarButtonItem = UIBarButtonItem(customView: backButton)
        self.navigationItem.title = "Bridging Tutorial"
    }
}
