package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Login functionality
	@FindBy(name = "user_name")
	public WebElement loginTextfield;
	
	@FindBy(name = "user_password")
	public WebElement passwordTextfield;
	
	@FindBy(id = "submitButton")
	public WebElement loginButton;
	
	// Get more out of links
	@FindBy(xpath = "//img[@alt='Outlook Plugin']/..")
	public WebElement outlookPlugin;
		
	@FindBy(xpath = "//img[@alt='Exchange Connector']/..")
	public WebElement exchangeConnector;
	
	@FindBy(xpath = "//img[@alt='vtiger iPhone Application']/..")
	public WebElement iPhoneAppLink;
	
	@FindBy(xpath = "//img[@alt='vtiger Android Application']/..")
	public WebElement androidAppLink;
	
	//Connect with us links
	
	@FindBy(xpath = "//img[@alt='Facebook']/.." )
	public WebElement facebookPage; 
	
	@FindBy(xpath = "//img[@alt='Twitter']/.." )
	public WebElement TwitterPage; 
	
	@FindBy(xpath = "//img[@alt='Linkedin']/.." )
	public WebElement LinkedinPage; 
	
	@FindBy(xpath = "//img[@alt='Videos']/.." )
	public WebElement YoutubePage; 
	
	@FindBy(xpath = "//img[@alt='Manuals']/.." )
	public WebElement VtigerWikiPage; 
	
	@FindBy(xpath = "//img[@alt='Forums']/.." )
	public WebElement VtigerForumPage; 
	
	@FindBy(xpath = "//img[@alt='Blogs']/.." )
	public WebElement VtigerBlogPage; 
	
	//Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}