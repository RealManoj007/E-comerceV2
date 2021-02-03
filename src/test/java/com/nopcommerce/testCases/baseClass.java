package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class baseClass {
	
	ReadConfig readfile=new ReadConfig();
		
	public String baseURL=readfile.getApplicationURL();
	public String username=readfile.userName();
	public String password=readfile.passWord();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {
		logger=Logger.getLogger("E-Commerce");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readfile.ChromePath());
		driver=new ChromeDriver();
		
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readfile.FirefoxPath());
			driver=new FirefoxDriver();
			System.out.println(br);
		}else {
			System.out.println("No relevent browser");
			Assert.assertTrue(false);
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}

}
