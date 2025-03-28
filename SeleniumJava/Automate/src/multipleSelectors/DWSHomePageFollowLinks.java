package multipleSelectors;

/**
 * Write a script for DWS
 * Open the browser
 * Maximize
 * Verify thw homepage using webelement.
 * Click register, login, shopping cart, wishlist by using find elements.
 * Click facebook, rss, Twitter, YouTube, google+
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DWSHomePageFollowLinks {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String webShopURL = "https://demowebshop.tricentis.com/";
        driver.get(webShopURL);
        WebElement poll = driver.findElement(By.xpath("//strong[text()='Community poll']"));

        if(poll.isDisplayed()) {
            System.out.println("I am on dws page");

            WebElement followLinks = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[4]"));

            List<WebElement> links = followLinks.findElements(By.tagName("a"));

            // Escaping the rss page
            String rss = "https://demowebshop.tricentis.com/news/rss/1";

            for (WebElement ele : links) {
                ele.click();
                Thread.sleep(2000);

                // Escape the rss page.
                if(driver.getCurrentUrl().equals(rss))
                    driver.navigate().back();

            }
            Thread.sleep(5000);
            driver.close();

        } else {
            System.out.println("I am not on dws page");
        }

        Thread.sleep(5000);
    }
}
