#import "SampleNativeClassicViewController.h"

@interface SampleNativeClassicViewController () <UITextFieldDelegate>
@end

@implementation SampleNativeClassicViewController {
    NSString *textFieldValue;
}

- (void)viewDidLoad
{
    textFieldValue = @"";
    
    UILabel *header = [self prepareHeader];
    UITextField *textInput = [self prepareTextInput];
    UIButton *button = [self prepareButton];
    
    UIStackView *container = [[UIStackView alloc] initWithArrangedSubviews:@[
        header,
        textInput,
        button
    ]];
    
    [self.view addSubview:container];
    self.view.backgroundColor = UIColor.whiteColor;
    
    UILayoutGuide *safeArea = self.view.safeAreaLayoutGuide;
    
    container.translatesAutoresizingMaskIntoConstraints = false;
    container.spacing = 20;
    container.axis = UILayoutConstraintAxisVertical;
    [NSLayoutConstraint activateConstraints:@[
        [container.centerXAnchor constraintEqualToAnchor:safeArea.centerXAnchor],
        [container.centerYAnchor constraintEqualToAnchor:safeArea.centerYAnchor],
        [container.widthAnchor constraintGreaterThanOrEqualToConstant:100],
        [container.heightAnchor constraintGreaterThanOrEqualToConstant:100]
    ]];
    
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tapGesture];
    
    [self prepareNavigationBar];
}

- (void)submit
{
    [self.delegate onSubmit:textFieldValue];
    [self dismissViewControllerAnimated:YES completion:nil];
}

- (void)cancel
{
    [self.delegate onCancel];
    [self dismissViewControllerAnimated:YES completion:nil];
}

- (void)dismissKeyboard
{
    [self.view endEditing:YES];
}

- (void)textFieldDidChange:(UITextField *)textField
{
    NSString *text = @"";
    if (textField.text != nil) {
        text = textField.text;
    }
    textFieldValue = text;
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    [self submit];
    return YES;
}

- (UILabel *)prepareHeader
{
    UILabel *header = [UILabel new];
    NSString *text = @"Default header text";
    if (_headerText != nil) {
        text = _headerText;
    }
    header.text = text;
    
    header.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
        [header.widthAnchor constraintEqualToConstant:200],
        [header.heightAnchor constraintEqualToConstant:50]
    ]];

    return header;
}

- (UITextField *)prepareTextInput
{
    UITextField *textInput = [UITextField new];
    [textInput addTarget:self action:@selector(textFieldDidChange:) forControlEvents:UIControlEventEditingChanged];
    textInput.delegate = self;
    textInput.keyboardType = UIKeyboardTypeDefault;
    textInput.placeholder = @"Type sth";
    
    textInput.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
        [textInput.widthAnchor constraintEqualToConstant:200],
        [textInput.heightAnchor constraintEqualToConstant:50]
    ]];

    return textInput;
}

- (UIButton *)prepareButton
{
    UIButton *button = [UIButton buttonWithType:UIButtonTypeSystem];
    [button addTarget:self action:@selector(submit) forControlEvents:UIControlEventTouchUpInside];
    button.backgroundColor = UIColor.magentaColor;
    button.layer.cornerRadius = 10;
    [button setTitle:@"Submit" forState:UIControlStateNormal];
    [button setTitleColor:UIColor.whiteColor forState:UIControlStateNormal];
    
    button.translatesAutoresizingMaskIntoConstraints = false;
    [NSLayoutConstraint activateConstraints:@[
        [button.widthAnchor constraintEqualToConstant:200],
        [button.heightAnchor constraintEqualToConstant:50]
    ]];

    return button;
}

- (void)prepareNavigationBar
{
    UIButton *backButton = [UIButton buttonWithType:UIButtonTypeCustom];
    [backButton setImage:[UIImage systemImageNamed:@"chevron.backward"] forState:UIControlStateNormal];
    backButton.tintColor = UIColor.magentaColor;
    [backButton addTarget:self action:@selector(cancel) forControlEvents:UIControlEventTouchUpInside];
    
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithCustomView:backButton];
    self.navigationItem.title = @"Bridging Tutorial";
}

@end
