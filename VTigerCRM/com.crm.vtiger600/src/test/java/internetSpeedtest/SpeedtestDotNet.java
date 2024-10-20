package internetSpeedtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpeedtestDotNet {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.speedtest.net/");
			driver.findElement(By.xpath("//a[@aria-label='start speed test - connection type multi']")).click();
			System.out.println("Speedtest Started");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-result-id='true']")));
			System.out.println("Speedtest Completed");
			System.out.println();
			System.out.println("-----RESULTS------");
			System.out.println(
					"Upload ping    : " + driver.findElement(By.cssSelector("[title='Upload Latency']")).getText());
			System.out.println(
					"Upload Speed   : " + driver.findElement(By.xpath("//span[@data-upload-status-value]")).getText());
			System.out.println(
					"Download ping  : " + driver.findElement(By.cssSelector("[title='Download Latency']")).getText());
			System.out.println(
					"Download Speed : " + driver.findElement(By.xpath("//span[@data-download-status-value]")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}
}
