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
            System.out.println("Fabook Opened");
            Thread.sleep(5000);
            driver.findElement(By.id("email")).sendKeys("Saurabh");
            Thread.sleep(5000);
            WebElement password = driver.findElement(By.id("pass"));
            Thread.sleep(5000);
            password.sendKeys("fakePassword");
            Thread.sleep(5000);

            driver.findElement(By.name("login")).click();



        }
        else {
            System.out.println("Change your URL");

        }
        Thread.sleep(5000);
        driver.close();


    }
}

