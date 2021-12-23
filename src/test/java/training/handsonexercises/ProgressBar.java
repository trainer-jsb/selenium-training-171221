package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class ProgressBar {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private WebDriverWait wait;
	int timeOut = 120;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
	}

	@Test
	public void progressBarTest() {
		driver.findElement(By.id("downloadButton")).click();
		wait = new WebDriverWait(driver, timeOut);
		By byDownload = By.id("dialog");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(byDownload, "Complete!"));
		driver.findElement(By.xpath("//button[text()='Close']")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}