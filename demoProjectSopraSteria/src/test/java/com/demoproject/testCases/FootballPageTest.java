package com.demoproject.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoproject.base.TestBase;
import com.demoproject.pages.FootballPage;
import com.demoproject.pages.LeagueAndCupsPage;
import com.demoproject.pages.SportsHomePage;

public class FootballPageTest extends TestBase {
	SportsHomePage sportsHomePage;
	FootballPage footballpage;
	LeagueAndCupsPage leagueandcups;

	public FootballPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		sportsHomePage = new SportsHomePage();
		footballpage = sportsHomePage.clickFootballMenu();
	}

	@Test(priority = 1)
	public void verifyFootballPageTitleTest() {
		String footballpagetitle = footballpage.validateFootballPageTitle();
		System.out.println("Title of Football Page is  " + footballpagetitle);
		Assert.assertEquals(footballpagetitle, "Football - BBC Sport", "Football Page title does not match");
	}

	@Test(priority = 2)
	public void verifyLeagueAndCupsMenuLink() {
		leagueandcups = footballpage.clickLeagueAndCupsMenu();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
