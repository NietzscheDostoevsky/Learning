package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.baseclass.VtigerBaseClass;
import static contacts.FillContactInformation.fillContactInformation;

public class CreateNewContact extends VtigerBaseClass   {
	
	@Test
	public void createContact() {
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		fillContactInformation(driver);
	}

	
}
