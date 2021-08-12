package com.visualstory.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.visualstory.pages.DashboardPage;
import com.visualstory.pages.LoginPage;

public class TC_CreateStoryTest_002 extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = loginPage.login("jagari.patra+102@digitalavenues.com", "Password@123");

		String expectedProfileName = "Jagari Patra";
		if (dashboardPage.getProfileName().contains(expectedProfileName)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
