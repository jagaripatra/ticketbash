package com.visualstory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void click(By by, String name) {
		highLighter(driver.findElement(by));
		// r().getScreenShot(Status.PASS); TODO
		driver.findElement(by).click();
		// r().info("Clicked on "+ name); TODO
	}

	public void typeText(By by, String value, String label) {
		highLighter(driver.findElement(by));
		// r().getScreenShot(Status.PASS); TODO
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		// r().info("Entered "+ value +" in the "+label); TODO
	}

	public void highLighter(WebElement elem) {
		String script = "arguments[0].setAttribute('style','background-color:rgba(255, 199, 199); border:0.1px solid red;')";
		js.executeScript(script, elem);
	}

}
