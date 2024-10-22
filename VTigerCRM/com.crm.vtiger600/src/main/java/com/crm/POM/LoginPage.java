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
	
	// Plugins
	@FindBy(id = "submitButton")
	public WebElement outlookPlugin;
		
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}