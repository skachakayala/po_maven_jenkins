package baseEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverEngine {
	private static WebDriver driver;
	String currentDir;
	
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("firefox")String browserName)
	{
		currentDir = System.getProperty("user.dir");
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.geco.driver", currentDir+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			init();
		}
		else if(browserName.equalsIgnoreCase("internet explorer"))
		{
			System.setProperty("webdriver.geco.driver", currentDir+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			init();
		}
		else
		{
			driver = new ChromeDriver();
			init();
		}
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		if(driver!=null)
		{
			//driver.close();
		}
	}
	public void init()
	{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static WebDriver getDriver()
	{
		return driver;
	}

}
