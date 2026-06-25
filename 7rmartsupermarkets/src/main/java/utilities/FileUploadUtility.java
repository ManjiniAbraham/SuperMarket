package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement elementName, String filePath) {
		elementName.sendKeys(filePath);
	}

	public void fileUploadUsingRobotClass(WebElement elementName, String filePath) throws AWTException {
		StringSelection s = new StringSelection("filePath");// StringSelection class is used to store file path. It
															// stores the file path as text.
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);// Copies the file path into system
																				// clipboard. (Same as Ctrl C action).
		Robot r = new Robot(); // Robot class is used to perform keyboard actions.
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL); // CONTROL, V , VK (virtual Key)etc are constants in the class KeyEvent.
											// KeyEvent class is used to perform keyboard actions.
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
