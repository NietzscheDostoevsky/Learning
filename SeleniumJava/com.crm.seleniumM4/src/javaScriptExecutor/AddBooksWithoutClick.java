package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

import utilityClasses.BaseClassDWS;

public class AddBooksWithoutClick extends BaseClassDWS {
	public static void main(String[] args) {
		useChrome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demowebshop.tricentis.com/books");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String  script = """
				AjaxCart.addproducttocart_catalog('/addproducttocart/catalog/13/1/1    ');
				return false;
				""";
		jsExecutor.executeScript(script);
		sleep(1000);
		driver.get("https://demowebshop.tricentis.com/cart");
	}
}
