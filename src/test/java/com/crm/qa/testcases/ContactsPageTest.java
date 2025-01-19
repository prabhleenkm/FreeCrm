package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.contactsPage;
import com.crm.qa.utill.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	contactsPage contactpage;
	TestUtil testutil;
	String sheetName= "contacts";

	public ContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod

	public void setUp() throws IOException {
		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		contactpage = new contactsPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		// got prop from base class as it has been extended and super keyword is used to
		// get initialization method
		testutil.SwitchToFrame();
		//homePage.clickonContactsLink();

	}

	/*@Test(priority = 1)

	public void verifyContactsLogo() throws IOException {

		contactpage.verifyContactsLogo();
		

	}

	/*@Test(priority = 2)

	public void clickonContact() {

		contactpage.SelectContactsByCompany("Amazon");

	}*/
	
	@DataProvider
	
	public Object[][] getCRMTestData()
	{
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	

@Test(priority =3, dataProvider="getCRMTestData")

	public void ValidatecreateContact(String title , String firstname, String lastname , String company) throws IOException, InterruptedException {
		homePage.clickOnNewContact();
		contactpage.createContact(title, firstname, lastname, company);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
