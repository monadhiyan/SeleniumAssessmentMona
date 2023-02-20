package assessmentmona;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class Verifyclick extends Baseclassutil {
	
	   @Test
	    public void verifyClick() {
		driver.findElement(By.linkText("A/B Testing")).click();
		String currentUrl = driver.getCurrentUrl();
		String Urlafterclick = "https://the-internet.herokuapp.com/abtest";
		Assert.assertEquals(currentUrl, Urlafterclick);

	}
 
}
