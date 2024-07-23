package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
	
	@Test
	public static void testJavaScriptExecutor() {
		System.setProperty("webdriver.chrome.driver", "D:\\taool\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--incognito");	
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://www.google.com");
		JavascriptExecutor jsexecutor=(JavascriptExecutor) driver;
		//Get the title of the page
		String titleq = (String) jsexecutor.executeScript("return document.title1;");	
		jsexecutor.executeScript("document.querySelector('button').click()");
		jsexecutor.executeScript("window.scrollBy(0,100);");
		//jsexecutor.executeScript("document.getElementById('APjFqb').value='xyz'");
		         
		driver.quit();
	}

	
}
