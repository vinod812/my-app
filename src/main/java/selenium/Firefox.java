package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Firefox {
	
    @Test(retryAnalyzer = utility.RetryAnalyzer.class)
	public static void testFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\tool\\geckodriver.exe");
		//FirefoxOptions option=new FirefoxOptions();
		//option.addArguments("--headless");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	

}
