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

public class DatePicker {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private String baseURL = "http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html";
	SoftAssert sf;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get(baseURL);
	}

	@Test
	public void datePickerTest() {
		sf = new SoftAssert();
		driver.findElement(By.xpath("//div[@id='sandbox-container1']//span[@class='input-group-addon']")).click();
		List<WebElement> oDaysOfWeek = driver.findElements(By.className("dow"));
		
		sf.assertEquals(oDaysOfWeek.size(), 7);	//There should be 7 days in the week
		sf.assertEquals(oDaysOfWeek.get(0).getText().trim(), "Mo"); //First day of the week should be Monday
		
		for(WebElement oElem: oDaysOfWeek) {
			System.out.println(oElem.getText().trim());  //Add assertion that days of the week should be Mo, Tu, We, Th, Fr, Sa, Su
		}
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}