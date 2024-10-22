package loginPageTestScenarios;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.crm.baseclass.VtigerOpenLoginPage;

public class ElementsDisplayed extends VtigerOpenLoginPage {
	
	
	@Test
	public void verifyOutlook() {
		assertEquals(ref.outlookPlugin.isDisplayed(), true);
	}
	
}
