package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.selenium.WebDriverManager;

public class AlertBox {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	SoftAssert sf;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

	@Test(priority = 1)
	public void jsAlertBoxTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		boolean doesAlertExist = false;
		try {
			driver.switchTo().alert();
			doesAlertExist = true;
		} catch(Exception ex) {
			// do nothing
		}
		Assert.assertFalse(doesAlertExist, "FAIL | Alert message is displayed");
	}
	
	@Test (priority =  2)
	public void jsConfirmBoxTest() throws InterruptedException {
		sf = new SoftAssert();
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click me!']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		String actual = null;
		actual = driver.findElement(By.id("confirm-demo")).getText().trim();
		sf.assertEquals(actual, "You pressed Cancel!");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click me!']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		actual = driver.findElement(By.id("confirm-demo")).getText().trim();
		sf.assertEquals(actual, "You pressed OK!");
		
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}