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

public class TestClass2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
    	//set the path to your chrome driver
		//System.setProperty("webdriver.chrome.driver", "")
		System.setProperty("webdriver.chrome.driver", "D:\\tool\\chromedriver.exe");		

		//WebDriver driver = new ChromeDriver();
    }

    @Test
    public void testMethod1() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		String url="https://www.aajtak.in";
		driver.get(url);
    }

    @Test
    public void testMethod2() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		String url="https://www.aajtak.in";
		driver.get(url);
    }
    
    @Test
    public void testMethod3() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		String url="https://www.aajtak.in";
		driver.get(url);
    }
    
    
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
           driver.quit();
        }
    }
}

