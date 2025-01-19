package NoKodr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3LoginPage {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.navigate().to("https://app-staging.nokodr.com/");
	
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("fakeemail@gmail.com");
	driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("fakepass");
}
}
