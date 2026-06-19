package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPageSM;
import pages.LogoutPageSM;
import utilities.MarketExcelUtility;

public class LogoutTestsSM extends BaseSuperMarket{
	
	@Test(retryAnalyzer=retry.Retry.class,description="Verify logout functionality")
	public void verifyLogout() throws IOException 
	{	
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
		
		LoginPageSM loginPageObj = new LoginPageSM(driver);
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.checkRememberMe();
		loginPageObj.ClickOnSignIn();
		
		LogoutPageSM logoutPageObj = new LogoutPageSM(driver);
		logoutPageObj.clickUserMenu();
		logoutPageObj.clickLogoutButton();
		boolean loginScreen =logoutPageObj.isLoginScreenDisplayed();
		Assert.assertTrue(loginScreen);
		
		
	}
	

}
