package assessmentmona;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import components.Baseclassutil;

public class Multiplewindows extends Baseclassutil {

	@Test
	public void multipleWindow() {
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> abc = driver.getWindowHandles();
		java.util.Iterator<String> i = abc.iterator();
		String pid = i.next(); //parent ID
		String cid = i.next(); //Child ID
		driver.switchTo().window(cid);
		System.out.println(driver.findElement(By.className("example")).getText());
		driver.switchTo().window(pid);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
	}
}
