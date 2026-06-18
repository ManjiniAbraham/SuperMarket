package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewPage {
	public WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")
	WebElement moreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement addNewNews;
	@FindBy(id = "news")
	WebElement enterTheNews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveNews;
	@FindBy(xpath = "//a[@type='button']")
	WebElement cancelNews;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement successAlert;

	public ManageNewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickManageNewsMoreInfo() {
		moreInfo.click();
	}

	public void clickToAddNews() {
		addNewNews.click();
	}

	public void enterNewsContent(String news) {
		enterTheNews.sendKeys(news);
	}

	public void saveNews() {
		saveNews.click();
	}

	public void cancelNews() {
		cancelNews.click();
	}

	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

}
