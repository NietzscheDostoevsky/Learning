package popUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import utilityClasses.BaseClassDWS;

// Use to pass a value using robot class. 
public class SendKeysUsingRobotClass extends BaseClassDWS {
	public static void main(String[] args) throws AWTException {
		useChrome();
		Robot robot = new Robot(); 
		
		for (int i = 0; i < 6; i++) {
			robot.keyPress(KeyEvent.VK_TAB); 
			robot.keyRelease(KeyEvent.VK_TAB);
			sleep(1000);
		}
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_Y);
		robot.keyRelease(KeyEvent.VK_Y);
		robot.keyPress(KeyEvent.VK_U); 
		robot.keyRelease(KeyEvent.VK_U);
		keyPressAndRelease(robot, KeyEvent.VK_ENTER);
		postCondition2();
	}
	
	public static void keyPressAndRelease(Robot robot, int keyEvent) {
		robot.keyPress(keyEvent);
		robot.keyRelease(keyEvent);
	}
}
