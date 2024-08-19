package multipleSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

/**
 * Write a script for demo webshop.
 *      ✅ Open the browser.
 *      ✅ Maximize the browser.
 *      ✅ Enter into DWS.
 *      ✅ Verify the page using title.
 *      ✅ Click the digital download menu bar.
 *      ✅ Add all 3 mentioned products to cart, by using find elements.
 *      ✅ Remove all three products from the shopping cart.
 *      ✅ Click checkbox
 *      ✅Click update shopping cart.
 */

public class DWSAddDeleteCart {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String dwsURL = "https://demowebshop.tricentis.com/";
        driver.get(dwsURL);

        String expectedTitle = "Demo Web Shop";

        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Page verified by title ✅");
            System.out.println("I am on DWS homepage");
            Thread.sleep(3000);
            // click on digital download menu bar
            driver
                    .findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[5]/a"))
                    .click();
            System.out.println("Digital downloads ✅ ");

            Thread.sleep(2000);
            // finding and adding all 3 mentioned products to cart
            List<WebElement> items = driver.findElements(By.xpath("//div[@class='item-box']"));
            for (WebElement item : items) {
                item.findElement(By.tagName("input")).click();
                Thread.sleep(1500);
            }
            System.out.println("Added all 3 times to cart ✅");

            // remove all three items from cart

            //navigate to shopping cart webpage
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='topcartlink']/a/span[1]")).click();
            Thread.sleep(3000);
            //finding and clicking remove checkboxes
            List<WebElement> cartRemove = driver.findElements(By.className("remove-from-cart"));
            System.out.println("Total items in cart to remove: " + cartRemove.size());
            // clicking the remove checkbox
            for (WebElement checkbox: cartRemove) {
                checkbox.findElement(By.tagName("input")).click();
                Thread.sleep(1000);
            }
            System.out.println("Clicked on all remove checkboxes ✅");

            // clicking on update shopping cart
            driver.findElement(By.name("updatecart")).click();
            System.out.println("Shopping cart updated ✅");
            Thread.sleep(5000);
            driver.close();

        } else {
            System.out.println("Not on DWS page");
            System.out.println("Check your URL");
            Thread.sleep(3000);
            driver.close();
        }

    }
}
