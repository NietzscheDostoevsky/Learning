package userProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenRedditWithProfile {
    public static void main(String[] args) {
        // Path to your custom Chrome profile
        String userProfile = "C:\\Users\\saura\\AppData\\Local\\Google\\Chrome\\User Data";

        // Set ChromeOptions to use your existing profile
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-software-rasterizer");

        // Initialize the ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to Reddit to test the profile reuse
        driver.get("https://www.reddit.com");

        // Quit the browser
        // driver.quit();
    }
}

