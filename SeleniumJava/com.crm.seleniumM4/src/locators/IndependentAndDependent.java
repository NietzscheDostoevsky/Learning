package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndependentAndDependent {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    driver.get(webShopURL);
	    
	    if (driver.getCurrentUrl().equals(webShopURL)) {
	    	System.out.println("ON dws page");
	    	driver.findElement(By.xpath("(//a[contains(text(), 'Digital downloads')])[1]")).click();
	    	
	    	// verify dgital dowloads page 
	    	
	    	WebElement verify = driver.findElement(By.xpath("//h1[text()='Digital downloads']"));
	    	if(verify.isDisplayed()) {
	    		System.out.println("Im in digital downlaods page");
	    		
	    		Thread.sleep(3000);
	    		WebElement album3d = driver.findElement(By.xpath("//a[text()='3rd Album']/../following-sibling::div[3]/div/span"));
	    		String price = album3d.getText();
	    		System.out.println("Price of album is : " + price);
	    		driver.close();
	    	}
	    	
	    }
	    else {
	    	System.out.println("Wrong page");
	    	driver.close();
	    }
	}

}
