package cet2025;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculateMarks {

	static String marksPagePath = "src/test/resources/marksWebpage/Assessment - Objection Tracker Portal_ Response Sheet.html";

	static ChromeDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		File file = new File(marksPagePath);
		String marksPageURL = "file://" + file.getAbsolutePath();
		driver.get(marksPageURL);

		WebElement outerTablElement = driver.findElement(By.id("tblObjection"));
		List<WebElement> allQuestions = outerTablElement.findElements(By.className("table-responsive"));
		System.out.println("Total questions found: " + allQuestions.size());

		int totalCorrect = 0;

		for (WebElement questionBlock : allQuestions) {
			String correctOption = "";
			String candidateResponse = "";

			List<WebElement> tds = questionBlock.findElements(By.tagName("td"));
			for (WebElement td : tds) {
				String label = td.findElement(By.tagName("b")).getText();
				String value = td.findElement(By.tagName("span")).getText().trim();

				if (label.contains("Correct Option")) {
					correctOption = value;
				} else if (label.contains("Candidate Response")) {
					candidateResponse = value;
				}
			}

			// Compare
			if (!correctOption.isEmpty() && correctOption.equals(candidateResponse)) {
				totalCorrect++;
			}
		}

		System.out.println("Total Correct Answers: " + totalCorrect);
		System.out.println("Total Marks (assuming +1 per correct): " + totalCorrect);
		
		driver.quit();
	}
}
