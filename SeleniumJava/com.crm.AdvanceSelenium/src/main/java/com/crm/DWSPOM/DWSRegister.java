package com.crm.DWSPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DWSRegister {
	
	@FindBy(id = "gender-male")
	public WebElement maleRadioButton;

	@FindBy(id = "FirstName")
	public WebElement firstnameTextfield;

	@FindBy(id = "LastName")
	public WebElement lastnameTextfield;
	
	@FindBy(id = "Email")
	public WebElement emailTextfield;
	
	@FindBy(id = "Password")
	public WebElement passwordTextfield;
	
	@FindBy(id = "ConfirmPassword")
	public WebElement confirmpasswordTextfield;

	public DWSRegister(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
