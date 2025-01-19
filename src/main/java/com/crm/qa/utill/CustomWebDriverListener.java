package com.crm.qa.utill;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomWebDriverListener implements WebDriverListener {

	public CustomWebDriverListener(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beforeClick(WebElement element) {
		System.out.println("Before clicking on: " + element.toString());
	}

	@Override
	public void afterClick(WebElement element) {
		System.out.println("Clicked on: " + element.toString());
	}

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Before finding element: " + locator);
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found element: " + locator);
	}

	public void onError(WebDriver driver, Throwable throwable) throws IOException {
		System.out.println("Error occurred: " + throwable.getMessage());
		throwable.printStackTrace();

		TestUtil.takeScreenshotAtEndOfTest();

	}

}