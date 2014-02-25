package com.dio.poc.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected final WebDriver driver;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

}
