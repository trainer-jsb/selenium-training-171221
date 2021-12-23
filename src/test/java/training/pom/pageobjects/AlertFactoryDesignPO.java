package training.pom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFactoryDesignPO {

	private WebDriver driver;

	public AlertFactoryDesignPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-default']")
	private WebElement jsAlertButton;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg'][text()='Click me!']")
	private WebElement jsConfirmButton;

	@FindBy(id = "confirm-demo")
	private WebElement messageJSConfirm;

	public void clickJSAlertButton() {
		jsAlertButton.click();
	}

	public void clickJSConfirmButton() {
		jsConfirmButton.click();
	}

	public String getMessageAfterClickingJSConfirmButton() {
		return messageJSConfirm.getText().trim();
	}
}