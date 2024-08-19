package multipleSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Write the script for demo web shop
 *      ✅ Open the browser.
 *      ✅ Maximize the browser.
 *      ✅ Enter into DWS.
 *      ✅ Verify the page by using URL.
 *      ✅ After verification, click the gift card section.
 *      ✅ Add the product which is having $5.
 *      ✅ Fill all the details on that page.
 *      ✅ Change the quantity to 3
 *      ✅ Click add to cart.
 *      ✅ Check if the product is added successfully or not.
 *      ✅ Close the browser.
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
            Thread.sleep(3000);
            driver
                    .findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[7]/a"))
                    .click();
            List<WebElement> giftCards = driver.findElements(By.xpath("//div[@class='product-grid']/div"));
            System.out.println(giftCards.size()); // should be 4

            elementLoop:
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
                    Thread.sleep(3000);

                    // fill the giftcard details.
                    fillBuyingDetails(driver);
                    Thread.sleep(3000);

                    // Click add to cart on giftcard.
                    driver.findElement(By.xpath("//input[@id='add-to-cart-button-1']")).click();
                    Thread.sleep(3000);

                    // Checking if added to cart or not.
                    driver.findElement(By.xpath("//*[@id='topcartlink']/a/span[1]")).click();
                    Thread.sleep(3000);
                    String productName = "$5 Virtual Gift Card";
                    String cartProductName = driver.findElement(By.xpath("//td[@class='product']/a")).getText();
                    if (productName.equals(cartProductName))
                        System.out.println("Product cart addition verified");
                    break elementLoop;
                }
            }
            Thread.sleep(3000);
            driver.close();

        } else {
            System.out.println("Not on DWS homepage, check URL");
            driver.close();
        }

    }

    private static void fillBuyingDetails(ChromeDriver driver) {
        driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys("fake Recipient Name");
        driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys("fake@recipient.email");
        driver.findElement(By.id("giftcard_1_SenderName")).sendKeys("fake Sender Name");
        driver.findElement(By.id("giftcard_1_SenderEmail")).sendKeys("fake@sender.email");
        driver.findElement(By.id("giftcard_1_Message")).sendKeys("fake Message to send");
        driver.findElement(By.id("addtocart_1_EnteredQuantity")).clear();
        driver.findElement(By.id("addtocart_1_EnteredQuantity")).sendKeys("3");
    }
}