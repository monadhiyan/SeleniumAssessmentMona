package assessmentmona;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import components.Baseclassutil;

public class Dropdown extends Baseclassutil {

	public void dropdown()
	{
	driver.findElement(By.linkText("Dropdown")).click();
	WebElement dropdown = driver.findElement(By.id("dropdown"));
	Select select = new Select(dropdown);
	select.selectByVisibleText("Option 1");
	String selectedoption = driver.findElement(By.cssSelector("option[selected=\"selected\"]")).getText();
	Assert.assertEquals(selectedoption,"Option 1" );
	
	//can do the same for option 2
	}	
}
