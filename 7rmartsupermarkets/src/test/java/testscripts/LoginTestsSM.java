package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.MarketConstant;
import pages.LoginPageSM;
import utilities.MarketExcelUtility;

public class LoginTestsSM extends BaseSuperMarket {
	@Test(description = "Verify Login with valid credentials", groups = { "Regression" })
	public void verifyLoginWithValidCredentials() throws IOException {
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.checkRememberMe();
		loginPageObj.ClickOnSignIn();

		boolean homepage = loginPageObj.isDashboardDisplayed();
		Assert.assertTrue(homepage, MarketConstant.VALIDCREDENTIALS);// the message here will be displayed only if tc
																		// fails.
	}

	@Test(description = "Verify Login with invalid credentials")
	public void verifyLoginWithInvalidCredentials() throws IOException {
		String userName = MarketExcelUtility.getStringData(2, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(2, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		boolean loginAlert = loginPageObj.loginAlertMessage();
		Assert.assertTrue(loginAlert, MarketConstant.INVALIDCREDENTIALS);
	}

	@Test(description = "Verify Login with invalid user name and valid password")
	public void verifyLoginWithInvalidUserName() throws IOException {
		String userName = MarketExcelUtility.getStringData(3, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(3, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		boolean loginAlert = loginPageObj.loginAlertMessage();
		Assert.assertTrue(loginAlert, MarketConstant.INVALIDUSERNAME);
	}

	@Test(description = "Verify Login with valid username and invalid password")
	public void verifyLoginWithInvalidPassword() throws IOException {
		String userName = MarketExcelUtility.getStringData(4, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(4, 1, "SuperMarketLoginPage");

		LoginPageSM loginPageObj = new LoginPageSM(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();

		boolean loginAlert = loginPageObj.loginAlertMessage();
		Assert.assertTrue(loginAlert, MarketConstant.INVALIDPASSWORD);
	}
}
