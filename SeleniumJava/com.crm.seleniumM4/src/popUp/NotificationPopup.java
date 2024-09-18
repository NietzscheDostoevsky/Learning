package popUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import utilityClasses.BaseClassDWS;


// Handle notification popup. 
public class NotificationPopup extends BaseClassDWS  {
	public static void main(String[] args) throws AWTException {
		useChrome("https://www.easemytrip.com/");
		
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_TAB); 
		robot.keyRelease(KeyEvent.VK_TAB);;sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB); 
		robot.keyRelease(KeyEvent.VK_TAB);sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB); 
		robot.keyRelease(KeyEvent.VK_TAB); sleep(2000);
		
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); sleep(2000);
	
		
		postCondition2();
	}
}
