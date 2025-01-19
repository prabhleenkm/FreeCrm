package com.crm.qa.pages;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{

@FindBy(xpath="//td[contains(text(),'User: Gagan Khanna')]")
WebElement usernameLogo;

@FindBy(xpath="//a[contains(text(),'Contacts')]")
WebElement contactsLink;

@FindBy(xpath="//a[contains(text(),'Deals')]")
WebElement dealsLink;

@FindBy(xpath="//a[contains(text(),'Tasks')]")
WebElement TasksLink;

@FindBy(xpath="//a[contains(text(),'New Contact')]")
WebElement NewContact;



	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String verifyhomePageTitle() {
		return driver.getTitle();
		
	}
	
	public  contactsPage clickonContactsLink() throws IOException
	{
		contactsLink.click();
		return new contactsPage();
	}
	
	
	public  DealsPage clickonDealLink()
	{
		dealsLink.click();
		return new DealsPage();     
	}
	
	public  TaskPage clickonTasklLink()
	{
		TasksLink.click();
		return new TaskPage();
	}
	
	public boolean verifyusername() {
		return usernameLogo.isDisplayed(); 
		
	}
	
	public contactsPage clickOnNewContact() throws IOException, InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		
		Thread.sleep(3000);
		NewContact.click();
		return new contactsPage(); 
		
		
		
	}
	
	}

