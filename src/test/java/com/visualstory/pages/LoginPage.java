package com.visualstory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	@CacheLookup
	WebElement edtEmail;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement edtPassword;
	
	@FindBy(xpath="//button[text()='Sign In']")
	@CacheLookup
	WebElement btnSignIn;
	
	public DashboardPage login(String email, String password) {
		edtEmail.sendKeys(email);
		edtPassword.sendKeys(password);
		btnSignIn.click();
		
		return new DashboardPage(driver);
	}
	
}
