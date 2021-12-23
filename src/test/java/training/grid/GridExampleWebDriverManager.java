package training.grid;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManagerCombined;

public class GridExampleWebDriverManager {
	
	WebDriver driver;
	WebDriverManagerCombined webDrvMgr;
	
	@Test
	public void navigateTest() throws MalformedURLException, InterruptedException {
		webDrvMgr = new WebDriverManagerCombined();
		driver = webDrvMgr.launchBrowser("local", "chrome");
		driver.get("https://www.google.co.in");
		driver.quit();
	}

}
