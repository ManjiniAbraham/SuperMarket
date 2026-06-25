package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPageSM {
	public WebDriver driver;
//WaitUtility waitObject = new WaitUtility(); - this is for globally declaring the object for waitUtility. 

	@FindBy(name = "username")
	WebElement userNameField;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(css = "label[for='remember']")
	WebElement rememberCheckbox;
	@FindBy(css = "button[type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement loginAlertMessage;

	public LoginPageSM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void checkRememberMe() {
		rememberCheckbox.click();
	}

	public void ClickOnSignIn() {

		// waitObject.waitForElementToBeClickable(driver, signInButton);
		signInButton.click();
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean loginAlertMessage() {
		return loginAlertMessage.isDisplayed();
	}

}
