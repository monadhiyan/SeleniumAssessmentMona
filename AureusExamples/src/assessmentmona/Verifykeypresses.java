package assessmentmona;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class Verifykeypresses extends Baseclassutil{
	@Test
	public void keypressespace() throws InterruptedException
	{
		
		driver.findElement(By.linkText("Key Presses")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SPACE);
		System.out.println(driver.findElement(By.cssSelector("p#result")).getText());
		Thread.sleep(3000);
		
		
		
	}
	public void keypresseEnter() throws InterruptedException
	{
		
		driver.findElement(By.linkText("Key Presses")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB);
		System.out.println(driver.findElement(By.cssSelector("p#result")).getText());
		Thread.sleep(3000);
		
		
		
	}

}
