package stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CommentPage;
import pages.ForgotPassword;
import pages.HomePage;
import pages.LoginPage;
import pages.PostPage;
import pages.ProfilePage;
import pages.RegistrationPage;

public class StepDefinitions {
	
	LoginPage loginPage;
	HomePage homePage;
	RegistrationPage registrationPage;
	ProfilePage profilePage;
	PostPage postPage;
	CommentPage commentPage;
	ForgotPassword forgotPassword;
	
	public StepDefinitions() {
		loginPage = new LoginPage(ServiceHooks.driver);
		registrationPage = new RegistrationPage(ServiceHooks.driver);
		homePage = new HomePage(ServiceHooks.driver);
		profilePage = new ProfilePage(ServiceHooks.driver);
		postPage = new PostPage(ServiceHooks.driver);
		commentPage = new CommentPage(ServiceHooks.driver);
		forgotPassword = new ForgotPassword(ServiceHooks.driver);
	}
	
    //////////////////////////////
    ////// Login Page Steps //////
    //////////////////////////////
	
	@Given("^I am on the Login page\"$")
	public void i_am_on_the_Login_page_on_URL() throws Throwable {
		loginPage.navigateTo_LoginPage();
    }

	@Given("^I am a logged in user$")
    public void i_am_a_logged_in_user() throws Throwable {
        loginPage.login();
    }
	
    ////////////////////////////////////
    ////// Login Page Validations //////
    ////////////////////////////////////

	@Then("^I should see \"([^\"]*)\" heading and \"([^\"]*)\" link on Log In screen$")
    public void i_should_see_heading_and_link_on_Log_In_screen(String heading, String link) throws Throwable {
		validate_Login_Page(heading, link);
    }
	
	private void validate_Login_Page(String heading, String link) {
		String locationHref = loginPage.getLocationHref();
        assertEquals(LoginPage.LOGIN_LINK, locationHref);
        
        loginPage.validate_Panel_Header_Footer(heading, link);
	}
	
    /////////////////////////////////////
    ////// Registration Page Steps //////
    /////////////////////////////////////

    @Then("^I should see \"([^\"]*)\" heading and \"([^\"]*)\" link on Registration screen$")
    public void i_should_see_heading_and_link_on_Registration_screen(String heading, String link) throws Throwable {
    	validate_Registration_Page(heading, link);
    }

    private void validate_Registration_Page(String heading, String link) {
		String signUpHeading = registrationPage.get_Heading_SignUp();
    	String signInLink = registrationPage.get_FooterLink_SignIn();
    	assertEquals(heading, signUpHeading);
		assertEquals(link, signInLink);
	}
    
	@Given("^I am a registered user$")
	public void i_am_a_registered_user() throws Throwable {
	    registrationPage.register_User();
	}
	
    ///////////////////////////////////
    ////// Page Navigation Steps //////
    ///////////////////////////////////

