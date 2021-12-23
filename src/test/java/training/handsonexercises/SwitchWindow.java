package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;
import utilities.selenium.WebDriverUtil;

public class SwitchWindow {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private WebDriverUtil webDrvUtil;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("https://demoqa.com/browser-windows");
	}

	@Test
	public void switchWindowTest() {
		webDrvUtil = new WebDriverUtil(driver);
		driver.findElement(By.id("tabButton")).click(); // Opens new tab
		System.out.println(driver.getCurrentUrl()); // Base URL browser-windows
		webDrvUtil.switchWindow();

		System.out.println(driver.getCurrentUrl()); // new URL https://demoqa.com/sample
		driver.close(); // closes the respective window or tab
		webDrvUtil.switchWindow(); // Returns the context to original window

		System.out.println(driver.getCurrentUrl()); //// Base URL browser-windows
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}