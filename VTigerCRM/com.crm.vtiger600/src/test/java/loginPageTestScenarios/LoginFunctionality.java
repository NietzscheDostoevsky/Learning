package loginPageTestScenarios;

import static com.crm.utility.LoginFunctionalityExcelFile.excel;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.baseclass.VtigerTestLoginFunctionBaseClass;

public class LoginFunctionality extends VtigerTestLoginFunctionBaseClass {

	@Test(dataProvider = "PositiveLogin")
	public void testLoginPositive(String username, String password) {
		ref.loginTextfield.sendKeys(username);
		ref.passwordTextfield.sendKeys(password);
		ref.loginButton.click();
		assertEquals(driver.getCurrentUrl().contains("Home"), true);
	}

	@Test(dataProvider = "NegativeLogin")
	public void testLoginNegative(String username, String password) {
		System.out.println("Testing with login details : " + username + " " + password);
		ref.loginTextfield.sendKeys(username);
		ref.passwordTextfield.sendKeys(password);
		ref.loginButton.click();
		assertEquals(driver.getCurrentUrl().contains("Home"), false);
	}

	@DataProvider(name = "PositiveLogin")
	public Object[][] positiveSender() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = excel(2, 7);
		obj[0][1] = excel(2, 8);

		return obj;
	}

	@DataProvider(name = "NegativeLogin")
	public Object[][] negativeSender() {
		int testcases = 7; 
		int startRow = 3; // 0 index
		int startCol = 7; // 0 index
		Object[][] obj = new Object[testcases][2];
		for (int i = 0; i <  testcases ; i++)
			for (int j = 0; j < 2 ; j++)
				obj[i][j] = excel(i + startRow, j + startCol); 

		return obj;
	}
}
