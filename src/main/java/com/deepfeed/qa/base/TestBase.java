package com.deepfeed.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.deepfeed.qa.util.TestUtil;
import com.deepfeed.qa.util.WebEventListener;

public class TestBase {
	
	//in your base class fetch the data from properties file and  initialize your browser, 
//in base class we will initilize properies and insilize Webdriverso that driver and prop can be used for inside the project and out side the project , so it is called global variable, so no need to create 
	//object for chrome driver again and again in other class which inherits base class 
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	//create a constructor and initialize variable there, prop and driver can used outside of the class also ,so we have created global variable here
	public TestBase()
	{
		try
		{
			//fetch data from property file
			prop= new Properties();
			//give the path of the property filke below:go to property file,right click on it , then clickon properties and copy the path 
		
			FileInputStream ip = new FileInputStream("C:/Users/AVTNMY744/eclipse-workspace/Deep_feed_test/src/main/java/com/deepfeed/qa/config/config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch(FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//create a method and initialize browser here
	public static void initialization()
	{
		//get the browser name from property file 
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome"))
				{
			System.setProperty("webdriver.chrome.driver","C:/Users/AVTNMY744/Documents/javaselenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
			 driver = new ChromeDriver();
				} else if(browsername.equals("firefox"))
				{
					System.setProperty("webdriver.firefox.driver","path of firefox driver in your system");
					 driver = new FirefoxDriver();
			
				}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		//maximize the window inside the initialiazation method
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//get the url
		driver.get(prop.getProperty("url"));
	}
	
	
}

