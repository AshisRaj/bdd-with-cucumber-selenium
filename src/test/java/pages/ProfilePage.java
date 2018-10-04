package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "profile_heading")
	private WebElement profile_Heading;	

	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "age")
	private WebElement age;
	
	@FindBy(id = "gender")
	private WebElement gender;
	
	@FindBy(id="active_Male")
	private WebElement active_Male; 
	
	@FindBy(id="notActive_Male")
	private WebElement notActive_Male; 
	
	@FindBy(id="active_Female")
	private WebElement active_Female; 
	
	@FindBy(id="notActive_Female")
	private WebElement notActive_Female;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "website")
	private WebElement website;
	
	@FindBy(id = "update_profile")
	private WebElement btn_Update_Profile;
	
	public String get_Profile_Heading() {
		return profile_Heading.getText();
	}
	
	public boolean is_Profile_Link_active() {
		return get_Profile_Link().getAttribute("class").contains("active");
	}
	
	public void click_On_Profile_link() {
		get_Profile_Link().click();
	}
	
	public WebElement get_Username() {
		return userName;
	}
	
	public boolean is_Username_field_Readonly() {
		return get_Username().getAttribute("readonly").equalsIgnoreCase("readonly");
	}
	
	public WebElement get_Email() {
		return email;
	}
	
	public WebElement get_First_Name() {
		return firstName;
	}
	
	public void enter_First_Name(String firstName) {
		get_First_Name().clear();
		get_First_Name().sendKeys(firstName);
	}
	
	public WebElement get_Last_Name() {
		return lastName;
	}
	
	public void enter_Last_Name(String lastName) {
		get_Last_Name().clear();
		get_Last_Name().sendKeys(lastName);
	}
	
	public WebElement get_Age() {
		return age;
	}
	
	public void enter_Age(String age) {
		get_Age().clear();
		get_Age().sendKeys(age);
	}
	
	public WebElement get_Gender() {
		return gender;
	}
	
	public void enter_Gender(String gender) {
		String selectedGender = get_Gender().getAttribute("value");
		
		switch(selectedGender) {
			case "M":
				System.out.println("Male gender already selected!");
				break;
			case "F":
				System.out.println("Female gender already selected!");
				break;
			case "":
				if(gender.equalsIgnoreCase("M"))
					get_notActive_Male().click();
				else
					get_notActive_Female().click();
				break;
			default:
				break;
		}
	}

	public WebElement get_Active_Male() {
		return active_Male;
	}

	public WebElement get_notActive_Male() {
		return notActive_Male;
	}

	public WebElement get_Active_Female() {
		return active_Female;
	}

	public WebElement get_notActive_Female() {
		return notActive_Female;
	}

	public WebElement get_Address() {
		return address;
	}

	public void enter_Address(String address) {
		get_Address().clear();
		get_Address().sendKeys(address);
	}

	public WebElement get_Website() {
		return website;
	}

	public void enter_Website(String website) {
		get_Website().clear();
		get_Website().sendKeys(website);
	}

	public WebElement get_Btn_Update_Profile() {
		return btn_Update_Profile;
	}

	public void click_On_Update_Profile_Button() {
		get_Btn_Update_Profile().click();
	}
	
	public boolean is_Update_Profile_Button_Enabled() {
		return get_Btn_Update_Profile().isEnabled();
		// String updateProfileButtonDisabled = get_Btn_Update_Profile().getAttribute("disabled");
		// return (updateProfileButtonDisabled != null) ? updateProfileButtonDisabled.equalsIgnoreCase("true") : false;
	}
	
	public void submit_Form() {
		get_Btn_Update_Profile().sendKeys(Keys.ENTER);
	}
}
