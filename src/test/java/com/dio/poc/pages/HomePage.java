package com.dio.poc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

	private static final String ONE_ADULT = "1 Adult";
	private static final String SEARCH_FIELD = "//input[@id='destination']";
	private static final String SEARCH_CITY_FIRST_IN_LIST = "//div[@id='cityWrapper']/div[1]/div[2]/a";
	private static final String ERROR_ON_SEARCH = "//div[@id='b_searchbox_errors']/p";
	private static final String CHECKBOX_NO_SPECIFIC_DATES = "//input[@id='availcheck']";
	private static final String SEARCH_BUTTON = "//button[@id='searchbox_btn']";
	private static final String ERROR_ON_DATES = "//p[contains(@class,'dateerros')]";
	private static final String GUESTS_DROPDOWN = "//select[@name='sb_predefined_group_options_value']";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void inputTextInSearchField(String searchText) {
		driver.findElement(By.xpath(SEARCH_FIELD)).clear();
		driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(searchText);
	}

	public String getErrorOnNames() {
		List<WebElement> errorList = driver.findElements(By
				.xpath(ERROR_ON_SEARCH));
		if (errorList.size() > 0) {
			return errorList.get(0).getText();
		}
		return "";
	}

	public void clickOnNoSpecificDatesCheckBox() {
		driver.findElement(By.xpath(CHECKBOX_NO_SPECIFIC_DATES)).click();
	}

	public void verifyNumberOfGuests() {
		Select select = new Select(
				driver.findElement(By.xpath(GUESTS_DROPDOWN)));
		select.selectByVisibleText(ONE_ADULT);
	}

	public void clickOnSearchButton() {
		driver.findElement(By.xpath(SEARCH_BUTTON)).click();
	}

	public String getFirstCityAfterSearch() {
		List<WebElement> findElements = driver.findElements(By
				.xpath(SEARCH_CITY_FIRST_IN_LIST));
		if (findElements.size() > 0) {
			return findElements.get(0).getText();
		}
		return "";
	}

	public String getErrorOnDates() {
		List<WebElement> errorList = driver.findElements(By
				.xpath(ERROR_ON_DATES));
		if (errorList.size() > 0) {
			return errorList.get(0).getText();
		}
		return "";
	}

	public void enterTextAndClickSearch(String textToSearch) {
		inputTextInSearchField(textToSearch);
		clickOnNoSpecificDatesCheckBox();
		verifyNumberOfGuests();
		clickOnSearchButton();
	}

	public String getErrorMessage() {
		if (!getErrorOnDates().isEmpty()) {
			return getErrorOnDates();
		} else {
			if (!getErrorOnNames().isEmpty()) {
				return getErrorOnNames();
			}
		}
		return "";
	}

	public void enterTextLeaveDateEmptyClickSearch(String textToSearch) {
		inputTextInSearchField(textToSearch);
		verifyNumberOfGuests();
		clickOnSearchButton();
	}
}
