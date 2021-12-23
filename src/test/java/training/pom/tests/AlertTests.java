package training.pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import training.pom.pageobjects.AlertFactoryDesignPO;
import utilities.selenium.WebDriverManager;
import utilities.selenium.WebDriverUtil;

public class AlertTests {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private AlertFactoryDesignPO alertpo;
	private WebDriverUtil webDrvUtil;
	private SoftAssert sf;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

	@BeforeMethod
	public void methodPreReq() {
		webDrvUtil = new WebDriverUtil(driver);
		alertpo = new AlertFactoryDesignPO(driver);
		sf = new SoftAssert();
	}

	@Test(priority = 1)
	public void jsAlertBoxTest() throws InterruptedException {
		Reporter.log("Open JS Alert box and accept it");
		alertpo.clickJSAlertButton();
		webDrvUtil.acceptAlert();
		Thread.sleep(1000);
		Assert.assertFalse(webDrvUtil.doesAlertExist(), "FAIL | Alert message is displayed");
	}

	@Test(priority = 2)
	public void jsConfirmBoxTest() throws InterruptedException {
		Reporter.log("Open JS Confirm box and dismiss it");
		alertpo.clickJSConfirmButton();
		webDrvUtil.dismissAlert();
		Thread.sleep(1000);
		Reporter.log("Message You pressed Cancel should be displayed");
		String actual = alertpo.getMessageAfterClickingJSConfirmButton();
		sf.assertEquals(actual, "You pressed Cancel!");
		
		Reporter.log("Open JS Confirm box and accept it");
		alertpo.clickJSConfirmButton();
		webDrvUtil.acceptAlert();
		Thread.sleep(1000);
		actual = alertpo.getMessageAfterClickingJSConfirmButton();
		Reporter.log("Message You pressed OK should be displayed");
		sf.assertEquals(actual, "You pressed OK!");

		sf.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
