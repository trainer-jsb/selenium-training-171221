package utilities.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WebDriverManagerCombined {

	private WebDriver driver;
	private DesiredCapabilities cap;
	private String hubURL = "http://localhost:4444/wd/hub";
	private String errExecEnv = "FAIL | Execution env valid values are either remote or local";
	private String errBrowserName = "FAIL | Invalid browser name passed. Supported values are chrome or ff or edge";

	public WebDriver launchBrowser(String execEnv, String browserName) throws MalformedURLException {
		if (execEnv.equalsIgnoreCase("local")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ff") || browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
				driver = new FirefoxDriver();
			} else {
				Assert.fail(errBrowserName);
			}
		}

		else if (execEnv.equalsIgnoreCase("remote")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				cap = DesiredCapabilities.chrome();
			} else if (browserName.equalsIgnoreCase("ff") || browserName.equalsIgnoreCase("firefox")) {
				cap = DesiredCapabilities.firefox();
			} else if (browserName.equalsIgnoreCase("edge")) {
				cap = DesiredCapabilities.edge();
			} else {
				Assert.fail(errBrowserName);
			}
			driver = new RemoteWebDriver(new URL(hubURL), cap);
		} else {
			Assert.fail(errExecEnv);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}