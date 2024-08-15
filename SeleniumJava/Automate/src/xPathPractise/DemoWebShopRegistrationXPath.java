package xPathPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShopRegistrationXPath {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String dwsURL = "https://demowebshop.tricentis.com/";
        driver.get(dwsURL);

        if (driver.getCurrentUrl().equals(dwsURL)) {
            System.out.println("I in DWS page");
            Thread.sleep(2000);

            // locating register using CSSSelector

            driver.findElement(By.cssSelector("a[class='ico-register']")).click();
            String registerURL = "https://demowebshop.tricentis.com/register";

            if (driver.getCurrentUrl().equals(registerURL)) {
                System.out.println("I M on register page");

                // Wait and fill the details
                Thread.sleep(3000);
                fillRegistration(driver);

                // click on register.
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("input[value='Register']")).click();
                Thread.sleep(5000);
                driver.close();
            }

        } else {
            System.out.println("CHeck URL and try again");
            driver.close();
        }

    }

    public static void fillRegistration(ChromeDriver driver) throws InterruptedException {
        // Filling registration details.
        driver.findElement(By.xpath("//*[@id='gender-male']")).click();
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("RandomFirstName");
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("RandomLastName");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc@xyz.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("secretPass");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("secretPass");

    }

}
