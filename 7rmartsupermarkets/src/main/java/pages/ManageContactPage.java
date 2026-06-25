package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")
	WebElement manageContactMoreInfoLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement editContactButton;
	@FindBy(id = "phone")
	WebElement phoneNumberInputField;
	@FindBy(id = "email")
	WebElement emailInputField;
	@FindBy(name = "address")
	WebElement addressInputField;
	@FindBy(name = "del_time")
	WebElement deliveryTimeInputField;
	@FindBy(id = "del_limit")
	WebElement delioveryLimitInputField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//i[contains(@class,'fa-check')]")
	WebElement successAlert;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMoreInfo() {
		manageContactMoreInfoLink.click();
	}

	public void clickEditContact() {
		editContactButton.click();
	}

	public void updatePhoneNumber(String phNumber) {
		phoneNumberInputField.clear();
		phoneNumberInputField.sendKeys(phNumber);
	}

	public void updateAddress(String add) {
		addressInputField.clear();
		addressInputField.sendKeys(add);
	}

	public void updateEmail(String eml) {
		emailInputField.clear();
		emailInputField.sendKeys(eml);
	}

	public void updateDeliveryTime(String time) {
		deliveryTimeInputField.clear();
		deliveryTimeInputField.sendKeys(time);
	}

	public void updateDeliveryLimit(String limit) {
		delioveryLimitInputField.clear();
		delioveryLimitInputField.sendKeys(limit);
	}

	public void clickOnUpdateButton() {
		// wait until clickable
		WaitUtility waitUtilityObj = new WaitUtility();
		// waitUtilityObj.waitForElementToBeClickable(driver, updateButton);
		waitUtilityObj.waitForElement(driver, updateButton);

		// scroll into view
		PageUtility pageutilityObj = new PageUtility();
		pageutilityObj.scrollIntoView(driver, updateButton);

		pageutilityObj.javaScriptClick(driver, updateButton);
		// updateButton.click();
	}

	public void clickOnResetButton() {
		resetButton.click();
	}

	public boolean isUpdateSuccessful() {
		return successAlert.isDisplayed();
	}

}
