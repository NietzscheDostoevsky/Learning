package selectClassAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceboolRegistrationDropdown {
	
	    public static void main(String[] args) throws InterruptedException {
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        String fbURL = "https://www.facebook.com/";
	        driver.get(fbURL);

	        if(driver.getCurrentUrl().equals(fbURL)) {
	            System.out.println("Facebook Opened");

	            // Click on Create new account
	            driver.findElement(By.linkText("Create new account")).click();

	            // Wait 3 seconds
	            Thread.sleep(3000);

	            // Fill registration details
	            fillFacebookRegistration(driver);

	            // Wait 7 seconds and close the browser .
	            Thread.sleep(7000);
	            driver.close();
	        }
	        else {
	            System.out.println("Change your URL");
	        }
	        Thread.sleep(5000);
	        driver.close();
	    }

	    private static void fillFacebookRegistration(ChromeDriver driver) throws InterruptedException {
	        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("FakeFirstName");
	        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("FakeLastName");
	        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("abc@xyz.com");
	        //wait 2 seconds for re-enter prompt to appear
	        Thread.sleep(2000);
	        //driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys("abc@xyz.com");
	        driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys("fakePass");

	        // find gender button by xpath and click on it.
	        String buttonPath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input";
	        driver.findElement(By.xpath(buttonPath)).click();

	        // Add dob using Select Class. 
	        
	        Select day = new Select(driver.findElement(By.id("day")));
	        day.selectByValue("3");
	        Thread.sleep(2000);
	        Select month = new Select(driver.findElement(By.id("month")));
	        month.selectByValue("3");
	        Thread.sleep(2000);
	        Select year = new Select(driver.findElement(By.id("year")));
	        year.selectByValue("1973");
	        

	        // Wait 2 seconds and click on register button .
	        Thread.sleep(2000);

	        //dON'T CLIKC, form is not completely filled. 
	        //driver.findElement(By.cssSelector("button[name='websubmit']")).click();
	    }
	}
