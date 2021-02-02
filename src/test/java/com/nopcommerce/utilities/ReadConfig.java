package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configuration/config.properties");// picking file
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis); // It will load the file at the runtime
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	public String userName() {
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String passWord() {
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	public String ChromePath() {
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
	}
	public String FirefoxPath() {
		String firefoxPath=pro.getProperty("firefoxpath");
		return firefoxPath;
	}

}
