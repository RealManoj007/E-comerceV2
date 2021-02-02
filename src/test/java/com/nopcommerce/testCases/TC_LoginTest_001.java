package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.annotations.*;
import com.nopcommerce.pageObjects.loginPage;


import junit.framework.Assert;

public class TC_LoginTest_001 extends baseClass{


					
	@Test
	public void loginTest() throws InterruptedException, IOException{
		System.out.println("Reached to Test case page");
		driver.get(baseURL);
		loginPage lp=new loginPage(driver);
//		lp.setUsername(username);
//		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Login ic clicked");
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
