package multipleSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Write a script for demo webshop.
 *      ✅ Open the browser.
 *      ✅ Maximize the browser.
 *      ✅ Enter into DWS.
 *      ✅ Verify the page using title.
 *      ✅ Click the digital download menu bar.
 *      ✅ Add all 3 mentioned products to cart, by using find elements.
 *          Remove the costlises product from the shopping cart
 *      ✅ Click checkbox
 *      ✅Click update shopping cart.
 */

public class DWSGiftCardRemoveHighest {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String dwsURL = "https://demowebshop.tricentis.com/";
        driver.get(dwsURL);

        String expectedTitle = "Demo Web Shop";

        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Page verified by title ✅");
            System.out.println("I am on DWS homepage");
            Thread.sleep(1000);
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

            //navigate to shopping cart webpage
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='topcartlink']/a/span[1]")).click();
            Thread.sleep(1000);

            // finding the maximum price for elementn in cart

            WebElement shoppingCart = driver.findElement(By.tagName("tbody"));
            List<WebElement> cartItems = driver.findElements(By.className("cart-item-row"));
            ArrayList<Double> priceList = new ArrayList<Double>();
            for (WebElement item: cartItems) {
                Double price = Double.parseDouble(item.findElement(By.className("product-unit-price")).getText());
                priceList.add(price);
            }
            priceList.sort((o1, o2) -> o2.compareTo(o1));
            Double maxPrice = priceList.getFirst();
            System.out.println("Maximum price : " + maxPrice);

            // finding the item associated with maximum price and marking it for removal
            for (WebElement item: cartItems) {
                Double price = Double.parseDouble(item.findElement(By.className("product-unit-price")).getText());
                if (price.equals(maxPrice)){
                    // click on checkbox
                    item.findElement(By.tagName("input")).click();
                    Thread.sleep(3000);
                }
            }

            System.out.println("Clicked on maximum price remove checkbox ✅");

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
