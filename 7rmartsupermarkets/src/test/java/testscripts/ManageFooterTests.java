package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPageSM;
import pages.ManageFooterPage;
import utilities.MarketExcelUtility;


public class ManageFooterTests extends BaseSuperMarket {

	@Test(retryAnalyzer=retry.Retry.class,description="Verify update button functionality in Manage Footer Page")
	public void verifyAddressUpdate() throws IOException {
		String address = MarketExcelUtility.getStringData(1, 0, "managefootersheet");
		String email = MarketExcelUtility.getStringData(1, 1, "managefootersheet");
		String phone= MarketExcelUtility.getIntegerData(1,2, "managefootersheet");

		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		ManageFooterPage manageFooterObj = new ManageFooterPage(driver);

		// login
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		// editing address
		manageFooterObj.clickOnManageFooterMoreInfoLink();
		manageFooterObj.editAddress();

		manageFooterObj.addressInputField(address);
		manageFooterObj.emailInputFields(email);
		manageFooterObj.phoneInputField(phone);

		// submit
		manageFooterObj.clickUpdateButton();

		boolean updated = manageFooterObj.addressUpdatedSuccessfully();
		Assert.assertTrue(updated);

	}
}
