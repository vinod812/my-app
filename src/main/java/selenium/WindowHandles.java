package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WindowHandles {
    @Test
	public static void windowHandle() {
		System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");
		ChromeOptions option =new ChromeOptions();		
		option.addArguments("--incognio");		
		WebDriver driver= new ChromeDriver(option);
		driver.get("http://www.google.com");
		//driver.get("https://www.linkedin.com");	
		String currentWindowHandle=driver.getWindowHandle();
		System.out.println("Current handle1="+currentWindowHandle);
		Set<String> winhandles= driver.getWindowHandles();

		for(String winhandle:winhandles){
			System.out.println(winhandle);
			driver.switchTo().window(winhandle);
		}
		
		Iterator<String> itr=winhandles.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			driver.switchTo().window(itr.next());
		}	
		driver.quit();
		
	}
		
}
