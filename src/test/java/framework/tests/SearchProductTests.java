package framework.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import framework.functionlibrary.HomePageLib;
import framework.functionlibrary.SearchResultsLib;
import utilities.DataProvider;
import utilities.selenium.WebDriverManager;

public class SearchProductTests {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private SoftAssert sf;
	private HomePageLib hompaglib;
	private SearchResultsLib seareslib;

	private String propFile = "src/test/resources/base.prop";
	private String url = DataProvider.readTestData(propFile, "url");
	private String searchParam = DataProvider.readTestData(propFile, "searchParam");

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("ff");
		driver.get(url);
	}

	@BeforeMethod
	public void preReq() {
		sf = new SoftAssert();
	}

	@Test
	public void searchProductTest() {
		hompaglib = new HomePageLib(driver);
		hompaglib.searchProduct(searchParam);

		seareslib = new SearchResultsLib(driver);
		List<String> listProdNames = seareslib.returnListOfProductNames();

		for (String prodName : listProdNames) {
			sf.assertTrue(prodName.toLowerCase().contains(searchParam.toLowerCase()),
					"FAIL | Actual product name " + prodName + " doesnt contain search parameter " + searchParam);
		}
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
