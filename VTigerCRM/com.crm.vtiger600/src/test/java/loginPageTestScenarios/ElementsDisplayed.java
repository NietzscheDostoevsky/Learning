package loginPageTestScenarios;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.crm.baseclass.VtigerOpenLoginPage;

public class ElementsDisplayed extends VtigerOpenLoginPage {
	
	
	@Test
	public void verifyOutlookElement() {
		assertEquals(ref.outlookPlugin.isDisplayed(), true);
	}
	
	@Test
	public void verifyExchangeConnectorElement() {
		assertEquals(ref.exchangeConnector.isDisplayed(), true);
	}
	
	@Test
	public void verifyIPhoneAppLinkElement() {
		assertEquals(ref.iPhoneAppLink.isDisplayed(), true);
	}
	
	@Test 
	public void verifyAndroidAppLinkElement() {
		assertEquals(ref.androidAppLink.isDisplayed(), true);
	}
	
	@Test
	public void verifyFacebookPageLinkElement() {
		assertEquals(ref.facebookPage.isDisplayed(), true); 
	}
	
	@Test
	public void verifyTwitterLinkElement() {
		assertEquals(ref.TwitterPage.isDisplayed(), true);
	}
	@Test
	public void verifyLinkedinLinkElement(){
		assertEquals(ref.LinkedinPage.isDisplayed(), true);
	}
	@Test
	public void verifyYoutubeLinkElement() {
		assertEquals(ref.YoutubePage.isDisplayed(), true);
	}
	@Test
	public void verifyVtigerWikiLinkElement() {
		assertEquals(ref.VtigerWikiPage.isDisplayed(), true);
	}
	@Test
	public void  verifyVtigerForumLinkElement(){
		assertEquals(ref.VtigerForumPage.isDisplayed(), true);
	}
	@Test
	public void verifyVtigerBlogLinkElement(){
		assertEquals(ref.VtigerBlogPage.isDisplayed(), true);
	}
}
