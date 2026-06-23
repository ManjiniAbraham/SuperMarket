package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPageSM;
import pages.ManageNewPage;
import utilities.MarketExcelUtility;

public class ManageNewsTests extends BaseSuperMarket {

	@Test(description="Verify adding new NEWS in Manage News Page")
	public void addNews() throws IOException {
		String news = MarketExcelUtility.getStringData(1, 0, "news");
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		ManageNewPage manageNewObj = new ManageNewPage(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();
		manageNewObj.clickManageNewsMoreInfo();
		manageNewObj.clickToAddNews();
		manageNewObj.enterNewsContent(news);
		manageNewObj.saveNews();

		boolean alert = manageNewObj.isSuccessAlertDisplayed();
		Assert.assertTrue(alert);
	}

	@Test(description="Verifying cancel button functionality in the Manage News page")
	public void cancelNews() throws IOException {
		String news = MarketExcelUtility.getStringData(1, 0, "news");
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		ManageNewPage manageNewObj = new ManageNewPage(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();
		manageNewObj.clickManageNewsMoreInfo();
		manageNewObj.clickToAddNews();
		manageNewObj.enterNewsContent(news);
		manageNewObj.cancelNews();

		String actualURL = driver.getCurrentUrl();
		String expectedUrl = "https://groceryapp.uniqassosiates.comadmin/list-news";

		Assert.assertEquals(actualURL, expectedUrl, "Failed to Cancel");
	}

}
