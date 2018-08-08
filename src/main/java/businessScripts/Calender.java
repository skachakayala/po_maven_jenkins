package businessScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseEngine.DriverEngine;
import pomScripts.Calender_pom;

public class Calender {
	Calender_pom calender;
	WebDriver driver;
	@Test
	public void calender()
	{
		driver = DriverEngine.getDriver();
		calender = PageFactory.initElements(driver, Calender_pom.class);
		calender.calender(driver);
	}

}
