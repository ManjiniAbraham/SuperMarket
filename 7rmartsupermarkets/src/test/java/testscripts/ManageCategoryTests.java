package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPageSM;
import pages.ManageCategoryPage;
import utilities.FakerUtility;
import utilities.MarketExcelUtility;

public class ManageCategoryTests extends BaseSuperMarket {
	@Test(description = "Verifying adding a new catefory in Manage Category Page")
	public void addCategorySuccessfully() throws IOException {

		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
		

		FakerUtility fakerObj = new FakerUtility();
		String catName = fakerObj.creatARandomFirstName();

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		ManageCategoryPage manageCategoryObj = new ManageCategoryPage(driver);

		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		manageCategoryObj.clickManageCategoryMoreInfo();
		manageCategoryObj.clickToAddNewCategory();

		manageCategoryObj.giveCategoryName(catName);
		manageCategoryObj.selectDiscountGroup();
		manageCategoryObj.chooseFile();
		manageCategoryObj.save();

		Assert.assertTrue(manageCategoryObj.isCategoryCreationSuccessful());

	}

}
