package training.handsonexercises;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.Helper;
import utilities.selenium.WebDriverManager;

public class DynamicDataLoad {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private WebDriverWait wait;
	private SoftAssert sf;
	private Helper helper;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
	}

	@Test
	public void dynamicDataLoadTest() throws IOException {
		sf = new SoftAssert();
		//click in button Get New User
		driver.findElement(By.id("save")).click();
		
		//Wait for user details to display
		wait = new WebDriverWait(driver, 120);
		By byLoading = By.id("loading");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(byLoading, "First Name :"));
		
		//Get user name and assert that length is greater than 25 characters
		String strName = driver.findElement(byLoading).getText();
		sf.assertTrue(strName.length() > 25);
		
		//Asert that 1. Image has an extension .jpg  2. Image is not broken i.e. status code is in range 2xx or 3xx
		WebElement oImg= driver.findElement(By.xpath("//div[@id='loading']/img"));
		String strSrc = oImg.getAttribute("src");
		sf.assertTrue(strSrc.contains(".jpg"), "FAIL | image src was expected to contain .jpg but actual src was " +strSrc);
		
		//Check if image is loaded. Assert that image is not broken
		helper = new Helper();
		int statusCode = helper.returnStatusCode(strSrc);
		sf.assertEquals(statusCode, 200);
		
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}