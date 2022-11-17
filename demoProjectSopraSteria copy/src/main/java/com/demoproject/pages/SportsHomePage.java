package com.demoproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.base.TestBase;

public class SportsHomePage extends TestBase {

	@FindBy(xpath = "//div[@id='product-navigation-menu']/div[2]/ul/li[2]/a")
	WebElement footballpagelink;

	// Initialixation of Page Objects
	public SportsHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateSportsHomePageTitle() {

		return driver.getTitle();

	}

	public FootballPage clickFootballMenu() {

		footballpagelink.click();
		return new FootballPage();
	}

}
