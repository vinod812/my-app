package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Headless {
	
	@Test
	public static void testHeadless() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless");
		
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		driver.quit();
	}
	

}
