package com.demoproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.base.TestBase;

public class FootballPage extends TestBase {

	@FindBy(xpath = "//a[@data-stat-title='Leagues & Cups']")
	WebElement leagueandcups;

	public FootballPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateFootballPageTitle() {

		return driver.getTitle();
	}

	public LeagueAndCupsPage clickLeagueAndCupsMenu() {

		leagueandcups.click();
		return new LeagueAndCupsPage();

	}

}
