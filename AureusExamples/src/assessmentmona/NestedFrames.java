package assessmentmona;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class NestedFrames extends Baseclassutil{
	
	@Test
	public void nestedFrames()
	{
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
	    String framename = driver.findElement(By.id("content")).getText();
	    Assert.assertEquals(framename,"MIDDLE");
	    System.out.println(framename);
	    
	}
	

}
