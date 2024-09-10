package actionClassAssignments;

import org.openqa.selenium.By;

import utilityClasses.BaseClassDWS;

public class OpenBookWithWebElement extends BaseClassDWS {

	public static void main(String[] args) {
		useChrome();
		sleep(1000);
		driver.findElement(By.linkText("Books")).click();
		sleep(3000);
		postCondition2();
	}

}
