package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.contactsPage;
import com.crm.qa.utill.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	contactsPage contactpage;
	TestUtil testUtil;

	public HomePageTest() throws IOException {

		super();

	}
//test cases should be separated therefore for each test case login and after execution close the browser . there will be no cache problem.
	
	
	@BeforeMethod

	public void setUp() throws IOException {
		initialization();
		testUtil= new TestUtil();
		loginPage = new LoginPage();
		contactpage= new contactsPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password")); 
		//got prop from base class as it has been extended and super keyword is used to get initialization method
		

	}
	
	@Test(priority =1)
	
	public void verifyHomePageTitle()
	{
		String HomePageTitle=homePage.verifyhomePageTitle();
		
		Assert.assertEquals(HomePageTitle, "CRMPRO", "home page title not matched");
	}
	
	
	@Test(priority =2)
	
	public void verifyUserNameIsdDisplayed()
	{
		testUtil.SwitchToFrame();
		Assert.assertTrue(homePage.verifyusername());
	}
	
	@Test(priority =3)
	public void verifyContactsLink() throws IOException
	{
		testUtil.SwitchToFrame();
		contactpage =homePage.clickonContactsLink();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
