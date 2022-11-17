package com.demoproject.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoproject.base.TestBase;
import com.demoproject.pages.FootballPage;
import com.demoproject.pages.LeagueAndCupsPage;
import com.demoproject.pages.PremierLeaguePage;
import com.demoproject.pages.SportsHomePage;

public class LeagueAndCupsPageTest extends TestBase {
	SportsHomePage sportsHomePage;
	FootballPage footballpage;
	LeagueAndCupsPage leagueandcups;
	PremierLeaguePage priemerleaguepage;

	public LeagueAndCupsPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		sportsHomePage = new SportsHomePage();
		footballpage = new FootballPage();
		leagueandcups = new LeagueAndCupsPage();
		footballpage = sportsHomePage.clickFootballMenu();
		leagueandcups = footballpage.clickLeagueAndCupsMenu();

	}

	@Test(priority = 1)
	public void verifyLeagueAndCupsTitleTest() {
		String leagueandcupstitle = leagueandcups.lagueAndCupsPageTitle();
		System.out.println("Title of LeagueAndCups Page is  " + leagueandcupstitle);
		Assert.assertEquals(leagueandcupstitle, "Leagues & Cups - Football - BBC Sport",
				"LeagueAndCups Page title does not match");
	}

	@Test(priority = 2)
	public void verifyPremierLeagueLinkTest() {
		priemerleaguepage = leagueandcups.clickPremierLeagueLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
