package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	public WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[3]")
	WebElement manageFooterMoreInfoLink;
	@FindBy(xpath = "(//i[contains(@class,'fa-edit')])[1]")
	WebElement editFooterText;
	@FindBy(id = "content")
	WebElement addresField;
	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id = "phone")
	WebElement phoneField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//i[contains(@class,'fa-check')]")
	WebElement updatedSuccessfully;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageFooterMoreInfoLink() {

		manageFooterMoreInfoLink.click();
	}

	public void editAddress() {
		editFooterText.click();
	}

	public void addressInputField(String addressValue) {
		addresField.clear();
		addresField.sendKeys(addressValue);
	}

	public void emailInputFields(String emailValue) {
		emailField.clear();
		emailField.sendKeys(emailValue);
	}

	public void phoneInputField(String phoneNumber) {
		phoneField.clear();
		phoneField.sendKeys(phoneNumber);
		;
	}

	public void clickUpdateButton() {
		updateButton.click();
	}

	public void clickResetButton() {
		resetButton.click();
	}

	public boolean addressUpdatedSuccessfully() {
		return updatedSuccessfully.isDisplayed();

	}
}
