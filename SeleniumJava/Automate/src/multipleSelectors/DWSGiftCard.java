package multipleSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Write the script for demo web shop
 *      Open the browser.
 *      Maximize the browser.
 *      Enter into DWS.
 *      Verify the page by using URL.
 *      After verification, click the gift card section.
 *      Add the product which is having $5.
 *      Fill all the details on that page.
 *      Change the quantity to 3
 *      Click add to cart.
 *      Check if the product is added successfully or not.
 *      Close the browser.
 */

public class DWSGiftCard {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String dwsURL = "https://demowebshop.tricentis.com/";
        driver.get(dwsURL);

        if (driver.getCurrentUrl().equals(dwsURL)) {
            System.out.println("I am on DWS homepage");

            // Clicking the gift card section
            Thread.sleep(2000);
            driver
                    .findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[7]/a"))
                    .click();
            List<WebElement> giftCards = driver.findElements(By.xpath("//div[@class='product-grid']/div"));
            System.out.println(giftCards.size()); // should be 4

            for (WebElement giftcard : giftCards) {
                // The below is commented out since there were multiple class names.
                // It would work, but discouraged.
                //String price = giftcard.findElement(By.className("actual-price")).getText();

                // Found the price.
                String price = giftcard.findElement(By.tagName("span")).getText();
                System.out.println("Price found: " + price);
                String findPrice = "5.00";
                if (price.equals(findPrice)) {
                    System.out.println("Price selected: " + findPrice);

                    // click on add to card
                    giftcard.findElement(By.tagName("input")).click();
                    Thread.sleep(2000);
                    fillBuyingDetails(ChromeDriver driver);
                    Thread.sleep(3000);
                }
            }



        } else {
            System.out.println("Not on DWS homepage, check URL");
        }
    }
}
