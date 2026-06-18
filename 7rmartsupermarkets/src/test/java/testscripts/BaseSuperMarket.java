package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.MarketConstant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class BaseSuperMarket 
{
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinput;

	@Parameters("browser")
	@BeforeMethod	
	public void browserInitialization()
	{
		try 
		{
			properties = new Properties();
			fileinput= new FileInputStream(MarketConstant.CONFIGFILE);
			properties.load(fileinput);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	driver = new EdgeDriver(); 
	//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.get(properties.getProperty("url"));
	//Syntax for implicit wait is driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
	}
	
	@AfterMethod
	/*public void browserQuitAndClose() 
	{
		driver.quit(); // Closes all browser windows or tabs
		//driver.close(); //closes only the current browser window or tab
	}*/
	
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}

}
}

