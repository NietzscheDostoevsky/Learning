package extentReportBasic;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {

	@Test
	public void sample() {
		// 1. create the extent spark reporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/sampleReport.html");

		// 2. configure extent spark reporter 
		spark.config().setDocumentTitle("Functinoal Testing");
		spark.config().setReportName("Saurabh");
		spark.config().setTheme(Theme.STANDARD);
		
		// 3. Create the extent report. 
		ExtentReports report = new ExtentReports();
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome 101");
		
		// 4. Attach the extent report to the spark report. 
		report.attachReporter(spark);
		
		// 5. create the testcase. 
		ExtentTest test = report.createTest("sample");
		
		// 6. flush the report.
		report.flush();
		
	}
}
