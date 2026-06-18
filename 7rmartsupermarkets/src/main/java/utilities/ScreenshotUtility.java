package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot capture the current situation of the
															// browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// tghis line of code takes the screenshot in realworld. it is stored as a temp file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//adds date and time to the screenshot name
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); //folder creation to store screenshots
																					
		if (!f1.exists()) {
			f1.mkdirs(); // if 'fi'dir does not exists,create it.
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";//decide final screenshot path and format
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // to move the screenshot from the one location to another location
	}

}
