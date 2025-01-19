package NoKodr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2SignupPageValidation {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.navigate().to("https://app-staging.nokodr.com/");
	
	// Navigate to signup page. 
	driver.findElement(By.xpath("(//div[@class='slds-float_right'])[2]/a")).click();
}
}
