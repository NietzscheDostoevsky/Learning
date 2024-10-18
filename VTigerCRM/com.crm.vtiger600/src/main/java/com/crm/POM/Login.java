package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(name = "user_name")
	public WebElement loginTextfield;
	
	@FindBy(name = "user_password")
	public WebElement passwordTextfield;
	
	@FindBy(id = "submitButton")
	public WebElement loginButton;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
