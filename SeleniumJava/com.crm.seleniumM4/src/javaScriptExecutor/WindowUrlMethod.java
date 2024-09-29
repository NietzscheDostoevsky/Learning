package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;

import utilityClasses.BaseClassDWS;

public class WindowUrlMethod extends BaseClassDWS {
	public static void main(String[] args) {
		useChrome();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script;
		
		script = "return window.location.href;";
		System.out.println((String) js.executeScript(script));
		System.out.println(driver.getCurrentUrl());
	}
}
