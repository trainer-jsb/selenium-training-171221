package training.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExample {
	
	WebDriver driver;
	
	@Test
	public void navigateTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = DesiredCapabilities.edge();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		driver.quit();
	}

}
