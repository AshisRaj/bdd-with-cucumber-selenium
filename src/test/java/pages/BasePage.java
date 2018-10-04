package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public static final String LOGIN_LINK = "http://localhost:8080/login";
	public static final String REG_LINK = "http://localhost:8080/register";
	public static final String PROFILE_LINK = "http://localhost:8080/profile";
	public static final String BLOG_POST_LINK = "http://localhost:8080/post";
	
	WebDriver driver;
		
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "alert_error")
	private WebElement alert_Error_Div;
	
	@FindBy(id = "alert_success")
	private WebElement alert_Success_Div;
	
	@FindBy(className = "panel-heading")
	private WebElement panel_Heading_Div;
	
	@FindBy(className = "panel-footer")
	private WebElement panel_Footer_Div;
	
	@FindBy(id = "dashboard")
	private WebElement dashboard_Link;
	
	@FindBy(id = "add_new_post_link")
	private WebElement add_New_Post_Link;
	
	@FindBy(id = "add_new_post_btn")
	private WebElement add_New_Post_Btn;
	
	@FindBy(id = "log_out")
	private WebElement logout_Link;
	
	@FindBy(id = "profile")
	private WebElement profile_Link;

	
	public void navigateTo_Page(String url) {
		driver.get(url);
	}
	
	public void navigateTo_LoginPage() {
		navigateTo_Page(LOGIN_LINK);
	}
	
	public void navigateTo_RegistrationPage() {
		navigateTo_Page(REG_LINK);
	}
	
	public void navigate_To_Add_Blog_Post_Page() {
		navigateTo_Page(BLOG_POST_LINK);
	}
	
	public void navigate_To_Profile_Page() {
		navigateTo_Page(PROFILE_LINK);
	}
	
	public String getLocationHref() {
		return driver.getCurrentUrl();
	}
	
	public WebElement get_Alert_Error_Div() {
		return alert_Error_Div;
	}
	
	public WebElement get_Alert_Success_Div() {
		return alert_Success_Div;
	}
	
	public WebElement get_Panel_Heading() {
		return panel_Heading_Div;
	}
	
	public WebElement get_Panel_Footer() {
		return panel_Footer_Div;
	}
	
	public WebElement get_Dashboard_Link() {
		return dashboard_Link;
	}
	
	public WebElement get_Add_New_Post_Link() {
		return add_New_Post_Link;
	}
	
	public WebElement get_Add_New_Post_Btn() {
		return add_New_Post_Btn;
	}
	
	public WebElement get_Logout_Link() {
		return logout_Link;
	}
	
	public WebElement get_Profile_Link() {
		return profile_Link;
	}
}
