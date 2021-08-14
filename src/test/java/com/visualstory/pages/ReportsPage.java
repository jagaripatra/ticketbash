package com.visualstory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage extends BasePage{
	
	public ReportsPage(WebDriver driver) {
		super(driver);
	}
	
	By byUserImg = By.xpath("//div[@class='autoScrollbars']//img");
	By byLogout = By.linkText("Logout");
	By byLongInventoryScoreCardLink = By.linkText("Long Inventory Score Card");
	
	
	public void logout() {
		click(byUserImg, "User Image");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLogout));
		
		click(byLogout, "Lohout");
	}

	public LongInventoryScorecardPage clickLongInventoryScoreCard() {
		click(byLongInventoryScoreCardLink, "Long Inventory Score Card");
		return new LongInventoryScorecardPage(driver);
	}
}
