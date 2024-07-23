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

public class SelectDropDown {
	
	@Test
	public static void testAction() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
	
		WebElement dropdown= driver.findElement(By.id("dropdown"));
		Select sel=new Select(dropdown);
		sel.selectByIndex(2);
		sel.selectByValue("drop down value");
		
	}
	

}
