package training.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPO {
	
	private WebDriver driver;
	
	public AlertPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickJSAlertButton() {
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
	}
	
	public void clickJSConfirmButton() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click me!']")).click();
	}
	
	 public String getMessageAfterClickingJSConfirmButton() {
		return driver.findElement(By.id("confirm-demo")).getText().trim();
	 }
}