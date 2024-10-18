package pomDWS;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.DWSPOM.DWSLogin;

public class LoginFunctionDWS {
	
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver() ; 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/login");
		
		DWSLogin ref = new DWSLogin(driver);
		ref.email.sendKeys("admin01@gmail.com");
		ref.password.sendKeys("admin01");
		ref.loginButton.click();
	}
}
