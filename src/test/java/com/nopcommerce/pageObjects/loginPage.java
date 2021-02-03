package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopcommerce.testCases.baseClass;

public class loginPage extends baseClass{

public WebDriver ldriver;

	public loginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email") @CacheLookup WebElement txtEmail;
	@FindBy(id="Password") @CacheLookup WebElement txtPassword; 
	@FindBy(xpath="//input[@type='submit']") @CacheLookup WebElement btnLogin;
	@FindBy(linkText="Logout") @CacheLookup WebElement logout;
	
//	WebElement txtEmail=ldriver.findElement(By.xpath("//input[@id=\"Email\"]")).clear();
//	ldriver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("admin@yourstore.com");
//	ldriver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("admin");
//	ldriver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")).click();
	
	
	public void setUsername(String uname) throws InterruptedException
	{
		txtEmail.clear();
		Thread.sleep(2000);
		txtEmail.sendKeys(uname);
		Thread.sleep(2000);
	}
		
	public void setPassword(String pwd) throws InterruptedException
	{
		txtPassword.clear();
		Thread.sleep(2000);
		txtPassword.sendKeys(pwd);
		Thread.sleep(2000);
	}
	
//	public void setUsername(String uname) throws InterruptedException {
//		    System.out.println("Reached to username");
//			txtEmail.clear();
//			txtEmail.sendKeys(uname);
//			System.out.println(uname);
//			if(txtEmail.equals("")) {
//				Thread.sleep(3000);
//				txtEmail.sendKeys(uname);
//				System.out.println("Reached to username");
//				logger.info("Entered inside of setUsername");
//			}else {
//				System.out.println("Email name is "+uname);
//				Assert.assertTrue(true);
//			}
//			
//	}
//	
//	public void setPassword(String pwd) throws InterruptedException {
//		if(txtEmail.equals("")) {
//			setUsername("admin@yourstore.com");
//		}
//		System.out.println("Entered in setpassword method");
//		txtEmail.clear();
//		Thread.sleep(3000);
//		txtPassword.sendKeys(pwd);
//	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
}
