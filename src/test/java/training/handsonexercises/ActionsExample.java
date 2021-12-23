package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class ActionsExample {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private Actions action;

	@BeforeClass
	public void setup() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
	}
	
	@BeforeMethod
	public void methodPreReq() {
		action = new Actions(driver);
	}

	@Test (priority = 1)
	public void dragAndDropTest() {
		Reporter.log("Navigate to droppable URL");
		driver.get("https://demoqa.com/droppable");
		
		Reporter.log("Drag and drop the source to target");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, target).perform();
		
		Reporter.log("Assert that source is dopped on target");
		String actual = target.getText();
		Assert.assertEquals(actual, "Dropped!");
	}
	
	@Test (priority =  2)
	public void mouseHoverTest() {
		Reporter.log("Navigate to menu URL");
		driver.get("https://demoqa.com/menu/");
		
		Reporter.log("Move the curson to main item 2 to show the sublinks");
		WebElement target = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		action.moveToElement(target).build().perform();
	}
	
	@Test
	public void multipleActionsUsingActionsClass() {
		driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
		WebElement oElem = driver.findElement(By.id("task-table-filter"));
		
		action.keyDown(Keys.SHIFT)  //Wireframe
			.sendKeys(oElem, "w")
			.keyUp(Keys.SHIFT)
			.sendKeys(Keys.SPACE)
			.sendKeys(oElem, "ireframe")
			.build().perform();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}