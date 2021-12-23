package utilities.selenium;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtil {

	private WebDriver driver;

	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollWebElementIntoView(WebElement oElem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", oElem);
	}

	public void switchWindow() {
		String currentWindowHandle = null;
		try {
			currentWindowHandle = driver.getWindowHandle();
		} catch (Exception ex) {
			// Do nothing
		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String newWindowHandle : windowHandles) {
			if (!newWindowHandle.equalsIgnoreCase(currentWindowHandle)) {
				driver.switchTo().window(newWindowHandle);
				break;
			}
		}
	}

	public boolean doesAlertExist() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
}