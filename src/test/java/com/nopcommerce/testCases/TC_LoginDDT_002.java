package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.loginPage;
import com.nopcommerce.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends baseClass{

	@Test(dataProvider = "LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException {
		System.out.println("Reached to Test case page");
		driver.get(baseURL);
		driver.manage().window().maximize();
		loginPage lp=new loginPage(driver);
//		lp.setUsername(username);
//		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Login is clicked");
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
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		int rows=XLUtils.getRowCount(path, "Sheet1");
		int cols=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rows][cols];
		
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}
}
