package actionClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilityClasses.BaseClassDWS;

public class AutomationtestingIn extends BaseClassDWS {
	
	public static void main(String[] args) {
		
		String baseURLString = "https://demo.automationtesting.in/Register.html";
		useChrome(baseURLString);
		
		sleep(2000);
		// First Name and Last Name 
		driver.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("fakeFirstName");  sleep(500);
		driver.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("fakeLastName"); sleep(500);
		
		// Address, email, phone
		driver.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("fakeAddressString \n ABC Street \n Pune"); sleep(500);
		driver.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys("abc@zyc.com"); sleep(500);
		driver.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys("9999999990"); sleep(500);
		
		//Gender button 
		WebElement genderElement = driver.findElement(By.cssSelector("input[value='Male']")); 
		genderElement.click(); sleep(500);
		if(genderElement.isSelected())
			System.out.println("Gender button Selected");
		
		// Hobbies 
		
		WebElement hobbyElement = driver.findElement(By.id("checkbox2"));
		hobbyElement.click(); sleep(500);
		if(hobbyElement.isSelected())
			System.out.println("Hobby Selected");
		
		//Languages 
		
//		WebElement languages = driver.findElement(By.xpath("//multi-select/div/ul"));
//		
//		languages.findElement(By.linkText("English")).click();
//		languages.findElement(By.linkText("Hindi")).click();
		
		
		//Skills 
		Select skillSelect = new Select(driver.findElement(By.id("Skills")));
		skillSelect.selectByValue("Java"); sleep(500);
		
		//Country
		Select countrySelect = new Select(driver.findElement(By.id("country")));
		countrySelect.selectByValue("India"); sleep(500);
		
		//DOB
		Select yearSelect = new Select(driver.findElement(By.id("yearbox")));
		yearSelect.selectByValue("1917"); sleep(500);
		Select monthSelect = new Select(driver.findElement(By.cssSelector("select[placeholder='Month']")));
		monthSelect.selectByValue("January"); sleep(500);
		Select daySelect = new Select(driver.findElement(By.id("daybox")));
		daySelect.selectByValue("11"); sleep(500);
		
		//Passwords
		driver.findElement(By.id("firstpassword")).sendKeys("fakePassword"); sleep(500);
		driver.findElement(By.id("secondpassword")).sendKeys("fakePassword"); sleep(500);		
		
		sleep(10000);
		postCondition2();
	}

}
