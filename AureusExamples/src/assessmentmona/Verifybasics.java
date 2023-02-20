package assessmentmona;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class Verifybasics extends Baseclassutil {
	
	@Test
	public void verifyBasics() {
	
		String actualTitle = driver.getTitle();
		String expectedTitle = "The Internet";
		String actualHeading = driver.findElement(By.className("heading")).getText();
		String expectedHeading = "Welcome to the-internet";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertEquals(actualHeading, expectedHeading);
		

	}

	
}
