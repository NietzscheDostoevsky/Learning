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
import org.openqa.selenium.WebElement;
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

            // Wait 5 seconds and close the broweser .
            Thread.sleep(5000);
            driver.close();


        }
        else {
            System.out.println("Change your URL");

        }
        Thread.sleep(5000);
        driver.close();


    }
}

