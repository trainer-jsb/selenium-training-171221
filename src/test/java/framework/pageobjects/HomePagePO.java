package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePO {
	
	WebDriver driver;
	
	public HomePagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchBtn;
	
	public void enterValueInSearchBox(String searchParam) {
		searchBox.clear();
		searchBox.sendKeys(searchParam);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}

}
