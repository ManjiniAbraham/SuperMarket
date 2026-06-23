package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.MarketConstant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	
	public WebDriver driver;
	PageUtility pageUtilityObj = new PageUtility();
	WaitUtility waitUtilityObj = new WaitUtility();
	
	@FindBy(xpath="(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-category\"])[2]")
	WebElement manageCategoryMoreInfoLink;
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement manageCategoryNewButton;
	@FindBy(id="category")
	WebElement categoryuInputField;
	@FindBy(xpath="//li[@id='134-selectable']")
	WebElement discountGroup;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath="//i[contains(@class,'fa-check')]")
	WebElement successAlert;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickManageCategoryMoreInfo() {
		//manageCategoryMoreInfoLink.click();
		//PageUtility pageUtilityObj = new PageUtility();
		pageUtilityObj.actionClassClick(manageCategoryMoreInfoLink, driver);
	}

	public void clickToAddNewCategory() {
		waitUtilityObj.waitForElement(driver, manageCategoryNewButton);
		pageUtilityObj.javaScriptClick(driver, manageCategoryNewButton);
		//manageCategoryNewButton.click();
	}
	
	public void giveCategoryName(String categoryName) {
		categoryuInputField.sendKeys(categoryName);
		
	}
	
	public void selectDiscountGroup() {
		
		discountGroup.click();
	}
	
		
	public void chooseFile() {
		
		FileUploadUtility fileUploadObj=new FileUploadUtility();
		fileUploadObj.fileUploadUsingSendKeys(chooseFileButton,MarketConstant.JEWELERYCATEGORY);
		
	}
	
	public void save() {
		waitUtilityObj.waitForElement(driver, saveButton);
		pageUtilityObj.javaScriptClick(driver, saveButton);
		//saveButton.click();
		
	}
	
	public boolean isCategoryCreationSuccessful() {
		return successAlert.isDisplayed();
	}

}
