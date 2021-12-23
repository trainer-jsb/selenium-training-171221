package framework.functionlibrary;

import org.openqa.selenium.WebDriver;

import framework.pageobjects.HomePagePO;

public class HomePageLib {
	
	private WebDriver driver;
	private  HomePagePO hompagpo;
	
	public HomePageLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String searchParam) {
		hompagpo = new HomePagePO(driver);
		hompagpo.enterValueInSearchBox(searchParam);
		hompagpo.clickSearchBtn();
	}

}
