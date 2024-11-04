package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 	Ø QSP demo website.
 * 		 Click UI testing
 * 		 Go to web element section
 * 		 Go to button
 * 		 Perform default click
 * 		   Can use Any locators .
 *
 */

public class QSPDemoUIButton {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String demoQSPUrl = "https://demoapps.qspiders.com/";
        driver.get(demoQSPUrl);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"optionsBody\"]/a[1]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/div/div[2]/div/ul/div[1]/ul/li[2]/a/section[1]")).click();
        Thread.sleep(3000);
        WebElement buttons = driver.findElement(By.xpath("//*[@id=\"demoUI\"]/main/section/article/aside/div/aside/div/section/section/section"));
        buttons.findElement(By.xpath("//article[1]/button")).click();
        buttons.findElement(By.xpath("//article[2]/button")).click();
        buttons.findElement(By.xpath("//article[3]/button")).click();

    }
}
