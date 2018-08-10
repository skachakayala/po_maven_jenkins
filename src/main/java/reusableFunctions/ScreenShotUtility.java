package reusableFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import baseEngine.DriverEngine;

public class ScreenShotUtility {
	
	static WebDriver driver;
	public static String screenShot(String tcName) throws IOException
	{
		driver = DriverEngine.getDriver();
		TakesScreenshot takescreenShot = (TakesScreenshot)driver;
		File file = takescreenShot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshot\\"+tcName+".jpg";
		FileUtils.copyFile(file, new File(screenshotPath));
		return screenshotPath;
		
	}

}
