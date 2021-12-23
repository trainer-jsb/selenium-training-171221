package training.handsonexercises;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class SelectDropdown {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private Select select;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("https://demoqa.com/select-menu");
	}

	@Test
	public void dropdownTest() {
		WebElement oDropdown = driver.findElement(By.id("oldSelectMenu"));
		select = new Select(oDropdown);
		
		select.selectByIndex(2);  										//Select Green
		select.selectByValue("4");										//Select Purple
		select.selectByVisibleText("Magenta"); 			// Select Magenta
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}