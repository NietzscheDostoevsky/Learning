package childBrowserPopUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxExample {
    public static void main(String[] args) {
    	
        // Set the path to the geckodriver executable
        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
        
        // Specify the correct path to the Firefox executable
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/usr/bin/firefox");
 

        // Launch Firefox with the correct options
        WebDriver driver = new FirefoxDriver(options);
        
        driver.get("https://www.facebook.com");
    }
}
