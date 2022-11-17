package com.demoproject.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoproject.base.TestBase;
import com.demoproject.pages.FootballPage;
import com.demoproject.pages.SportsHomePage;

public class SportsHomePageTest extends TestBase {

	SportsHomePage sportsHomePage;
	FootballPage footBallPage;

	public SportsHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();

	}

	@Test(priority = 1)
	public void sportsHomePageTitleTest() {
		String title = sportsHomePage.validateSportsHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "BBC Sport - Scores, Fixtures, News - Live Sport");
	}

	@Test(priority = 2)
	public void verifyFootballMenuTest() {
		footBallPage = sportsHomePage.clickFootballMenu();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
