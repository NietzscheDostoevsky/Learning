package setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.crm.utility.PropertiesFile.property;

public class Setup {
	
	WebDriver driver ;
	
	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(property("url"));
		
	}
	
	
	@Test
	public void setup() {
		
	}
}
