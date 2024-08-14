package xPathPractise;

/*
Assignment :
Write a script for facebook
Open the browser.
Maximize the browser.
Enter into the fb landing page.
Verify the landing page.
Click the create new account button.
Fill all the details, except dropdown.
Use any locators.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookRegistration {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String fbURL = "https://www.facebook.com/";
        driver.get(fbURL);

        // verification and continue
        if(driver.getCurrentUrl().equals(fbURL)) {
            System.out.println("Facebook Opened");

            // Click on Create new account
            driver.findElement(By.linkText("Create new account")).click();

            // Wait 3 seconds
            Thread.sleep(3000);

            // Fill registration details
            fillFacebookRegistration(driver);

            // Wait 7 seconds and close the broweser .
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
        //wait 2 secs for re-enter prompt to appar
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys("abc@xyz.com");
        driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys("fakePass");

        // find gender button by xpath and click on it.
        String buttonPath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input";
        driver.findElement(By.xpath(buttonPath)).click();

        // Wait 2 seconds and click on register butotn .
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[name='websubmit']")).click();
    }
}

