package bookMyShow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FrontPageDriver extends BaseClass {
	public static void main(String[] args) {
		useChrome();
		
		driver.findElement(By.xpath("//img[@alt='PUNE']")).click(); sleep(2000);
		List<WebElement> posters = driver.findElements(By.xpath("//*[@id='super-container']/div[2]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div"));
		
		posters.get(0).click(); sleep(2000);
		driver.findElement(By.id("page-cta-container")).click();
	}
}
