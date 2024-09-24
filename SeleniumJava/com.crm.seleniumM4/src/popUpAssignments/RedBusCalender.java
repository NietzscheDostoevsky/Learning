package popUpAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[@for='bt_SEATER'])[1]")));
		driver.findElement(By.xpath("(//label[@for='bt_SEATER'])[1]")).click(); sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='bus-items']/div)[1]/li/div/div[2]/div")).click(); sleep(3000);
		
		//find canvas of the lower deck, with seaters only. 
		WebElement canvas = driver.findElement(By.xpath("//canvas[@data-type='lower']")); 
		
		selectSeat(canvas, driver);  sleep(1000);
		
		// Select arrival and destination. 
		driver.findElement(By.xpath("(//ul[@data-value='bp']/li)[1]/div/div")).click(); sleep(1000);
		driver.findElement(By.xpath("(//ul[@data-value='dp']/li)[1]/div/div")).click(); sleep(1000);
		driver.findElement(By.xpath("//button[@class='button continue inactive']")).click();		
		
	}
	
	/*
	 * Select a seat on the bus, and if any seat is selected, returns the control back. 
	 */
	private static void selectSeat(WebElement canvas, WebDriver driver) {
	    Actions actions = new Actions(driver);
	    
	    // Calculate the width and height of the canvas
	    int canvasWidth = canvas.getSize().getWidth();
	    int canvasHeight = canvas.getSize().getHeight();
	    
	    // Find the center of the canvas
	    int x0 = canvasWidth / 2;
	    int y0 = canvasHeight / 2;
	    
	    // Calculate deltas (dividing the canvas into grid parts)
	    int deltaX = canvasWidth / 12;
	    int deltaY = canvasHeight / 4;

	    // Calculate the starting position (first quadrant)
	    int initialX = x0 - (5 * deltaX) - (deltaX / 2);
	    int initialY = y0 - (1 * deltaY) - (deltaY / 2);

	    System.out.println("Width: " + canvasWidth);
	    System.out.println("Height: " + canvasHeight);
	    System.out.println("DeltaX: " + deltaX);
	    System.out.println("DeltaY: " + deltaY);
	    System.out.println("InitialX: " + initialX);
	    System.out.println("InitialY: " + initialY);

	    // Move to the initial position (absolute coordinates from the center)
	    actions.moveToElement(canvas, initialX - x0, initialY - y0).perform();

	    // Loop over the canvas grid
	    for (int j = initialY; j < canvasHeight; j += deltaY) {
	        for (int i = initialX; i < canvasWidth; i += deltaX) {
	            try {
	                System.out.println("x: " + i + " y: " + j);
	                actions.moveByOffset(deltaX, deltaY).click().perform(); // Relative move within the loop
	            } catch (Exception e) {
	                System.out.println("Out of canvas");
	            }

	            // Check if the seat is selected
	            try {
	                if (driver.findElement(By.className("selectBpDpHeading")).isDisplayed()) {
	                    System.out.println("Found the empty seat");
	                    return;
	                }
	            } catch (Exception e) {
	                System.out.println("Seat not selected yet");
	            
	            }
	        }
	    }
	}

}
