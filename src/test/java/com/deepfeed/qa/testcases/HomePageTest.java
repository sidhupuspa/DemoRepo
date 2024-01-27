package com.deepfeed.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deepfeed.qa.base.TestBase;
import com.deepfeed.qa.pages.HomePage;
import com.deepfeed.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	//ctrl+shif+o to import automatically 
	LoginPage loginpage;
	HomePage homepage;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		//need to do login before going to home page so implement login details
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	@Test(priority = 2)
	public void verifyHomepageTitleTest()
	{
		String Homepagetitle= homepage.verifyHomepageTitle();
		//we can pass extra argument if title doesnot match : Home page title not match
	Assert.assertEquals(Homepagetitle, "Cogmento CRM","Home page title not match");
	}
	@Test(priority = 1)
	public void verifyUsernameTes()
	{
  Assert.assertTrue(homepage.verifyUsername());
	}
	@Test
	public void testGit()
	{
		//update something to checkin again in git 
	}
	public void testGit2()
	{
		//update something to checkin again in git 
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

	

}
