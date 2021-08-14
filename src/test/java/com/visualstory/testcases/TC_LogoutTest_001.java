package com.visualstory.testcases;

import org.testng.annotations.Test;

import com.visualstory.pages.LoginPage;
import com.visualstory.pages.ReportsPage;

public class TC_LogoutTest_001 extends BaseTest{
	
	@Test
	public void run() {
		
		LoginPage loginPage = new LoginPage(driver);
		ReportsPage reportsPage = loginPage.login("demo@gmail.com", "Password@123");
		reportsPage.logout();
		
	}
	
}
