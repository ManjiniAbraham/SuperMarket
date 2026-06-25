package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPageSM {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(@class,'nav-link') and @data-toggle='dropdown']")
	WebElement menuBarField;
	@FindBy(xpath = "//i[contains(@class,'fa-power-off' )]")
	WebElement logoutButton;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement loginScreen;

	public LogoutPageSM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickUserMenu() {
		/*
		 * Actions actions = new Actions(driver);
		 * actions.click(loggedInNameField).perform();
		 */

		menuBarField.click();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", loggedInNameField);
		 */

	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public boolean isLoginScreenDisplayed() {
		return loginScreen.isDisplayed();
	}

}
