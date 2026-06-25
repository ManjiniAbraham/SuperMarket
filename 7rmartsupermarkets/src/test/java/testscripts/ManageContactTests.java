package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.MarketConstant;
import pages.LoginPageSM;
import pages.ManageContactPage;
import utilities.MarketExcelUtility;

public class ManageContactTests extends BaseSuperMarket {
	@Test(description = "Verifying editing a contact in Manage Contact Page")
	public void editContactSuccessfully() throws IOException {

		String phone = MarketExcelUtility.getIntegerData(1, 0, "managecontact");
		String address = MarketExcelUtility.getStringData(1, 1, "managecontact");
		String email = MarketExcelUtility.getStringData(1, 2, "managecontact");
		String deliveryTime = MarketExcelUtility.getIntegerData(1, 3, "managecontact");
		String deliveryLimit = MarketExcelUtility.getIntegerData(1, 4, "managecontact");

		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		ManageContactPage manageContactObj = new ManageContactPage(driver);

		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		manageContactObj.clickMoreInfo();
		manageContactObj.clickEditContact();

		manageContactObj.updatePhoneNumber(phone);
		manageContactObj.updateAddress(address);
		manageContactObj.updateEmail(email);
		manageContactObj.updateDeliveryTime(deliveryTime);
		manageContactObj.updateDeliveryLimit(deliveryLimit);
		manageContactObj.clickOnUpdateButton();

		Assert.assertTrue(manageContactObj.isUpdateSuccessful(), MarketConstant.ADDINGNEWCONTACT);

	}

}
