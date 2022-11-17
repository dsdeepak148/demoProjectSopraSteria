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

public class PremierLeaguePageTest extends TestBase {

	SportsHomePage sportsHomePage;
	FootballPage footballpage;
	LeagueAndCupsPage leagueandcups;
	PremierLeaguePage priemerleaguepage;

	public PremierLeaguePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		sportsHomePage = new SportsHomePage();
		footballpage = new FootballPage();
		leagueandcups = new LeagueAndCupsPage();
		priemerleaguepage = new PremierLeaguePage();
		footballpage = sportsHomePage.clickFootballMenu();
		leagueandcups = footballpage.clickLeagueAndCupsMenu();
		priemerleaguepage = leagueandcups.clickPremierLeagueLink();

	}

	@Test(enabled = false)
	public void verifyPremierLeaguePageTitle() {
		String priemerleaguepagetitle = priemerleaguepage.premierLeaguePageTitle();
		System.out.println("Title of PriemerLeague Page is  " + priemerleaguepagetitle);
		Assert.assertEquals(priemerleaguepagetitle, "Premier League - Football - BBC Sport",
				"PremierLeague Page title does not match");
	}

	@Test(priority = 1)
	public void verifyUpcomingFixturesList() throws InterruptedException {
		priemerleaguepage.nextFiveFixtures("Tottenham Hotspur");
	}

	@Test(priority = 2)
	public void verifyEasyGames() throws InterruptedException {
		priemerleaguepage.checkEasyGames("Tottenham Hotspur");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
