package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage {
	
	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "email")
	private WebElement txtbx_Email;
	
	@FindBy(id = "forgot")
	private WebElement submitbtn_Forgot;
	
	public WebElement get_Txtbx_Email() {
		return txtbx_Email;
	}
		
	public WebElement get_Btn_Submit() {
		return submitbtn_Forgot;
	}
	
	public void enter_Email(String email) {
		get_Txtbx_Email().clear();
		get_Txtbx_Email().sendKeys(email);
	}
	
	public void click_On_Submit_Button() {
		get_Btn_Submit().click();
	}
	
	public void submit_Form() {
		get_Btn_Submit().sendKeys(Keys.ENTER);
	}
	
	// Page validation
	public String get_Heading_ForgotPassword() {
		return get_Panel_Heading().getText();
	}
		
	public String get_FooterLink_SignIn() {
		return get_Panel_Footer().getText();
	}
}
