package com.deepfeed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deepfeed.qa.base.TestBase;

public class LoginPage extends TestBase{
//login page and all other pages are child class of base class 
	
	//here we have to define the object repository/or page factory it use @findby annotation
	//create object reposatory 
	@FindBy(xpath="//span[text()='Log In']")
	WebElement LoginButton;
	
	@FindBy(name="email") //it is similar to driver.findelement(By.name)="username"
	WebElement useremail;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class=\"ui fluid large blue submit button\"]")
	WebElement Login;
	
	//initializing pagefactory: now we have to initialize above webelements below in constructor 
	
	public LoginPage()
	{
		//how will u initilize your pagefactory,  we have a mehod PageFactory.initElements , 
		//init element means initialize element with driver and this means current class object  
		//so all these variables will initializewith driver ,instade of this we can write LoginPage.class but better to use this, this means currectclas object
		
		PageFactory.initElements(driver, this);
		
	}
	//Actions: create methods for each functions you want to test
 public String LoginPageValidation()
 {
	 return driver.getTitle();
 }
 public HomePage login(String un, String pwd)
 {
	 LoginButton.click();
	 useremail.sendKeys(un);
	 password.sendKeys(pwd);
	 Login.click();
	 //after clickin on login it will land on home page 
	 //so return type of this method should be homepage
	 return new HomePage();
 }
 {
	 
 }
	
}
