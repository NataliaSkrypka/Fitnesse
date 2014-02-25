package com.dio.poc.fixtures;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dio.poc.pages.HomePage;

public class SearchOnMainPage {

	private String textToSearch;
	private String date;
	private String result;
	private String message;

	private HomePage homePage;
	private WebDriver driver;

	public void setTextToSearch(String textToSearch) {
		this.textToSearch = textToSearch;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String result() {
		return result;
	}

	public String message() {
		return message;
	}

	public void execute() {
		driver.get("http://www.booking.com/");
		System.out.println("Execute method started");
		System.out.println("Perform search for " + textToSearch);
		if ("No specific".equals(date)) {
			homePage.enterTextAndClickSearch(textToSearch);
		} else {
			homePage.enterTextLeaveDateEmptyClickSearch(textToSearch);
		}
		result = homePage.getFirstCityAfterSearch();
		message = homePage.getErrorMessage();
	}

	public void table(List<List<String>> table) {
		System.out.println("Before table we start driver");
		driver = new FirefoxDriver();
		homePage = new HomePage(driver);
	}

	public void endTable() {
		if (null != driver) {
			driver.quit();
		}
	}

}
