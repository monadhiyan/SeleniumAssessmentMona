package assessmentmona;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import components.Baseclassutil;


public class Formauthentication extends Baseclassutil {
	
	@Parameters({"username","password"})
	@Test
	public void loginsuccessful(String username,String password) {
	
		driver.findElement(By.linkText("Form Authentication")).click();
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		String actmessage = driver.findElement(By.cssSelector("div[id=\"flash\"]")).getText();
		String expmessage = "You logged into a secure area!\n" + "×";
		Assert.assertEquals(actmessage, expmessage);
		driver.findElement(By.cssSelector(".radius")).click();
		String logoutactmsg = driver.findElement(By.cssSelector("div[id=\"flash\"]")).getText();
		String expectlogoutmsg = "You logged out of the secure area!\n" + "×";
		assertEquals(logoutactmsg, expectlogoutmsg);
	
	} 
    
	@Test
	public void loginfailedincorrectusername()

	{
		String username = "wrongmith";
		String password = "SuperSecretPassword!";
		driver.findElement(By.linkText("Form Authentication")).click();
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		String actmessage = driver.findElement(By.cssSelector("div[id=\"flash\"]")).getText();
		String expmessage = "Your username is invalid!\n" + "×";
		assertEquals(actmessage, expmessage);

	}
	@Parameters({"username","incorrectpwd"})
	@Test
	public void loginfailedincorrectpwd() {
		String username = "tomsmith";
		String password = "wrongpwd!";
		driver.findElement(By.linkText("Form Authentication")).click();
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		String actmessage = driver.findElement(By.cssSelector("div[id=\"flash\"]")).getText();
		String expmessage = "Your password is invalid!\n" + "×";
		assertEquals(actmessage, expmessage);
	} 
	
	
}
