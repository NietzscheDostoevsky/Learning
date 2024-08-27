package selectClassAssignment;
import java.time.Duration;

/**
 * Task ?  
 * 	Write a script for shopperStack application.  
 * 	✅	Open the browser.  
 * 	✅	Maximize  
 * 	✅	Enter into the webpage 
 * 	✅	Verify the page by using title.  
 * 	✅	Click the login button.  
 * 	✅	Navigate to shopper login.  
 * 	✅	Verify the page using webElement.  
 * 	✅	Click create account.  
 * 	✅	Fill all the details.  
 * 	✅	Verify the radio button 
 * 	✅	Verify the password and confirm password.  
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppersStackRegistration {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String shopperURL = "https://shoppersstack.com/";
		driver.get(shopperURL);
		Thread.sleep(30000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		// Verify homepage by title : 
		if(driver.getTitle().equals("ShoppersStack")) {
			System.out.println("Home page verified ✔️");
			Thread.sleep(5000);
			driver.findElement(By.id("loginBtn")).click();
			// Verify login page using webelement 
			WebElement uniqueLogin = driver.findElement(By.xpath("//strong"));
			if (uniqueLogin.isDisplayed()) {
				driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[2]")).click();
				fillRegistrationForm(driver);			
			} else {
				System.out.println("Login page not gotten");
			}
			
			verifyRadioButton(driver);
			verifyPassConfirmPass(driver);
	
		} else System.out.println("Wrong page");
	}

	

	private static void fillRegistrationForm(ChromeDriver driver) {
		
		driver.findElement(By.id("First Name")).sendKeys("FakeFirstName");
		driver.findElement(By.id("Last Name")).sendKeys("FakeLastName");
		driver.findElement(By.id("Male")).click();
		driver.findElement(By.id("Phone Number")).sendKeys("9898989898");
		driver.findElement(By.id("Email Address")).sendKeys("fake@email.com");
		driver.findElement(By.id("Password")).sendKeys("funny@123HAHA");
		driver.findElement(By.id("Confirm Password")).sendKeys("funny@123HAHA");
		driver.findElement(By.id("Terms and Conditions")).click();
		System.out.println("Filled the form");
	}
	
	
	private static void verifyRadioButton(ChromeDriver driver) {
		System.out.println("Verifying radio button");
		boolean button = driver.findElement(By.id("Terms and Conditions")).isSelected(); 
		if(button)
			System.out.println("Checkbox is checked ✔️");
		else 
			System.out.println("Checkbox is not checked");
		
	}
	
	private static void verifyPassConfirmPass(ChromeDriver driver) {
		System.out.println("getting the filled text: ");
		String pass = driver.findElement(By.id("Password")).getAttribute("value");
		String confirmPass = driver.findElement(By.id("Confirm Password")).getAttribute("value");
		
		if (pass.equals(confirmPass)) 
			System.out.println("Passwrods Match ✔️");
	}
}