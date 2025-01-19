package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;

	//The constructor simplifies the process by combining object creation and field initialization into one step.
	public LoginPageTest() throws IOException {
		super(); // it will call base class constructor also 
		
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		
		loginpage = new LoginPage();//object creation of LoginPage so that we can use it here 
		
	}

	
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	
	public void LoginPageLogotest()
	{
		Boolean logo =loginpage.checkLogo();
		Assert.assertTrue(logo);
		
	}
	
	@Test(priority=3)
	
	public void Login() throws IOException
	{
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	
	public void teardown()
	{
		driver.close();
	}
}
