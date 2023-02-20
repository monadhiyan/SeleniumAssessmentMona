package assessmentmona;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class MouseHover extends Baseclassutil {
	@Test
	public void mouseHover() throws InterruptedException {
		driver.findElement(By.linkText("Hovers")).click();
		List<WebElement> images = driver.findElements(By.cssSelector(".figure"));
		Actions action = new Actions(driver);
		for (WebElement image : images) {
			action.moveToElement(image).perform();
			System.out.println(image.findElement(By.cssSelector(".figcaption")).isDisplayed());

		}
		Thread.sleep(3000);
	}
}
