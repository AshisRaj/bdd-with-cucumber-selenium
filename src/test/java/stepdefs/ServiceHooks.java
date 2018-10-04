package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import dao.DBConnection;
import factory.WebDriverFactory;

public class ServiceHooks {
    
	static final String exePath = "D:\\Installed Softwares\\chromedriver.exe";
	public static WebDriver driver;
	public static String scenarioName;
	
	@Before(order=1)
    public void initializeTest() {
		System.out.println("Start the browser and Clear the cookies");
		launchbrowser();
    }

	@Before(order=0)
    public void beforeScenarioStart(Scenario scenario) {
        System.out.println("-----------------Start of Scenario-----------------");
        
        DBConnection.cleanUpCollection("users");
	    DBConnection.cleanUpCollection("posts");
        
        scenarioName = scenario.getName();
        
        if("Successful login using valid credentials".equals(scenarioName)
    		|| "Successful landing on Add a Blog/Post".equals(scenarioName)
    		|| "Successful Logout".equals(scenarioName)
    		|| "Successful creation of a Blog/Post".equals(scenarioName)
        	|| "Successful View Profile".equals(scenarioName) 
        	|| "Successful Edit Profile".equals(scenarioName)) { 
    		DBConnection.createUser("users");
        }
        else if ("Successful Add Comment to a Blog/Post".equals(scenarioName)) {
	        	DBConnection.createUser("users");
	        	DBConnection.createPost("posts");
        }
    }
	
	@After(order=0)
    public void afterScenarioFinish() {
        System.out.println("-----------------End of Scenario-----------------");
    }
	
	@After(order=1)
    public void afterScenario(Scenario scenario) {
		System.out.println("Log out the user and close the browser");
		if (scenario.isFailed()) {
            try {
        		byte[] screenShot = ((TakesScreenshot) ServiceHooks.driver).getScreenshotAs(OutputType.BYTES);
        	    scenario.embed(screenShot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        closeBrowser();        
    }
    
	public void launchbrowser() {
		driver = WebDriverFactory.createWebDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
