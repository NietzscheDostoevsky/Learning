package loginPageTestScenarios;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import com.crm.baseclass.VtigerOpenLoginPage;

public class FollowUsLinksVerify extends VtigerOpenLoginPage {

	// Verify contact us links in the login page if they are navigating
	// to the correct url or not.

	@Test
	public void verifyFacebookPageLink() {
		String parentWindow = driver.getWindowHandle();
		ref.facebookPage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("facebook.com/vtiger/"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyTwitterLink() {
		String parentWindow = driver.getWindowHandle();
		ref.TwitterPage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("twitter.com") || 
				driver.getCurrentUrl().contains("x.com"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyLinkedinLink() {
		String parentWindow = driver.getWindowHandle();
		ref.LinkedinPage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("linkedin.com"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyYoutubeLink() {
		String parentWindow = driver.getWindowHandle();
		ref.YoutubePage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("youtube.com/user/vtigercrm"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyVtigerWikiLink() {
		String parentWindow = driver.getWindowHandle();
		ref.VtigerWikiPage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("wiki.vtiger.com/"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyVtigerForumLink() {
		String parentWindow = driver.getWindowHandle();
		ref.VtigerForumPage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("discussions.vtiger.com/"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyVtigerBlogLink() {
		String parentWindow = driver.getWindowHandle();
		ref.VtigerBlogPage.click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		assertEquals(driver.getCurrentUrl().contains("vtiger.com/"), true);
		driver.close();
		driver.switchTo().window(parentWindow);
	}
}
