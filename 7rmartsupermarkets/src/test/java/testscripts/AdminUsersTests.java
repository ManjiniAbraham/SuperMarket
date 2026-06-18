package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPageSM;
import utilities.MarketExcelUtility;


public class AdminUsersTests extends BaseSuperMarket{
	

	
	@Test
	
	public void addNewUserTypeStaff() throws IOException 
	{
		String adminUserName = MarketExcelUtility.getStringData(1, 0, "adminusers");
	    String adminPassword = MarketExcelUtility.getStringData(1, 1, "adminusers");
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
		
		LoginPageSM loginPageObj = new LoginPageSM(driver);
	    AdminUsersPage adminPageObj = new AdminUsersPage(driver);
	    
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();
		
		adminPageObj.clickOnNewUsersMoreInfo();
		adminPageObj.createNewUsers();
		
		adminPageObj.enterUserName(adminUserName);
		adminPageObj.enterPassword(adminPassword);
		
		adminPageObj.selectUserTypeByIndex(1);
		
		adminPageObj.saveNewUser();
		
		boolean userCreated= adminPageObj.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated);
}
	
	@Test
	
	public void addNewUserTypeAdmin() throws IOException 
	{
		String adminUserName = MarketExcelUtility.getStringData(2, 0, "adminusers");
	    String adminPassword = MarketExcelUtility.getStringData(2, 1, "adminusers");
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
		
		LoginPageSM loginPageObj = new LoginPageSM(driver);
	    AdminUsersPage adminPageObj = new AdminUsersPage(driver);
	    
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();
		
		adminPageObj.clickOnNewUsersMoreInfo();
		adminPageObj.createNewUsers();
		
		adminPageObj.enterUserName(adminUserName);
		adminPageObj.enterPassword(adminPassword);
		
		adminPageObj.selectUserTypeByIndex(2);
		
		adminPageObj.saveNewUser();
		
		boolean userCreated= adminPageObj.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated);
}
	
@Test
	
	public void addNewUserTypePartner() throws IOException 
	{
		String adminUserName = MarketExcelUtility.getStringData(3, 0, "adminusers");
	    String adminPassword = MarketExcelUtility.getStringData(3, 1, "adminusers");
		String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
		String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
		
		LoginPageSM loginPageObj = new LoginPageSM(driver);
	    AdminUsersPage adminPageObj = new AdminUsersPage(driver);
	    
		loginPageObj.enterUserName(userName);
		loginPageObj.enterPassword(password);
		loginPageObj.ClickOnSignIn();
		
		adminPageObj.clickOnNewUsersMoreInfo();
		adminPageObj.createNewUsers();
		
		adminPageObj.enterUserName(adminUserName);
		adminPageObj.enterPassword(adminPassword);
		
		adminPageObj.selectUserTypeByIndex(3);
		
		adminPageObj.saveNewUser();
		
		boolean userCreated= adminPageObj.isUserCreatedSuccessfylly();
		Assert.assertTrue(userCreated);
}
@Test

public void addNewUserTypeDeliveryBoy() throws IOException 
{
	String adminUserName = MarketExcelUtility.getStringData(4, 0, "adminusers");
    String adminPassword = MarketExcelUtility.getStringData(4, 1, "adminusers");
	String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
	String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
	
	LoginPageSM loginPageObj = new LoginPageSM(driver);
    AdminUsersPage adminPageObj = new AdminUsersPage(driver);
    
	loginPageObj.enterUserName(userName);
	loginPageObj.enterPassword(password);
	loginPageObj.ClickOnSignIn();
	
	adminPageObj.clickOnNewUsersMoreInfo();
	adminPageObj.createNewUsers();
	
	adminPageObj.enterUserName(adminUserName);
	adminPageObj.enterPassword(adminPassword);
	
	adminPageObj.selectUserTypeByIndex(4);
	
	adminPageObj.saveNewUser();
	
	boolean userCreated= adminPageObj.isUserCreatedSuccessfylly();
	Assert.assertTrue(userCreated);
}

@Test
public void addAlreadyExistingUser() throws IOException 
{
	String adminUserName = MarketExcelUtility.getStringData(1, 0, "adminusers");
    String adminPassword = MarketExcelUtility.getStringData(1, 1, "adminusers");
	String userName = MarketExcelUtility.getStringData(1, 0, "SuperMarketLoginPage");
	String password = MarketExcelUtility.getStringData(1, 1, "SuperMarketLoginPage");
	
	LoginPageSM loginPageObj = new LoginPageSM(driver);
    AdminUsersPage adminPageObj = new AdminUsersPage(driver);
    
	loginPageObj.enterUserName(userName);
	loginPageObj.enterPassword(password);
	loginPageObj.ClickOnSignIn();
	
	adminPageObj.clickOnNewUsersMoreInfo();
	adminPageObj.createNewUsers();
	
	adminPageObj.enterUserName(adminUserName);
	adminPageObj.enterPassword(adminPassword);
	
	adminPageObj.selectUserTypeByIndex(1);
	
	adminPageObj.saveNewUser();
	
	boolean exitingUser = adminPageObj.userAlreadyExists();
	Assert.assertTrue(exitingUser);
	}

}
