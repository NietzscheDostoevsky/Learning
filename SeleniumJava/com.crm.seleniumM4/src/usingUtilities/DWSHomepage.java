package usingUtilities;

import utilityClasses.BaseClassDWS;

public class DWSHomepage extends BaseClassDWS {

	public static void main(String[] args) {
		
		useFirefox();
		
		String expectedURL = "https://demowebshop.tricentis.com/";
		if (expectedURL.equals(driver.getCurrentUrl())){
				System.out.println("I am on DWS page");
		} else {
			System.out.println("Wrong Homepage");
			postCondition1();
		}
		
		postCondition1();
	}

}
