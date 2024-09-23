package popUpAssignments;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;import org.openqa.selenium.devtools.v114.profiler.model.ConsoleProfileFinished;
import org.openqa.selenium.interactions.Actions;

/*
 * Write a script for RedBus website.  
 * Open the browser.  
 * Maximize() 
 * Enter into redbus.  
 * Verify the page by using title.  
 * After verification, fill all the details of from and to.  
 * Can choose any details.  
 * In date, click 27 sep and search the bus.
 */

import utilityClasses.BaseClassDWS;

public class RedBusCalender extends BaseClassDWS{
	public static void main(String[] args) {
		String url = "https://www.redbus.in/" ;
		ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("disable-notifications")); 
		driver.manage().window().maximize();
		driver.get(url);
		if(driver.getTitle().equals("Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus"))
			System.out.println("Page verified by title");
		
		driver.findElement(By.id("src")).sendKeys("Pune"); sleep(1000);  
		driver.findElement(By.id("src")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("dest")).sendKeys("Mumbai"); sleep(1000);  
		driver.findElement(By.id("dest")).sendKeys(Keys.ENTER);
		
		//Clicking on calander
		driver.findElement(By.id("onwardCal")).click(); sleep(2000);  
		driver.findElement(By.xpath("//span[text()=27]")).click(); sleep(2000);
		
		driver.findElement(By.id("search_button")).click(); sleep(5000);
		
		// Select only seater buses.
		driver.findElement(By.xpath("(//label[@for='bt_SEATER'])[1]")).click(); sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='bus-items']/div)[1]/li/div/div[2]/div")).click(); sleep(3000);
		
		//find canvas of the lower deck, with seaters only. 
		WebElement canvas = driver.findElement(By.xpath("//canvas[@data-type='lower']")); 
		
		selectSeat(canvas, driver); 
		
			
		
	}
	
	/*
	 * Select a seat on the bus, and if any seat is selected, returns the control back. 
	 */
	private static void selectSeat(WebElement canvas, WebDriver driver) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(canvas).perform();
		//find the 0,0 coordicate 
		var x0 = canvas.getSize().getWidth() / 2;
		var y0 = canvas.getSize().getHeight() / 2; 
		
		var deltaX = canvas.getSize().getWidth() / 12 ; // divide the canvas into 12 equal parts
		var deltaY = canvas.getSize().getHeight() / 4 ; // divide the canvas into 4 equal parts.
		var initialX = x0 - (5*deltaX) - (deltaX/2);
		var initialY = y0 - (1*deltaY) - (deltaY/2);
		
		System.out.println("Width: " + canvas.getSize().getWidth());
		System.out.println("Height: " + canvas.getSize().getHeight());
		System.out.println("DeltaX: " + deltaX);
		System.out.println("DelyaY: " + deltaY);
		System.out.println("InitialX: " + initialX );
		System.out.println("InitialY: " + initialY);;
		
		
		actions.moveByOffset(-1*deltaX*5, 0).perform();
		actions.moveByOffset(-1*deltaX/2, 0).perform();
		actions.moveByOffset(0, -1*deltaY).perform();
		actions.moveByOffset(0, -1*deltaY/2).perform();
	
		for (int j = initialY; j < canvas.getSize().getHeight(); j+=deltaY ) {
			 for (int i = initialX; i < canvas.getSize().getWidth(); i+=deltaX) {
				 try {
					System.out.println("x:" + i + " y: " + j);
					actions.moveByOffset(i, j).click().perform();
				} catch (Exception e) {
					System.out.println("out of canvas");
				}
				 try {
					if (driver.findElement(By.className("selectBpDpHeading")).isDisplayed()) {
						 System.out.println("Found the empty seat");
						 return;
					 }
				} catch (Exception e) {
					System.out.println("Set not selected yet"); 
					sleep(1000);
				}
			 }
		}
	
	}

}
