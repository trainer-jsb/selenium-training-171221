package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LaunchBrowser {
	private WebDriver driver;
	private SoftAssert sf;

	@BeforeClass
	public void setup() {
		sf = new SoftAssert();
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
	}

	@Test
	public void launchBrowserTest_Chome() {
		WebElement oLocale = driver.findElement(By.cssSelector("span.nav-logo-locale"));
		String locale = oLocale.getText();
		sf.assertEquals(locale, ".in");

		String title = driver.getTitle();
		sf.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

		String currentURL = driver.getCurrentUrl();
		sf.assertEquals(currentURL, "https://www.amazon.in/");
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}