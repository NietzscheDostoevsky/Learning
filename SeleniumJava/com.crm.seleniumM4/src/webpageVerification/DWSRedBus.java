package webpageVerification;

import org.openqa.selenium.chrome.ChromeDriver;

public class DWSRedBus {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver(); 
		
		String DWSURL = "https://demowebshop.tricentis.com/";
		String RedBusURL = "https://www.redbus.in/";
		
		String RedBusTitle = "Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus";
		
		driver.navigate().to(DWSURL);
		System.out.println(driver.getCurrentUrl().equals(DWSURL)?
				"URL Verified":"URL Not same");
		
		driver.get(RedBusURL); 
		System.out.println(driver.getTitle().equals(RedBusTitle)?
				"Title Verified":"Title Not same");
		
		driver.close();
	}

}
