package xPathPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Write a script for Qsp demo site.
 * Open and maximize the browser
 * Enter into qsp demo site.
 * Verify that page.
 * Click UI testing concepts.
 * Verify this page.
 * Click the webelemets section.
 * Click the textbox
 * Fill all the details for "with placeholder section"
 */

public class QSPDemoSiteTextbox {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String demoQSPUrl = "https://demoapps.qspiders.com/";
        driver.get(demoQSPUrl);

        if(driver.getCurrentUrl().equals(demoQSPUrl)) {
            System.out.println("On QSP demoapps website");
            // Wait for 20 seconds because website is too slow to load.
            Thread.sleep(10000);
            driver.findElement(By.xpath("//*[@id=\"optionsBody\"]/a[1]/div")).click();

            String UIUrl = "https://demoapps.qspiders.com/ui";

            if (UIUrl.equals(driver.getCurrentUrl())) {
                System.out.println("On the UI site");

                //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/div/div[2]/div/ul/li[1]/section[1]")).click();
                //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/div/div[2]/div/ul/div[1]/ul/li[1]/a/section[1]")).click();
                driver.findElement(By.id("name")).sendKeys("Haha");
               // driver.findElement(By.id("name")).sendKeys("FakeName");
               // driver.findElement(By.id("email")).sendKeys("Fakeemail@xyz.com");
               // driver.findElement(By.id("password")).sendKeys("FakePass");

            } else {
                System.out.println("Not clicked. Check again");
            }

        }
        System.out.println("Check URL again");
    }
}
