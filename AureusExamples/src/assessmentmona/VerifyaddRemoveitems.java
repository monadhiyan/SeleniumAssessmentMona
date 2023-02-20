package assessmentmona;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class VerifyaddRemoveitems extends Baseclassutil{

	@Test
	public void verifyaddRemoveitems() {

		//checks simple add and remove functions
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		int addclick = 3;
		for (int i = 0; i < addclick; i++) {
			driver.findElement(By.cssSelector("[onclick=\"addElement()\"]")).click();
		}

		List<WebElement> deletebutton = driver.findElements(By.cssSelector("[onclick=\"deleteElement()\"]"));
		int numOfdelete = deletebutton.size();
		//number of items created successfully by add element
		System.out.println("Number of items created successfully by add element "+numOfdelete);
		Assert.assertEquals(addclick, numOfdelete);

		for (WebElement item : deletebutton) {
			item.click();
		}
		
		List<WebElement> deletebuttonlist =driver.findElements(By.cssSelector("[onclick=\"deleteElement()\"]"));
		System.out.println("All delete buttons were deteled,the number of delete buttons on page: " +deletebuttonlist.size());
	
}
}