package assessmentmona;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class Verifybasicauth extends Baseclassutil {

	@Test
	public void verifybasicauthsuccess() {
		String successcase = "http://admin:admin@the-internet.herokuapp.com/basic_auth/";
		String messagepage = "http://the-internet.herokuapp.com/basic_auth";
		driver.get(successcase);
		driver.get(messagepage);
		String actMessage = driver.findElement(By.cssSelector("p")).getText();
		String expMessage = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(actMessage, expMessage);
	}

	@Test
	public void verifybasicauthfail() throws MalformedURLException, IOException {
		boolean status = false;
		String failcase = "http://admin:wrongpwd@the-internet.herokuapp.com/basic_auth/";
		HttpURLConnection c = (HttpURLConnection) new URL(failcase).openConnection();
		c.setRequestMethod("HEAD");
		c.connect();
		int r = c.getResponseCode();
		if (r == 200) {
			status = true;
			System.out.println("User authorised with incorrect password,Defect to be logged");

		} 
		else 
		{
			System.out.println("User not authorised ");
		}
	    Assert.assertFalse(status);
			

		}

		/*
		 * String messagepage ="http://the-internet.herokuapp.com/basic_auth";
		 * driver.get(failcase); driver.get(messagepage); String actMessage =
		 * driver.findElement(By.cssSelector("body")).getText(); String expMessage =
		 * "Not authorized"; Assert.assertEquals(actMessage, expMessage);
		 */
	}