	@Given("^I navigate to the \"([^\"]*)\" page$")
	public void i_navigate_to_the_page(String page) throws Throwable {
	    switch(page) {
	    case "Login":
	    	loginPage.navigateTo_LoginPage();
	     	break;
	    case "Registration":
	    	registrationPage.navigateTo_RegistrationPage();
	     	break;
	    case "Home":
	    	homePage.navigateTo_Home_Page();
	    	break; 	
	    case "My Profile":
	    	profilePage.navigate_To_Profile_Page();
	    	break;
	    case "Add New Post":
	    	homePage.navigate_To_Add_Blog_Post_Page();
	    	break;
	    case "Forgot Password":
	    	forgotPassword.navigate_To_Forgot_Password_Page();
	    	break;
	    case "Reset Password":
	    	forgotPassword.navigate_To_Reset_Password_Page();
	    default:
	    	break;
	    }
	}
	
	
	@When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_fill_in_with(String field, String value) throws Throwable {
    	
    	String scenarioName = ServiceHooks.scenarioName;
    	
    	switch (field) {
		case "username":
			if("Successful login using valid credentials".equals(scenarioName)) {
				loginPage.enter_Username(value);
			}
			else {
				registrationPage.enter_Username(value);
			}
			break;
		case "email":
			if("Successful Add Comment to a Blog/Post".equals(scenarioName))
				commentPage.enter_Email(value);
			else if("Successful submit of forgot password form with valid email".equals(scenarioName) || "Failed submit of forgot password form with invalid email".equals(scenarioName))
				forgotPassword.enter_Email(value);
			else	
				registrationPage.enter_Email(value);
			break;
		case "password":
			if("Successful login using valid credentials".equals(scenarioName)) {
				loginPage.enter_Password(value);
			}
			else {
				registrationPage.enter_Password(value);
			}
			break;
		case "confirm password":
			registrationPage.enter_Confirm_Password(value);
			break;
		case "title":
			postPage.enter_Title(value);
			break;
		case "description":
			postPage.enter_Description(value);
			break;
		case "body":
			postPage.enter_Body(value);
			break;
		case "author":
			postPage.enter_Author(value);
			break;
		case "name":
			commentPage.enter_Name(value);
			break;
		case "message":
			commentPage.enter_Message(value);
			break;
		default:
			break;
		}
    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void i_click_on_the_button(String btnTxt) throws Throwable {
    	switch (btnTxt) {
		case "Log In":
	    	loginPage.click_On_LogIn_Button();
			break;
		case "Register Now":
			registrationPage.click_On_Register_Button();
			break;
		case "Update Profile":
	    	profilePage.click_On_Update_Profile_Button();
			break;
		case "Add Post":
	    	postPage.click_On_Add_Post_Button();
			break;	
		case "Add Comment":
			commentPage.click_On_Add_Comment_Button();
			break;
		case "Submit":
			forgotPassword.click_On_Submit_Button();
			break;
		default:
			break;
		}
    }
    
    @Then("^I should be successfully logged in$")
    public void i_should_be_successfully_loged_in() throws Throwable {
    	validate_Home_Page("Dashboard", "Logout");
    }
    
    @Then("^I should be successfully logged out$")
    public void i_should_be_successfully_logged_out() throws Throwable {
    	validate_Login_Page("Sign In", "Or Sign Up");
    }
    
    @Then("^I should be successfully registered$")
    public void i_should_be_successfully_registered() throws Throwable {
    	validate_Home_Page("Dashboard", "Logout");
    }
        
    @Then("^I should land on the \"([^\"]*)\" page$")
    public void i_should_land_on_the_page(String page) throws Throwable {
    	String locationHref = "<not found>";
    	switch (page) {
    	case "Login":
				validate_Login_Page("Sign In", "Or Sign Up");
				break;
			case "Home":
				validate_Home_Page("Dashboard", "Logout");
				break;
			case "My Profile":
				locationHref = profilePage.getLocationHref();
		        assertEquals(ProfilePage.PROFILE_LINK, locationHref);		        
				break;
			case "Add New Post":
				validate_Add_New_Post_Page();
				break;
			case "Blog Details":
				validate_Post_Details_Page();
				break;
			case "Forgot Password":
				validate_Forgot_Password_Page("Forgot Password", "Or Sign In");
				break;
			default:
				break;
    	}
    }
    
    @Then("^I should see \"([^\"]*)\" and \"([^\"]*)\" links$")
    public void i_should_see_link(String link1, String link2) throws Throwable {
    	validate_Home_Page(link1, link2);
    }
    
    private void validate_Home_Page(String link1, String link2) {
    	String locationHref = homePage.getLocationHref();
        assertEquals(HomePage.HOME_LINK, locationHref);
        
    	String dashBoardLink = homePage.get_Dashboard_Link().getText();
    	String logOutLink = homePage.get_Logout_Link().getText();
    	assertEquals(link1, dashBoardLink);
    	assertEquals(link2, logOutLink);
    }
    
    private void validate_Add_New_Post_Page() {
    	String locationHref = postPage.getLocationHref();
        assertEquals(PostPage.POST_LINK, locationHref);
    }
    
    private void validate_Post_Details_Page() {
    	String locationHref = postPage.getLocationHref();
        assertTrue(locationHref.contains(PostPage.POST_LINK));
    }
    
    private void validate_Forgot_Password_Page(String heading, String link) {
		String locationHref = forgotPassword.getLocationHref();
        assertEquals(LoginPage.FORGOT_PASSWORD_LINK, locationHref);
        
        forgotPassword.validate_Panel_Header_Footer(heading, link);
	}
    
    @Then("^I should see \"([^\"]*)\" message as \"([^\"]*)\"$")
    public void i_should_see_message_as(String msgType, String msg) throws Throwable {
    	
    	String message = "<Not Found>";
    	
    	switch (msgType) {
			case "error":			
				message = loginPage.get_Alert_Error_Div().getText();
		    	break;
			case "success":
				message = homePage.get_Alert_Success_Div().getText();
	    	default:
	    		break;
    	}

    	assertTrue(message.contains(msg));
    }
    
    @Then("^I should see the new blog listing on the Homepage$")
    public void i_should_see_the_new_blog_listing_on_the_Homepage() throws Throwable {
    	WebElement postsTable = homePage.get_Table_Post_Listing();
    	validate_Posts_Table_Header(postsTable);
    	validate_Posts_Table_Rows(postsTable, 0);
    }
    
    private void validate_Posts_Table_Header(WebElement tableWebElement) {
    	//Get all web elements by tag name 'tr'
		List<WebElement> rowVals = tableWebElement.findElements(By.tagName("tr"));
		
		//Get column header values from first row
		List<WebElement> colHeader = rowVals.get(0).findElements(By.tagName("th"));
		//Validate the header values
		assertEquals("Title",colHeader.get(0).getText());
		assertEquals("Author",colHeader.get(1).getText());
		assertEquals("Comments",colHeader.get(2).getText());
		assertEquals("Date",colHeader.get(3).getText());
		assertEquals("Edit",colHeader.get(4).getText());
    }
    
    private void validate_Posts_Table_Rows(WebElement tableWebElement, int commentCount) {
    	//Get all web elements by tag name 'tr'
		List<WebElement> rowVals = tableWebElement.findElements(By.tagName("tr"));
		
		int rowNum = tableWebElement.findElements(By.tagName("tr")).size();
		int colNum = rowVals.get(0).findElements(By.tagName("th")).size();
		
		//Loop through the remaining rows
		for(int i=1; i<rowNum; i++) {
			//Get each row's column values by tag name
			List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
			assertEquals("some title", colVals.get(0).getText());
			assertEquals("asdf.asdf@example.com", colVals.get(1).getText());
			assertEquals(Integer.toString(commentCount), colVals.get(2).getText());
			assertTrue(colVals.get(3).getText().contains("Published "));
		}
    }
    
    @Then("^I should be redirected on the \"([^\"]*)\" page$")
    public void i_should_be_redirected_on_the_page(String page) throws Throwable {
    	
    	String locationHref = "<not found>";  
    			
    	switch(page) {
    	case "Login":
    		locationHref = loginPage.getLocationHref();
        	assertEquals(LoginPage.LOGIN_LINK, locationHref);
        	break;
    	case "Registration":
    		locationHref = registrationPage.getLocationHref();
        	assertEquals(RegistrationPage.REG_LINK, locationHref);
        	break;
        default:
        	break;
    	}
    }
    
    @Then("^I should see \"([^\"]*)\" message for \"([^\"]*)\" field on \"([^\"]*)\" page$")
    public void i_should_see_message_for_field_on_page(String msg, String field, String page) throws Throwable {
    	
    	String msgRequired = "<Not Found>";
    	String msgNotValid = "<Not Found>";
    	String msgNotSame = "<Not Found>";
    	
    	switch (page) {
			case "Login":
				if(field.equals("username"))
					msgRequired = loginPage.getMsg_Username_Required();
				if(field.equalsIgnoreCase("password"))
					msgRequired = loginPage.getMsg_Password_Required();
				assertEquals(msg, msgRequired);
				break;
			case "Registration":
				if(field.equals("username")) {
					msgRequired = registrationPage.getMsg_Username_Required();
					assertEquals(msg, msgRequired);
				}
				else if(field.equals("email")) {
					if(registrationPage.get_Txtbx_Email().getAttribute("value").equals("")) {
						msgRequired = registrationPage.getMsg_Email_Required();
						assertEquals(msg, msgRequired);
					}
					else {
						msgNotValid = registrationPage.getMsg_Email_Not_Valid();
						assertEquals(msg, msgNotValid);
					}
					
				}
				else if(field.equals("password")) {
					if(registrationPage.get_Txtbx_Password().getAttribute("value").equals("")) {
						msgRequired = registrationPage.getMsg_Password_Required();
						assertEquals(msg, msgRequired);
						msgNotValid = registrationPage.getMsg_Password_Not_Valid();
						assertEquals(msg, msgNotValid);
					}
					else {
						msgNotValid = registrationPage.getMsg_Password_Not_Valid();
						assertEquals(msg, msgNotValid);						
					}
				}
				else if(field.equals("confirm password")) {
					if(registrationPage.get_Txtbx_Confirm_Password().getAttribute("value").equals("")) {
						msgRequired = registrationPage.getMsg_Confirm_Password_Required();
						// assertEquals(msg, msgRequired);
						// msgNotValid = registrationPage.getMsg_Confirm_Password_Not_Valid();
						// assertEquals("Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters", msgNotValid);
						// msgNotSame = registrationPage.getMsg_Password_Confirm__Not_Same();
						// assertEquals("The password and its confirm are not the same", msgNotSame);
					}
					else {
						// msgNotValid = registrationPage.getMsg_Confirm_Password_Not_Valid();
						// assertEquals("Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters", msgNotValid);
						msgNotSame = registrationPage.getMsg_Password_Confirm__Not_Same();
						assertEquals(msg, msgNotSame);
					}
				}
			    break;
			default:
				break;
		}		
    }
    
    @Then("^I should see \"([^\"]*)\" buttton disbaled$")
    public void i_should_see_buttton_disbaled(String buttonTxt) throws Throwable {
    	switch(buttonTxt) {
    	case "Log In":
        	boolean isLoginButtonEnabled = loginPage.is_Login_Button_Enabled();
        	assertFalse(isLoginButtonEnabled);
    		break;
    	case "Register Now":
        	boolean isRegisterNowButtonEnabled = registrationPage.is_Register_Button_Enabled();
        	assertFalse(isRegisterNowButtonEnabled);
    		break;
    	case "Update Profile":
        	boolean isUpdateProfileNowButtonEnabled = profilePage.is_Update_Profile_Button_Enabled();
        	assertFalse(isUpdateProfileNowButtonEnabled);
    		break;
		default:
    		break;
    	}
    }
    
    @Then("^I should not be able to submit the \"([^\"]*)\" form$")
    public void i_should_not_be_able_to_submit_the_form(String form) throws Throwable {

    	String errorMsg = "<not found>";
    	
    	switch(form) {
    		case "Login":
    			try {
    	        	loginPage.submit_Form();
    	        }
    	        catch(Exception e) {
    	        	errorMsg = e.getMessage().trim();
    	        }
    			break;
    		case "Registration":
    			try {
    	        	registrationPage.submit_Form();
    	        }
    	        catch(Exception e) {
    	        	errorMsg = e.getMessage().trim();
    	        }
    			break;
    		case "Update Profile":
    			try {
    	        	profilePage.submit_Form();
    	        }
    	        catch(Exception e) {
    	        	errorMsg = e.getMessage().trim();
    	        }
    			break;
			default:
				break;
    	}    	
    	assertTrue("invalid element state Excepetion not found.", errorMsg.contains("invalid element state"));
    }
    
    //////////////////////////////
    ////// Background Steps //////
    //////////////////////////////
    
    
    //////////////////////////////
    ////// My Profile Steps //////
    //////////////////////////////

    
    @When("^I click on \"([^\"]*)\" link on the \"([^\"]*)\" page$")
    public void i_click_on_link_on_the_page(String link, String page) throws Throwable {
    	switch(page) {
	    	case "Home":
	    		if(link.equalsIgnoreCase("Logout")) {
					homePage.click_On_Logout_link();
	    		}
	    		else if(link.equalsIgnoreCase("My Profile")) {
					homePage.click_On_Profile_link();
	    		}
	    		else if(link.equalsIgnoreCase("Add New Post")) {
	    			homePage.click_On_Add_New_Post_link();
	    		}
	    		if(link.equalsIgnoreCase("Blog listing")) {
					postPage.click_On_Post_Listing_Link();
	    		}
	    		break;
    	default:
    		break;
    	}
    }

    @Then("^I should see \"([^\"]*)\" heading on the Profile page$")
    public void i_should_see_heading_on_the_profile_page(String pageHeading) throws Throwable {
    	String profileHeading = profilePage.get_Profile_Heading();
    	assertEquals(pageHeading, profileHeading);
    }

    @Then("^\"([^\"]*)\" link should be active on the Profile page$")
    public void link_should_be_active_on_the_Profile_page(String arg1) throws Throwable {
        assertTrue( profilePage.is_Profile_Link_active());
    }
    
    @Then("^\"([^\"]*)\" field should be prepopulated and set as \"([^\"]*)\" on the Profile page$")
    public void field_should_be_prepopulated_and_set_as_on_the_Profile_page(String field, String attrib) throws Throwable {
        String userName = profilePage.get_Username().getText();
        assertTrue(userName != null || userName != "");
    }

    @Then("^\"([^\"]*)\" field should be prepopulated on the Profile page$")
    public void field_should_be_prepopulated_on_the_Profile_page(String field) throws Throwable {
    	String email = profilePage.get_Email().getText();
        assertTrue(email != null || email != "");    
    }
    
    @When("^I fill in First Name as \"([^\"]*)\"$")
    public void i_fill_in_First_Name_as(String firstName) throws Throwable {
        profilePage.enter_First_Name(firstName);
    }

    @When("^I fill in Last Name as \"([^\"]*)\"$")
    public void i_fill_in_Last_Name_as(String lastName) throws Throwable {
        profilePage.enter_Last_Name(lastName);
    }

    @When("^I fill in Age as \"([^\"]*)\"$")
    public void i_fill_in_Age_as(String age) throws Throwable {
        profilePage.enter_Age(age);
    }

    @When("^I fill in Gender as \"([^\"]*)\"$")
    public void i_fill_in_Gender_as(String gender) throws Throwable {
    	profilePage.enter_Gender(gender);
    }

    @When("^I fill in Address as \"([^\"]*)\"$")
    public void i_fill_in_Address_as(String address) throws Throwable {
        profilePage.enter_Address(address);
    }

    @When("^I fill in Website as \"([^\"]*)\"$")
    public void i_fill_in_Website_as(String website) throws Throwable {
        profilePage.enter_Website(website);
    }
    
    @Given("^I see a blog listing on the Homepae$")
    public void i_see_a_blog_listing_on_the_Homepae() throws Throwable {
        
    }

    @Then("^I should see the comment added to the blog$")
    public void i_should_see_the_comment_added_to_the_blog() throws Throwable {
	   	WebElement postsTable = homePage.get_Table_Post_Listing();
    	validate_Posts_Table_Header(postsTable);
    	validate_Posts_Table_Rows(postsTable, 1);
    }
}
