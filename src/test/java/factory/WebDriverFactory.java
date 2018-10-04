package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	
	static final String exePath = "lib\\chromedriver.exe";
	
    public static WebDriver createWebDriver() {
    	String geckodriverPath = System.getProperty("GeckoDriverPath", "lib\\geckodriver.exe");
       	String webdriver = System.getProperty("browser", "chrome");
       	       	
        switch(webdriver) {
            case "firefox":
            	System.setProperty("webdriver.gecko.driver", geckodriverPath);
                return new FirefoxDriver();
            case "chrome":
            	System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
            	return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
}