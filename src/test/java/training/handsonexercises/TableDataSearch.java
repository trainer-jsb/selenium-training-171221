package training.handsonexercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.selenium.WebDriverManager;

public class TableDataSearch {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	SoftAssert sf;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
	}

	@Test
	public void tableDataSearchTest() {
		sf = new SoftAssert();

		String input = "w";
		WebElement fiterInp = driver.findElement(By.id("task-table-filter"));
		fiterInp.clear();
		fiterInp.sendKeys(input);

		// Find all rows; loop through all row and assert that rows which DONT have
		// style="display: none;" contain the search parameter
		List<WebElement> oResult = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		for (WebElement oElem : oResult) {
			String attribStyle = oElem.getAttribute("style");
			if (!attribStyle.equalsIgnoreCase("display: none;")) {
				String actualValue = oElem.getText().toLowerCase();
				sf.assertTrue(actualValue.contains(input.toLowerCase()),
						"FAIL | Result " + actualValue + " didnt contain the search parameter " + input);
			}
		}
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}