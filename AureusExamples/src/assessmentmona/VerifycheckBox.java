package assessmentmona;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class VerifycheckBox extends Baseclassutil{
	@Test
	public void verifycheckboxcheck() 
	{
		driver.findElement(By.linkText("Checkboxes")).click();
		List<WebElement> chelements = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int numOfCheck = chelements.size();
		System.out.println("Number of checkboxes:" + numOfCheck);
		
		//change all check boxes to "checked"or check all checkboxes
		for (WebElement checkb : chelements) {
			System.out.println("is this selected : " + checkb.isSelected());
			if (!checkb.isSelected()) {
				checkb.click();

			}

		}
        //uncheck
		for (WebElement uncheck : chelements) {
			System.out.println("is this selected : " + uncheck.isSelected());
			if (uncheck.isSelected()) {
				//change all check boxes to "unchecked" if and when its checked
				uncheck.click();
              
			}

		}
		List<WebElement> finalcheck = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for (WebElement finalch : finalcheck) {
			if (finalch.isSelected()) {
				System.out.println("Error,uncheck has not worked");
				//if the control goes inside this conditional statement, uncheck has not worked.
			}
		}

	} 

}
