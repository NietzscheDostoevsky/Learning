package alertPopUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import utilityClasses.BaseClassDWS;

public class DWSSearchSinpleAlert extends BaseClassDWS {
	public static void main(String[] args) {
		//useChrome();
		useChromeHeadless();
		var searchButton =	driver.findElement(By.cssSelector("input[value='Search']"));
		searchButton.click(); sleep(1000);
		driver.switchTo().alert().accept();
		
		searchButton.click(); sleep(1000);
		driver.switchTo().alert().dismiss();
		
		searchButton.click(); sleep(1000);
		var text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().dismiss();
		
		searchButton.click(); sleep(1000);
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		
		try {
			searchButton.click();			
			searchButton.click(); // should throw exception. 
		} catch (Exception e) {
			
			System.out.println("There is a popup");
		}
		
		postCondition2();
	}
}
