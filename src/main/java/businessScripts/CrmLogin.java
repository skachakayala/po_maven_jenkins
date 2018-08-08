package businessScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseEngine.DriverEngine;
import pomScripts.CrmLogin_pom;
import reusableFunctions.ObjectUtilities;
import reusableFunctions.PropertiesReusable;

public class CrmLogin extends DriverEngine{
	WebDriver driver;
	CrmLogin_pom crmlogin;
	
	@Test
	public void login() throws IOException
	{
		PropertiesReusable prop = ObjectUtilities.getPropertiesObject(ObjectUtilities.getConfigFilepath());
		driver = DriverEngine.getDriver();
		driver.get(prop.getPropery("url"));
		crmlogin = PageFactory.initElements(driver, CrmLogin_pom.class);
		crmlogin.login(prop.getPropery("username"), prop.getPropery("password"));
	}
	
	@Test(dependsOnMethods="login")
	public void loginVerification()
	{
		driver.switchTo().frame("mainpanel");
		System.out.println(crmlogin.loginverification());
		Assert.assertEquals("  User: sukumar kachakayala", crmlogin.loginverification());
	
	}
	
	/*
	@Test(dependsOnMethods="login")
	public void logoutClick()
	{
		
		//crmlogin.logout();
		//driver.findElement(By.xpath("//a[@class='topnavlink']")).click();
	}
	
	@Test(dependsOnMethods="logoutClick")
	public void logoutVerification()
	{
		
		System.out.println(crmlogin.logoutVerification(driver));
		Assert.assertTrue(crmlogin.logoutVerification(driver)>0);
		System.out.println("logged out sucessfully");
	}*/
	

}
