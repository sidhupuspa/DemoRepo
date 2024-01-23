package com.deepfeed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deepfeed.qa.base.TestBase;

public class HomePage extends TestBase {
//after login suppose i want to verify if sidhupuspa satapathy user is there or not
	
	@FindBy(xpath="//span[text()='Sidhupuspa  Satapathy ']")
	WebElement username;
	
	//suppose i want to click on contacts
	@FindBy(xpath="a[href=\"/contacts\"]")
	@CacheLookup //This annotation we use to store the element which 
	//we will get after find element method,in ur application there might be 1000 element
	//and each test page some elements we will use multiple time , 
	//so it is better practice to store element in cachelookup, 
	//so that for each test your rqst won't hit browser agaian and again 
	//& after one hit only it will store elements in a cache memory , 
	//when the next rqst will come from test page it won't go to browser again , 
	//it will return data from cache memory but problem is , 
	//if the page is refreshed or some new thing added to your data in your page, 
	//in that case if driver try to fetch data from cache then it will through 
	//staleelement exception or you will get some error, 
	//so better practice is if u know that those page won't change at any time 
	//then in that case we should use cachelookup instade of every page
	//but it is very powerful to improve your functionality,script will be faster 
	WebElement contactlink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyHomepageTitle()
	{
	String HomepageTitle=	driver.getTitle();
	return HomepageTitle;
	//i'll call this method in homepage test and do assert to verify title
	}
	public Boolean verifyUsername()
	{
	boolean user=	username.isDisplayed();
	return user;
	}
	
	public ContactsPage clickonContact()
	{
		
		contactlink.click();
		//clickin on contactlink returning object of contact page
		//always create object of next landing page and return that object 
		return new ContactsPage();
	}
}



