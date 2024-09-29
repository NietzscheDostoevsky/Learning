package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeCount {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		String url ;
		if (System.getProperty("os.name").equals("Linux"))
			url =  "file:///home/saurabh-singh/Documents/GitHub/Learning/SeleniumJava/com.crm.seleniumM4/testdata/iframe.html";
		else 
			url = "file:///C:/GitHub/Learning/SeleniumJava/com.crm.seleniumM4/testdata/iframe.html";
		driver.get(url);
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		//var iframeLen =  js.executeScript("window.length");
		Long iframeLen = (Long) js.executeScript("return document.getElementsByTagName('iframe').length;");
		System.out.println(iframeLen.getClass().getName());
		System.out.println(iframeLen);
		
	}
}
