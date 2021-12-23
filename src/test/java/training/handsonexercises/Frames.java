package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class Frames {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("https://demoqa.com/frames");
	}

	@Test
	public void frameTest() {
		driver.switchTo().frame("frame1");
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}