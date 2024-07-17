package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cls{

	public static void main(String[] args){
		
		//set the path to your chrome driver
		//System.setProperty("webdriver.chrome.driver", "")
		System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();
			
		String url="http://www.google.com";
		//driver.navigate();
		driver.get("http://www.google.com");

   
    }

}