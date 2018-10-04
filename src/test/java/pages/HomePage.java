package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public static final String HOME_LINK = "http://localhost:8080/";
		
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "post_listing")
	private WebElement table_Post_Listing;
		
	public void navigateTo_Home_Page() {
		navigateTo_Page(HOME_LINK);
	}
	
	public WebElement get_Table_Post_Listing() { 
		return table_Post_Listing;
	}
	
	public void click_On_Add_New_Post_link() {
		get_Add_New_Post_Link().click();
	}
	
	public void click_On_Profile_link() {
		get_Profile_Link().click();
	}
	
	public void click_On_Logout_link() {
		get_Logout_Link().click();
	}
	
	public boolean is_User_On_Homepage() {
		return HOME_LINK.equals(getLocationHref());
	}
}
