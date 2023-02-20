package components;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class Baseclassutil {
	protected WebDriver driver;
	
    @Parameters({"baseurl"})
	@BeforeMethod
	public void setUp() {

		// set up chrome driver and hit baseurl
		System.setProperty("webdriver.chrome.driver", "/Users/monashridhar/Downloads/chromedriver_mac64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	public String getscreenshot(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source	= ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testcaseName + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+"//reports//" + testcaseName + ".png";
		
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
