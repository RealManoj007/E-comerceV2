package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

public WebDriver ldriver;

	public loginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email") @CacheLookup WebElement txtEmail;
	@FindBy(id="Password") @CacheLookup WebElement txtPassword; 
	@FindBy(xpath="//input[@type='submit']") @CacheLookup WebElement btnLogin;
	@FindBy(linkText="Logout") @CacheLookup WebElement logout;
	
	public void setUsername(String uname) {
			txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
}
