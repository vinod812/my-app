package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrokenLink {
    @Test
	public static void testBrokenLink() throws MalformedURLException, IOException {
    	System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");
    	ChromeOptions options=new ChromeOptions();
    	options.addArguments("--incognito");	
        WebDriver driver=new ChromeDriver(options);
    	driver.get("http://www.google.com");
    	List<WebElement> alllinks= driver.findElements(By.tagName("a"));
       	for(WebElement element:alllinks){
    		System.out.println(element.getText());
    		String linkUrl =element.getAttribute("href");
    		System.out.println(linkUrl);
    		HttpURLConnection connection = (HttpURLConnection)(new URL(linkUrl).openConnection());
    		connection.connect();
    		int responseCode=connection.getResponseCode();
    		if(responseCode>=400) {
    			System.out.println("Broken Link"+responseCode);
    		}	}
     	
		driver.quit();
	}
	
	
}
