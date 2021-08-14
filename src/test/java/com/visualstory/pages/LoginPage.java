package com.visualstory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By edtEmail = By.xpath("//input[@name='email']");

	By edtPassword = By.xpath("//input[@name='password']");

	By btnSignIn = By.xpath("//span[text()='Login']");

	public ReportsPage login(String email, String password) {
		typeText(edtEmail, email, "email");
		typeText(edtPassword, password, "password");
		click(btnSignIn, "Login");

		return new ReportsPage(driver);
	}

}
