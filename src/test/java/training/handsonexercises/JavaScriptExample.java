package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverUtil;
import utilities.selenium.WebDriverManager;

public class JavaScriptExample {
	
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private WebDriverUtil util;
	
	
	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("https://demoqa.com/automation-practice-form");
	}

	@Test
	public void jsExampleTest() throws InterruptedException {
		WebElement oElem = driver.findElement(By.id("uploadPicture"));
		util = new WebDriverUtil(driver);
		util.scrollWebElementIntoView(oElem);
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}