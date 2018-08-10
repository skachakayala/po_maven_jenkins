package baseEngine;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import reusableFunctions.ScreenShotUtility;

public class DriverEngine {
	private static WebDriver driver;
	String currentDir;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
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
	
	@BeforeMethod
	public void runTimeTCExeName(Method method) {
		String tcName = method.getName();
		System.out.println("NOW EXECUTING : " + tcName);
		extentTest = extentReports.startTest(tcName);
		
	}
	@AfterMethod
	public void afterTCExec(ITestResult result) throws IOException {
		String tcName = result.getName();
		
		if (result.getStatus()==ITestResult.FAILURE) {
			ScreenShotUtility.screenShot(tcName);
			System.out.println("TC IS FAILED SO TAKING SCREENSHOT: " + tcName);
			getExtentTest().log(LogStatus.FAIL, tcName+ " TESTCASE IS FAILED");
			getExtentTest().log(LogStatus.FAIL, getExtentTest().addScreenCapture(ScreenShotUtility.screenShot(tcName)));
			
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			System.out.println("TC IS SKIPPED SO TAKING SCREENSHOT");
			ScreenShotUtility.screenShot(tcName);
			getExtentTest().log(LogStatus.SKIP, tcName+ " TESTCASE IS SKIPPED");
		}
		extentReports.flush();
		extentReports.endTest(extentTest);
	}
	@BeforeTest
	public void initialiseReport()
	{
		String reportLoc = System.getProperty("user.dir")+"\\Reports\\report.html";
		extentReports = new ExtentReports(reportLoc);	
	}
	@AfterTest
	public void endReport()
	{
		if (extentReports!=null)
			extentReports.close();
	}
	public static ExtentTest getExtentTest()
	{
		return extentTest; 
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
