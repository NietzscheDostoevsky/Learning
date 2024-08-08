package webpageVerification;

import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyByTitle {
	
	public static void main(String[] args) throws InterruptedException{
		String expectedTitle = "Demo Web Shop"; 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.navigate().to("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle(); 
		System.out.println(expectedTitle.equals(actualTitle)?"Same same":"Not same");
		Thread.sleep(3000);
		driver.quit();
	} 
	
	
	
	
	
	

}
