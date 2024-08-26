package usingUtilities;

import utilityClasses.CrossBrowserTesting;

public class usingCrossBrowserTesting extends CrossBrowserTesting {

	public static void main(String[] args) {
		
		preCondition("eDGe");
		postCondition("quit");
	}
}