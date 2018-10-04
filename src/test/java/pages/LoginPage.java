package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	private WebElement txtbx_UserName;
	
	@FindBy(id = "password")
	private WebElement txtbx_Password;
	
	@FindBy(id = "login")
	private WebElement submitbtn_Login;
	
	@FindBy(id = "login-form")
	private WebElement login_Form;
	
	@FindBy(xpath = "//form[@id='login-form']/div[1]/small")
	private WebElement username_Required;
	
	@FindBy(xpath = "//form[@id='login-form']/div[2]/small")
	private WebElement password_Required;

	// Login Page validation
	public String get_Heading_SignIn() {
		return get_Panel_Heading().getText();
	}
		
	public String get_FooterLink_SignUp() {
		return get_Panel_Footer().getText();
	}
	
	public WebElement get_Txtbx_UserName() {
		return txtbx_UserName;
	}
	
	public WebElement get_Txtbx_Password() {
		return txtbx_Password;
	}
	
	public WebElement get_Btn_Login() {
		return submitbtn_Login;
	}
	
	public void click_On_LogIn_Button() {
		get_Btn_Login().click();
	}
	
	public void submit_Form() {
		get_Btn_Login().sendKeys(Keys.ENTER);
	}
	
	// User Input
	public void enter_Username(String username) {
		get_Txtbx_UserName().clear();
		get_Txtbx_UserName().sendKeys(username);
	}
	
	public void enter_Password(String password) {
		get_Txtbx_Password().clear();
		get_Txtbx_Password().sendKeys(password);
	}

	// Form Validation
	public boolean is_Username_Required() {
		String userNameRequired = get_Txtbx_UserName().getAttribute("required");
		return (userNameRequired != null) ? userNameRequired.equalsIgnoreCase("true") : false;
	}
	
	public boolean is_Password_Required() {
		String passwordRequired = get_Txtbx_Password().getAttribute("required");
		return (passwordRequired != null) ? passwordRequired.equalsIgnoreCase("true") : false;
	}
	
	public boolean is_Login_Button_Enabled() {
		return get_Btn_Login().isEnabled();
		// String loginButtonDisabled = get_Btn_Login().getAttribute("disabled");
		// return (loginButtonDisabled != null) ? loginButtonDisabled.equalsIgnoreCase("true") : false;
	}
	
	// Form Validation Error Msg.
	public String getMsg_Username_Required() {
		return username_Required.getText();
	}
	
	public String getMsg_Password_Required() {
		return password_Required.getText();
	}
	
	public void login() {
		navigateTo_LoginPage();
		enter_Username("asdf.asdf");
		enter_Password("Asdf@1234");
		click_On_LogIn_Button();
	}
}
