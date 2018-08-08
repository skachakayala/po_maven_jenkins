package pomScripts;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmLogin_pom {
	
	WebDriver driver ; 
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginButton;
	
	@FindBy(xpath="//td[@class='headertext']")
	WebElement loginUsername;
	
	@FindBy(xpath="//a[@class='topnavlink']")
	WebElement logoutLink;
	
	
	public void login(String userName,String userPassword)
	{
		username.sendKeys(userName);
		password.sendKeys(userPassword);
		loginButton.click();
		
		//RemoteWebdriver
		
	}
	
	public String loginverification()
	{
		return loginUsername.getText();
	}
	
	public void logout()
	{
		logoutLink.click();
	}
	
	public int logoutVerification(WebDriver driver1)
	{
		driver = driver1;
		return driver.findElements(By.xpath("//input[@name='username']")).size();
	}

}
