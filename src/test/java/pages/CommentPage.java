package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentPage extends PostPage {

	public CommentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "name")
	private WebElement txtbx_Name;

	@FindBy(id = "email")
	private WebElement txtbx_Email;
	
	@FindBy(id = "message")
	private WebElement txtbx_Message;
	
	@FindBy(id = "add_comment")
	private WebElement submitbtn_Add_Comment;

	public WebElement get_Txtbx_Name() {
		return txtbx_Name;
	}

	public WebElement get_Txtbx_Email() {
		return txtbx_Email;
	}
	
	public WebElement get_Txtbx_Message() {
		return txtbx_Message;
	}
	
	public WebElement get_Btn_Add_Comment() {
		return submitbtn_Add_Comment;
	}
	
	public void enter_Name(String name) {
		get_Txtbx_Name().clear();
		get_Txtbx_Name().sendKeys(name);
	}
	
	public void enter_Email(String email) {
		get_Txtbx_Email().clear();
		get_Txtbx_Email().sendKeys(email);
	}
	
	public void enter_Message(String message) {
		get_Txtbx_Message().clear();
		get_Txtbx_Message().sendKeys(message);
	}
	
	public void click_On_Add_Comment_Button() {
		get_Btn_Add_Comment().click();
	}
}
