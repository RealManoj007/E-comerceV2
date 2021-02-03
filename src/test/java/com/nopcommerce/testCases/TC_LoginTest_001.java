package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import com.nopcommerce.pageObjects.loginPage;
import junit.framework.Assert;

public class TC_LoginTest_001 extends baseClass{


					
	@Test()
	public void loginTest() throws InterruptedException, IOException{
		System.out.println("Reached to Test case page");
//		driver.get(baseURL);
//		loginPage lp=new loginPage(driver);
		
//		lp.setUsername(username);
//		driver.findElement(By.xpath("//input[@id=\"Email\"]")).clear();
//		Thread.sleep(3000);
////		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("admin@yourstore.com");
//		logger.info("Username entered ");
//		Thread.sleep(3000);
//		logger.info("Wait for 3 seconds");
//		lp.setPassword(password);
//		logger.info("Password entered ");
//		Thread.sleep(3000);
//		logger.info("Wait for 3 seconds");
//		lp.clickLogin();
//		logger.info("Login ic clicked");
		
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		loginPage lp=new loginPage(driver);
		lp.setUsername(username);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(5000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login is passed");
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login is failed");
		}
	}
}
