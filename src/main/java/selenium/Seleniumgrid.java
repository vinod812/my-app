package selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.junit.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Seleniumgrid{
    WebDriver driver;

    @BeforeClass
    public void setUp() {
    	//set the path to your chrome driver
		//System.setProperty("webdriver.chrome.driver", "")
		//System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");		

		//WebDriver driver = new ChromeDriver();
    }

   /* @Test
    public void testMethod1() throws MalformedURLException {
       	  // Define the capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		String url="https://www.aajtak.in";
		driver.get(url);
    }*/
    
    @Test
    public void testMethod2() throws MalformedURLException {
    	DesiredCapabilities capability=DesiredCapabilities.firefox();
    	//capability.setBrowserName("firefox");  	
    	driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);	
    	driver.get("http://www.google.com");
    }

   
  /*  @Test
    public void testMethod3() throws MalformedURLException {
    	DesiredCapabilities capability=new DesiredCapabilities();
    	capability.setBrowserName("chrome");  	
    	driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);	
    	driver.get("http://www.naukri.com");
    }
    */
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
           driver.quit();
        }
    }
}
