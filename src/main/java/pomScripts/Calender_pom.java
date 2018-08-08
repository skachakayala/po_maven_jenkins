package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Calender_pom {
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calenderLink;
	
	
	@FindBy(xpath="//a[@title='New Event']")
	WebElement newEvent;
	
	@FindBy(xpath="//a[@title='View Today']")
	WebElement view_Today;
	
	public void calender(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(calenderLink).build().perform();
		newEvent.click();
	}

}
