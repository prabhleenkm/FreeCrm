package com.crm.qa.pages;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR
	// It is used to initialize web elements defined in a Page Object class using
	// annotations like @FindBy.
	// To instantiate the PageFactory class in Selenium, you typically don't create
	// an object of the PageFactory class directly.
	// Instead, you use its static method initElements() to initialize the elements
	// of a Page Object Model (POM) class.
	// he initElements() method in the PageFactory class is a static method, which
	// means you can call it directly using the class name without creating an
	// object of the PageFactory class.

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Login;

	@FindBy(xpath = "//a[contains(text(),'Sign Up']")
	WebElement SignUp;

	@FindBy(className = "navbar-brand")
	WebElement logo;

//Initializing page factory
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle()

	{

		return driver.getTitle();
	}

	public boolean checkLogo() {
		return logo.isDisplayed();
	}

	public HomePage validateLogin(String un, String pwd) throws IOException {

		username.sendKeys(un);
		password.sendKeys(pwd);

		Login.click();
		return new HomePage();
	}

	/*
	 * NOTES ***********************************************************
	 * 
	 * explain PageFactory.initElements(driver, this); ? //this means current class
	 * objects . all the webelements will be initialized with driver //Use
	 * PageFactory.initElements() to initialize the elements in the Page Object
	 * class.
	 * 
	 * how will you initialize page factory class . we use method initElements
	 * 
	 * What Does Instantiating Do? Allocates Memory: Creates space in memory for the
	 * object. Initializes Properties: Sets up the object's attributes and methods
	 * as defined in the class. Makes the Object Usable: You can now call methods
	 * and access fields on the object.
	 */

	/*
	 * why driver is used here??
	 * 
	 * The driver connects the Page Object class to the browser instance. It ensures
	 * that elements annotated with @FindBy can be located and interacted with on
	 * the actual web page. Without the driver, Selenium cannot perform any actions
	 * on the page elements.If you don’t pass the driver to
	 * PageFactory.initElements(), Selenium won’t know which browser instance to use
	 * to locate the elements. This will result in an error when trying to interact
	 * with the elements.
	 * 
	 * What Happens Internally? When you call PageFactory.initElements(driver,
	 * this):Selenium examines all fields in the Page Object class annotated
	 * with @FindBy. It uses the driver to: -Look up the locator (e.g., id, xpath)
	 * provided in the annotation. -Create proxy objects for the corresponding web
	 * elements. -When you interact with a web element, the driver fetches the
	 * element from the page dynamically.
	 *
	 * 
	 */

}
