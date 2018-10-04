package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	private WebElement txtbx_UserName;
	
	@FindBy(id = "email")
	private WebElement txtbx_Email;
	
	@FindBy(id = "password")
	private WebElement txtbx_Password;

	@FindBy(id = "confirm")
	private WebElement txtbx_Confirm_Password;
	
	@FindBy(id = "register")
	private WebElement submitbtn_Register;
	
	@FindBy(xpath = "//form[@id='register-form']/div[1]/small")
	private WebElement username_Required;
	
	@FindBy(xpath = "//form[@id='register-form']/div[2]/small[1]")
	private WebElement email_Required;
	
	@FindBy(xpath = "//form[@id='register-form']/div[2]/small[2]")
	private WebElement email_Not_Valid;
	
	@FindBy(xpath = "//form[@id='register-form']/div[3]/small[1]")
	private WebElement password_Required;
	
	@FindBy(xpath = "//form[@id='register-form']/div[3]/small[2]")
	private WebElement password_Not_Valid;

	@FindBy(xpath = "//form[@id='register-form']/div[4]/small[1]")
	private WebElement confirm_Password_Required;
	
	@FindBy(xpath = "//form[@id='register-form']/div[4]/small[2]")
	private WebElement confirm_Password_Not_Valid;
	
	@FindBy(xpath = "//form[@id='register-form']/div[4]/small[3]")
	private WebElement password_confirm_Password_Not_Same;

	public WebElement get_Txtbx_UserName() {
		return txtbx_UserName;
	}
	
	public WebElement get_Txtbx_Email() {
		return txtbx_Email;
	}
	
	public WebElement get_Txtbx_Password() {
		return txtbx_Password;
	}
	
	public WebElement get_Txtbx_Confirm_Password() {
		return txtbx_Confirm_Password;
	}

	public WebElement get_Btn_Registration() {
		return submitbtn_Register;
	}

	public WebElement get_Username_Required() {
		return username_Required;
	}
	
	public WebElement get_Email_Required() {
		return email_Required;
	}
	
	public WebElement get_Email_Not_Valid() {
		return email_Not_Valid;
	}
	
	public WebElement get_Password_Required() {
		return password_Required;
	}
	
	public WebElement get_Password_Not_Valid() {
		return password_Not_Valid;
	}
	
	public WebElement get_Confirm_Password_Required() {
		return confirm_Password_Required;
	}
	
	public WebElement get_Confirm_Password_Not_Valid() {
		return confirm_Password_Not_Valid;
	}
	
	public WebElement get_Password_Confirm_Password_Not_Same() {
		return password_confirm_Password_Not_Same;
	}

	// Registration Page validation
	public String get_Heading_SignUp() {
		return get_Panel_Heading().getText();
	}
	
	public String get_FooterLink_SignIn() {
		return get_Panel_Footer().getText();
	}
	
	// User's Form Input
	public void enter_Username(String username) {
		txtbx_UserName.clear();
		txtbx_UserName.sendKeys(username);
	}
	
	public void enter_Email(String email) {
		txtbx_Email.clear();
		txtbx_Email.sendKeys(email);
	}
	
	public void enter_Password(String password) {
		txtbx_Password.clear();
		txtbx_Password.sendKeys(password);
	}

	public void enter_Confirm_Password(String confirmPassword) {
		txtbx_Confirm_Password.clear();
		txtbx_Confirm_Password.sendKeys(confirmPassword);
	}
	
	// User's Form action
	public void click_On_Register_Button() {
		get_Btn_Registration().click();
	}
		
	public void submit_Form() {
		get_Btn_Registration().sendKeys(Keys.ENTER);
	}

	public boolean is_Register_Button_Enabled() {
		return get_Btn_Registration().isEnabled();
		// String registerButtonDisabled = get_Btn_Registration().getAttribute("disabled");
		// return (registerButtonDisabled != null) ? registerButtonDisabled.equalsIgnoreCase("true") : false;
	}
	
	// Form Validation Error Msg.
	public String getMsg_Username_Required() {
		return get_Username_Required().getText();
	}

	public String getMsg_Email_Required() {
		return get_Email_Required().getText();
	}

	public String getMsg_Email_Not_Valid() {
		return get_Email_Not_Valid().getText();
	}
	
	public String getMsg_Password_Required() {
		return get_Password_Required().getText();
	}

	public String getMsg_Password_Not_Valid() {
		return get_Password_Not_Valid().getText();
	}
	
	public String getMsg_Confirm_Password_Required() {
		return get_Confirm_Password_Required().getText();
	}

	public String getMsg_Confirm_Password_Not_Valid() {
		return get_Confirm_Password_Not_Valid().getText();
	}

	public String getMsg_Password_Confirm__Not_Same() {
		return get_Password_Confirm_Password_Not_Same().getText();
	}
	
	public void register_User() {
		navigateTo_RegistrationPage();
		enter_Username("ashis.raj");
		enter_Email("asdf@example.com");
		enter_Password("asdf@1234");
		enter_Confirm_Password("asdf@1234");
		click_On_Register_Button();		
	}
}
