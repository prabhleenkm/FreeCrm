package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class contactsPage extends TestBase {

	public contactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@CacheLookup //it will help to improve framework performance. instead of finding the WebElement every time it is accessed, Selenium will reuse the cached reference.
	//This can improve performance in scenarios where the WebElement does not change or get refreshed during the test execution.

	WebElement ContactsLogo;

	@FindBy(xpath = "//a[contains (text(),'Amazon')]//parent::td//preceding-sibling::td/input")
	WebElement checkbox;

	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement NewContact;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement CompanyName;

	@FindBy(xpath = "//input[@type='submit' and @value='save']")
	WebElement SubmitButton;

	public boolean verifyContactsLogo()

	{
		return ContactsLogo.isDisplayed();

	}

	public void SelectContactsByCompany(String company)

	{
		driver.findElement(
				By.xpath("//a[contains (text(),'" + company + "')]//parent::td//preceding-sibling::td/input")).click();
	}


	public void createContact(String title, String frstname, String lastname, String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(frstname);
		lastName.sendKeys(lastname);
		CompanyName.sendKeys(company);
	}

}
