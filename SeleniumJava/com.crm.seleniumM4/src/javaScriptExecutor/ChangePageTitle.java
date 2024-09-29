package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;

import utilityClasses.BaseClassDWS;

public class ChangePageTitle extends BaseClassDWS {
	public static void main(String[] args) {
		useChrome();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script;
		System.out.println(driver.getTitle());
		script = "document.title = 'Saurabhs Page';";
		js.executeScript(script);
		System.out.println(driver.getTitle());
	}
}
