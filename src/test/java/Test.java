import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.WebDriverFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class Test {
	
	static final String exePath = "D:\\Installed Softwares\\chromedriver.exe";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		launchbrowser();
		LoginPage page = new LoginPage(driver);
		page.login();
		
		HomePage homePage = new HomePage(driver);
		
		WebElement postsTable = homePage.get_Table_Post_Listing();
		
		List<WebElement> rowVals = postsTable.findElements(By.tagName("tr"));
		
		int rowNum = postsTable.findElements(By.tagName("tr")).size();
		int colNum = rowVals.get(0).findElements(By.tagName("th")).size();
		
		//Loop through the remaining rows
		for(int i=1; i<rowNum; i++) {
			//Get each row's column values by tag name
			List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
			//Loop through each column
			for(int j=0; j<colNum; j++) {
				//Print the coulumn values to console
				System.out.println(colVals.get(j).getText());
			}
			//Just a separator for each row
			System.out.println("---------------");
		}
		
		closeBrowser();
	}
	
	public static void launchbrowser() {
		driver = WebDriverFactory.createWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void closeBrowser() {
		driver.quit();
	}

}
