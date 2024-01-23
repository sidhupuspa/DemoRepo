package com.deepfeed.qa.testcases;

import java.util.Properties;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deepfeed.qa.base.TestBase;
import com.deepfeed.qa.pages.HomePage;
import com.deepfeed.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest()
	{
		//it will call super class constructor which is testbase class and there in testbase class 
		//we have initialized property in super class constructor, from property we are getting browsername and url,we maximized the window so all of this will executed from base class etc
		//so we need to call super class constructor here
		 super();
	}
	@BeforeMethod
	public void SetUp()
	{
		//call initialize method from base class
		initialization();
		//create object of loginpage
		loginpage= new LoginPage();
	}
	@Test(priority=1, retryAnalyzer = com.deepfeed.qa.util.RetryAnalize.class)
	public void LoginPageTitleTest()
	{
		//retryAnalyzer will use to retry this case if it is failed 
		//it will return string so return type will be string
	String title=loginpage.LoginPageValidation();  //expected title
	Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");
	} 
	@Test(priority=2)
	public void loginTest()
	{
		//after login it will land on home page so assign below to homepage
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	@AfterMethod
	public void Teardown()
	{
		driver.close();
	}

}

