package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class InputBox {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("ff");
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
	}

	@Test
	public void inputBoxTest() {
		// Enter expected text in input box
		String expected = "kuch bhi";
		WebElement oInpBox = driver.findElement(By.id("user-message"));
		oInpBox.clear();
		oInpBox.sendKeys(expected);
		// Click on Show Message button
		driver.findElement(By.xpath("//button[@class='btn btn-default'][text()='Show Message']")).click();
		// Assert that actual message is same as entered message
		String actual = driver.findElement(By.id("display")).getText().trim();
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}