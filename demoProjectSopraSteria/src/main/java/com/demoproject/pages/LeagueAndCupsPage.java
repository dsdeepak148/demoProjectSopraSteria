package com.demoproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.base.TestBase;

public class LeagueAndCupsPage extends TestBase {

	@FindBy(xpath = "//div[@class='gel-layout']/div[1]//table[1]/tbody/tr[1]/td[1]/a")
	WebElement premierleague;

	public LeagueAndCupsPage() {
		PageFactory.initElements(driver, this);

	}

	public String lagueAndCupsPageTitle() {

		return driver.getTitle();
	}

	public PremierLeaguePage clickPremierLeagueLink() {
		premierleague.click();
		return new PremierLeaguePage();
	}

}
