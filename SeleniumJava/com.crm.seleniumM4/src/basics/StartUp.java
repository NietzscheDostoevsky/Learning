package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartUp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(5000);
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.close(); 
		

	}

}
