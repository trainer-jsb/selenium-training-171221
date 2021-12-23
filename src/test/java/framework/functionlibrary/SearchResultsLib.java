package framework.functionlibrary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pageobjects.SearchResultsPO;
import utilities.selenium.WebDriverUtil;

public class SearchResultsLib {

	private WebDriver driver;
	private SearchResultsPO searespo;
	private WebDriverUtil webDrvUtil;
	
	public SearchResultsLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> returnListOfProductNames() {
		searespo = new SearchResultsPO(driver);
		List<String> prodNames = new ArrayList<String>();
		List<WebElement> oSearchResults = searespo.returnListOfSearchResult();
		for(WebElement oElem: oSearchResults) {
			String strProdName = oElem.getText().trim();
			prodNames.add(strProdName);
		}
		return prodNames;
	}
	
	public void clickSearchResult(int resultNum) {
		searespo = new SearchResultsPO(driver);
		webDrvUtil = new WebDriverUtil(driver);
		List<WebElement> oSearchResults = searespo.returnListOfSearchResult();
		WebElement oElem = oSearchResults.get(resultNum-1);
		webDrvUtil.scrollWebElementIntoView(oElem);
		oElem.click();
	}
	
	public int returnResultCount() {
		searespo = new SearchResultsPO(driver);
		return searespo.returnListOfSearchResult().size();
	}
}
