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
import org.testng.annotations.Test;

public class ActionClass {
	
	@Test
	public static void testAction() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("Test");
		driver.findElement(By.id("APjFqb")).clear();
		//driver.findElement(By.name("btnK")).click();
		//avascriptExecutor javascriptexecutor= (JavascriptExecutor) driver;
		//javascriptexecutor.executeScript("document.querySelector('gNO89b').click()");
        //javascriptexecutor.executeScript("document.getElementByName('btnK').click()");
		WebElement inputfield=driver.findElement(By.id("APjFqb"));
		Actions act=new Actions(driver);
		act.sendKeys(inputfield, "Hello deatr").perform();
		act.sendKeys(Keys.CONTROL,"a").perform();
		act.sendKeys(Keys.DELETE).perform();	
		act.clickAndHold(inputfield).perform();
		Thread.sleep(10000);
		act.release().perform();
	}
	

}
