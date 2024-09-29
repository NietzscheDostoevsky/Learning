package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;

import utilityClasses.BaseClassDWS;

public class WindowMethods extends BaseClassDWS {
	
	public static void main(String[] args) {
		useChrome();
		String script = """
				window.alert("This is an alert");
				""";
		((JavascriptExecutor) driver).executeScript(script);
		sleep(2000);
		driver.switchTo().alert().accept();
		
	}
}
