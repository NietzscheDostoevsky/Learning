package loginPageTestScenarios;

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
		ref.loginTextfield.sendKeys(username);
		ref.passwordTextfield.sendKeys(password);
		ref.loginButton.click();
		assertEquals(driver.getCurrentUrl().contains("Home"), false);
	}

	@DataProvider(name = "PositiveLogin")
	public Object[][] positiveSender() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = "admin";
		obj[0][1] = "root";

		return obj;
	}

	@DataProvider(name = "NegativeLogin")
	public Object[][] negativeSender() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = "pewpew";
		obj[0][1] = "haha";

		return obj;
	}
}
