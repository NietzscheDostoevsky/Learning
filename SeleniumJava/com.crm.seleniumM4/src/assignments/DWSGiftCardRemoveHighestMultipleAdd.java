package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a script for demo webshop.
 *      ✅ Open the browser.
 *      ✅ Maximize the browser.
 *      ✅ Enter into DWS.
 *      ✅ Verify the page using title.
 *      ✅ Click the digital download menu bar.
 *      ✅ Add all 3 mentioned products to cart, by using find elements.
 *          Add more elements from different pages.
 *          Remove the costlises product from the shopping cart
 *      ✅ Click checkbox
 *      ✅Click update shopping cart.
 */

public class DWSGiftCardRemoveHighestMultipleAdd {
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
            driver.get("https://demowebshop.tricentis.com/books");
            Thread.sleep(2000);
            addToCart(driver);

            Thread.sleep(1000);
            driver.get("https://demowebshop.tricentis.com/cart");
            Thread.sleep(3000);
            removeCostliestItem(driver);

            driver.get("https://demowebshop.tricentis.com/digital-downloads");
            Thread.sleep(2000);
            addToCart(driver);

            //navigate to shopping cart webpage
            Thread.sleep(1000);
            driver.get("https://demowebshop.tricentis.com/cart");
            Thread.sleep(3000);

            removeCostliestItem(driver);

            Thread.sleep(5000);
            driver.close();

        } else {
            System.out.println("Not on DWS page");
            System.out.println("Check your URL");
            Thread.sleep(3000);
            driver.close();
        }

    }

    private static void addToCart(ChromeDriver driver) throws InterruptedException {
        // finding and adding all mentioned products to cart
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='item-box']"));
        for (WebElement item : items) {
            try {
                item.findElement(By.tagName("input")).click();
            } catch (Exception e) {
                continue;
            }
            Thread.sleep(1500);
        }
        System.out.println("Added all times to cart ✅");
    }

    private static void removeCostliestItem(ChromeDriver driver) throws InterruptedException {
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
        Thread.sleep(5000);
        driver.findElement(By.name("updatecart")).click();
        System.out.println("Shopping cart updated ✅");
    }
}