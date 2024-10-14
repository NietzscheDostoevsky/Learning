package testNg;

import org.testng.ITestNGMethod;
import org.testng.Reporter;
import org.testng.annotations.*;

public class ChronologicalOrder3 {
    @BeforeSuite
    @BeforeTest
    @BeforeClass
    @BeforeMethod
    @Test
    @AfterMethod
    @AfterClass
    @AfterTest
    @AfterSuite
    public void afterSuite() {
        ITestNGMethod method = Reporter.getCurrentTestResult().getMethod();
        if (method.isBeforeSuiteConfiguration()) {
            System.err.println("Before <suite> mode");
        }
        if (method.isBeforeTestConfiguration()) {
            System.err.println("Before <test> mode");
        }
        if (method.isBeforeClassConfiguration()) {
            System.err.println("Before class mode");
        }
        if (method.isAfterClassConfiguration()) {
            System.err.println("After class mode");
        }
        if (method.isBeforeMethodConfiguration()) {
            System.err.println("Before method mode");
        }
        if (method.isTest()) {
            System.err.println("Test case mode");
        }
        if (method.isAfterMethodConfiguration()) {
            System.err.println("After method mode");
        }
        if (method.isAfterTestConfiguration()) {
            System.err.println("After <test> mode");
        }
        if (method.isAfterSuiteConfiguration()) {
            System.err.println("After <suite> mode");
        }
    }
}