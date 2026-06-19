package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPageSM;
import pages.ManageCategoryPage;
import utilities.MarketExcelUtility;

public class ManageCategoryTests extends BaseSuperMarket {
	@Test(retryAnalyzer=retry.Retry.class,description = "Verifying adding a new catefory in Manage Category Page")
	public void addCategorySuccessfully() throws IOException {

		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		ManageCategoryPage manageCategoryObj = new ManageCategoryPage(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		manageCategoryObj.clickManageCategoryMoreInfo();
		manageCategoryObj.clickToAddNewCategory();
		manageCategoryObj.giveCategoryName();
		manageCategoryObj.selectDiscountGroup();
		manageCategoryObj.chooseFile();
		manageCategoryObj.save();

		Assert.assertTrue(manageCategoryObj.isCategoryCreationSuccessful());

	}

}
