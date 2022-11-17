package com.demoproject.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.base.TestBase;

public class PremierLeaguePage extends TestBase {
	public HashMap<Integer, String> tableMap;

	@FindBy(xpath = "//a[@data-stat-title='Table']")
	WebElement table;

	@FindBy(xpath = "//*[contains(@href,'teams/tottenham-hotspur')]")
	WebElement tottenham_hotspur;

	@FindBy(xpath = "//main[@id='main-content']//table/tbody/tr/td[1]/span")
	List<WebElement> position;

	@FindBy(xpath = "//main[@id='main-content']//table/tbody/tr/td[2]/div/a")
	List<WebElement> teams;

	@FindBy(xpath = "//div[@data-testid='carousel-list-wrapper']//ul/li")
	List<WebElement> fixtureslist;

	@FindBy(xpath = "//div[@data-testid='carousel-list-wrapper']//ul/li/div/div[1]/span")
	List<WebElement> leaguetype;

	@FindBy(xpath = "//div[@data-testid='carousel-list-wrapper']//ul/li/div/div[2]/div/div[1]/div[2]")
	List<WebElement> team1;

	@FindBy(xpath = "//div[@data-testid='carousel-list-wrapper']//ul/li/div/div[2]/div/div[2]/div[2]")
	List<WebElement> team2;

	@FindBy(xpath = "//div[@role='group']//button[1]")
	WebElement scrollleftbutton;

	@FindBy(xpath = "//div[@role='group']//button[2]")
	WebElement scrollrightbutton;

	@FindBy(xpath = "//h1[@id='main-heading']")
	WebElement mainheading;

	public PremierLeaguePage() {
		PageFactory.initElements(driver, this);
	}

	public void nextFiveFixtures(String teamname) throws InterruptedException {
		table.click();
		// To select the team dynamically for fixture list
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getText().contains(teamname)) {
				System.out.println("Current Postion of the Team " + teamname + " in league table is : "
						+ position.get(i).getText());
				teams.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		// Upcoming 5 fixtures
		System.out.println("Upcoming five fixtures of " + teamname + " are : ");
		for (int i = 1; i <= 5; i++) {
			// String hometeam =
			// driver.findElement(By.xpath("//div[@data-testid='carousel-list-wrapper']//ul/li["
			// +i+ "]/div/div[2]/div/div[1]/div[2]")).getText();
			// String awayteam =
			// driver.findElement(By.xpath("//div[@data-testid='carousel-list-wrapper']//ul/li["
			// +i+ "]/div/div[2]/div/div[2]/div[2]")).getText();
			String hometeam = team1.get(i).getText();
			String awayteam = team2.get(i).getText();
			System.out.println(hometeam + " vs " + awayteam);
			if (i % 2 == 0) {
				scrollrightbutton.click();
			}
			Thread.sleep(1000);
		}

	}

	public void checkEasyGames(String teamname) throws InterruptedException {
		table.click();
		tableMap = new HashMap<Integer, String>();
		for (int i = 0; i < teams.size(); i++) {
			Integer key = Integer.parseInt(position.get(i).getText());
			String value = teams.get(i).getText();
			tableMap.put(key, value);
			System.out.println(" Position-->" + key + "  Team-->" + value);
		}
		// To select the team dynamically for fixture list
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getText().contains(teamname)) {
				System.out.println("Current Postion of the Team " + teamname + " in league table is : "
						+ position.get(i).getText());
				teams.get(i).click();
				break;
			}
		}
		System.out.println("Easy games for " + teamname + " are as follows : ");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", mainheading);

		for (int i = 1; i <= 5; i++) {
			String hometeam = team1.get(i).getText();
			String awayteam = team2.get(i).getText();
			// System.out.println(hometeam+ " vs " + awayteam);
			if (i % 2 == 0) {
				scrollrightbutton.click();
			}

			Iterator<Integer> it = tableMap.keySet().iterator();
			while (it.hasNext()) {
				Integer rank = it.next();
				String Team = tableMap.get(rank);
				if ((Team.contains(hometeam) || Team.contains(awayteam)) && (rank > 10)) {
					System.out.println(hometeam + " vs " + awayteam);
				}

			}

			/*
			 * for(int j=11; j<=20;j++) {
			 * 
			 * if(tableMap.get(rank).contains(hometeam) ||
			 * tableMap.get(rank).contains(awayteam)){ System.out.println(hometeam + " vs "
			 * + awayteam); break; } }
			 * 
			 * if(i%2==0) { scrollrightbutton.click(); }
			 */
		}
	}

	public String premierLeaguePageTitle() {
		return driver.getTitle();
	}

}
