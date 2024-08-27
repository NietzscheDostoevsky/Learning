package selectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelect {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		String URL = "file:///C:/GitHub/Learning/SeleniumJava/demo.html#";
		driver.get(URL);
		
		Thread.sleep(3000);
		
		WebElement singleSelect = driver.findElement(By.id("standard_cars"));
		
		Select sel = new Select(singleSelect);
		sel.selectByVisibleText("Mercedes");
		
	}

}
