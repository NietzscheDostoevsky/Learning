package contacts;

import static contacts.FillContactInformation.fillContactInformation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.baseclass.VtigerLoginBaseClass;

public class CreateNewContact extends VtigerLoginBaseClass   {
	
	@Test(invocationCount = 5)
	public void createContact() throws InterruptedException {
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		fillContactInformation(driver);
		Thread.sleep(5000);
	}

	
}
