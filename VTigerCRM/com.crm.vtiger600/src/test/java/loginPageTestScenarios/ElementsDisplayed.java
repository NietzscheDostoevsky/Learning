package loginPageTestScenarios;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.crm.baseclass.VtigerOpenLoginPage;

public class ElementsDisplayed extends VtigerOpenLoginPage {
	
	
	@Test
	public void verifyOutlook() {
		assertEquals(ref.outlookPlugin.isDisplayed(), true);
	}
	
	@Test
	public void verifyExchangeConnector() {
		assertEquals(ref.exchangeConnector.isDisplayed(), true);
	}
	
	@Test
	public void verifyIPhoneAppLink() {
		assertEquals(ref.iPhoneAppLink.isDisplayed(), true);
	}
	
	@Test 
	public void verifyAndroidAppLink() {
		assertEquals(ref.androidAppLink.isDisplayed(), true);
	}
	
	@Test
	public void verifyFacebookPageLink() {
		assertEquals(ref.facebookPage.isDisplayed(), true); 
	}
	
	@Test
	public void verifyTwitterLink() {
		assertEquals(ref.TwitterPage.isDisplayed(), true);
	}
	@Test
	public void verifyLinkedinLink(){
		assertEquals(ref.LinkedinPage.isDisplayed(), true);
	}
	@Test
	public void verifyYoutubeLink() {
		assertEquals(ref.YoutubePage.isDisplayed(), true);
	}
	@Test
	public void verifyVtigerWikiLink() {
		assertEquals(ref.VtigerWikiPage.isDisplayed(), true);
	}
	@Test
	public void  verifyVtigerForumLink(){
		assertEquals(ref.VtigerForumPage, true);
	}
	@Test
	public void verifyVtigerBlogLink(){
		assertEquals(ref.VtigerBlogPage, true);
	}
}
