Application URL:http://admin-demo.nopcommerce.com/

Admin email: admin@yourstore.com 
Admin password: admin

------------------------------------What is covered in this-----------------------

1) Data Driven Framework -> exchanging data from excel sheet
2) Hybrid framework -> It is user defined framework. In this we used 
		Selenium webdriver = To communicate and exachange data with Web Elements
		TestNG => Reporting tool to view what we ran. Anaotations play important role.
		Maven => no external library to be added, jut add dependency and run all.
		pache poi => 
		Log4j => Complete end to end to information
		extents reports => to view report with atteractive UI. in this we can also attach screenshot too.
		Page Object model => Manage page objects such as test methods(), 
									Action methods ex .click() method etc, 
									Object identiication method ex WebElemet elm= driver.findElement(By.xpath(""));

-------------------------------Brief Info about project----------------------------
POM.XML
1. Open Pom.xml and copy paste all the required dependency.
2. Have a look on <suiteXmlFile>TestNG.xml</suiteXmlFile>
3. This will run TestNG.xml, which contains suite that will execute the classes.

TestNG.XML
1. First create a suite, have a look on suite parallel element, it is used to run multiple tests at one time, user won't to wait for execution of first browser and then second browser to run.
2. In <test> , <paramter> field is used to run the type of browser as a parameter, this will execute on classes mentioned below.
3. In <classes>, no of <class> are mentioned and will execute that by TestBG suite

Go to structure eCommerceV5(project name)\src\test\java\com\nopcommerce and over here four folder are here
1.pageObject -> In this, mentioned onlt page objects such as test methods,action methods, Object identification methods(ex loginPage.java)
2.testCases  -> In this, (ex baseClass.java) we have created various methods that are picking values from utilities folder(regFile.java). These are the basic test cases which as metioned in TestNG.xml file <class>. It works as per anotations provided. baseClass.java is picking values from utilities folder and extended to TC_LoginTest_001.java and other class files.
3.testData => In this, excel file is saved where credentials are mentioned and these credentials are used in TC_LoginDDT_002.java by using anotation data provider.
4.utilities => These are the folders which is used commonly to provide information to testcases folder ex baseClass.java or pageObject folder.

-----------------------------Flow of project--------------------------------------==--

1. First pom.xml will be executed and from there testNG.xml will be run suite classes. picking the class TC_LoginTest_001.java as a example.
2. TC_LoginTest_001.java is extended wtih baseClass which is providing all information. Going to baseClass.java, it is picking value from Utilities folder of ReadConfig.java. This ReadConfig.java is picking value from config.properties which can be easy detected in root folder. This config.properties file we saved common properties which will used again and again. These properties are saved in these methods(ReadConfig.java methods) which are used in baseClass.jave.

In baseClass.java Logger is used which is of Log4j. this will provided the information to console or report what so ever is implmented or whose so ever function is running it will print that reports in the form on logs and will save that under folder Log folder that is in root directory.




