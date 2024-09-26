package takeScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import utilityClasses.BaseClassDWS;

public class WebPage extends BaseClassDWS {
    public static void main(String[] args) {
        useChrome();

        driver.findElement(By.id("small-searchterms")).sendKeys("iPhone");
        sleep(3000);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File fromFile = ts.getScreenshotAs(OutputType.FILE);

        // Get project directory dynamically and construct the path for screenshot
        String projectDir = System.getProperty("user.dir");
        Path screenshotPath = Paths.get(projectDir, "ScreenShots", "DWSHomePage.png");

        // Create the screenshot directory if it does not exist
        File screenshotDir = screenshotPath.getParent().toFile();
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs(); // Create directories
        }

        // Save the screenshot to the desired location
        File toFile = screenshotPath.toFile();
        try {
            FileHandler.copy(fromFile, toFile);
            System.out.println("Screenshot saved at: " + screenshotPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sleep(2000);
        driver.quit();
    }
}
