package com.crm.DWSPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWSLogin {
	@FindBy(id = "Email")
	public WebElement email;

	@FindBy(name = "Password")
	public WebElement password;

	@FindBy(css = "input[value='Log in']")
	public WebElement loginButton;

	public DWSLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
