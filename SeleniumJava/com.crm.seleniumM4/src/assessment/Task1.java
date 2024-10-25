package assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Task1 extends DWSBaseClass {

	public static void main(String[] args) {
		createDriver("chrome");
		dwsLogin();

		Actions action = new Actions(driver);
		action.keyDown(Keys.PAGE_DOWN).perform();
		driver.findElement(By.xpath("(//input[@type='button'])[3]")).click();
		driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys("name");
		driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys("name@gmail.com");
		driver.findElement(By.id("giftcard_2_SenderName")).sendKeys("name2");
		driver.findElement(By.id("giftcard_2_SenderEmail")).sendKeys("name2@gmail.com");
		driver.findElement(By.id("giftcard_2_Message")).sendKeys("mesasge");
		driver.findElement(By.id("addtocart_2_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_2_EnteredQuantity")).sendKeys("2");
		driver.findElement(By.id("add-to-cart-button-2")).click();

		// verify successfully added

		driver.findElement(By.xpath("//a[@class=\"ico-cart\"]")).click();
		String productName = driver.findElement(By.xpath("//a[@class=\"product-name\"]")).getText();
		System.out.println(productName);
		if(productName.contains("25"))
			System.out.println("product verified");
		dwsLogout();
		postCondition();
	}
}
