package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility //helper class. repeated methods reusability
{
	
	public void dropdownVisibleText(WebElement element, String text) 
	{
	Select selectObj = new Select(element);
	selectObj.selectByVisibleText(text);
	}
	
	public void dropdownIndex(WebElement element, int index) 
	{
		Select selectObj = new Select(element);
		selectObj.selectByIndex(index);
	}
	
	public void dropdownValue(WebElement element, String value) 
	{
		Select selectObj = new Select(element);
		selectObj.selectByValue(value);
	}
	
	//====================================================================================================
	
	public void rightClick(WebElement elementName, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.contextClick(elementName).perform(); 
		//If you choose just contextClock, right click can happen anywhere in the page and not on the element you want to
	}
	
	public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();	
	}
	
	public void mouseHover(WebElement elementName, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(elementName).perform();
	}
	
	public void actionClassClick(WebElement elementName, WebDriver driver) 
	{
		
		Actions actions = new Actions(driver);
		actions.click(elementName).perform();
	}
	
	//=============================================================================================================
	
	public void javaScriptExecuterScrollDown(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)","");
	}
	
	public void javaScriptExecuterScrollUp(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-100)","");
	}
	
	public void javaScriptExecuterScrollToTheBottom(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	
	public void javaScriptClick(WebDriver driver, WebElement elementName) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elementName);
	}
	
	public void javaScriptSendKeys(WebDriver driver,WebElement elementName, String value ) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';", elementName);
	}
	public void scrollIntoView(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//========================================================================================================
	
	

}
