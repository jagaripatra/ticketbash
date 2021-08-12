package com.visualstory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='/images/logo.svg']/following::ul/li[1]")
	WebElement elemProfileName;
	
	public String getProfileName() {
		return elemProfileName.getText().trim();
	}
	
}
