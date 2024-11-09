package com.staragile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.CRM.Utility.Utility;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By email = By.id("email-id");
	private By pwd = By.id("password");
	private By loginButton = By.name("submit-name");

	public String dologin(String em, String pw) {
		driver.findElement(email).sendKeys(em);
		driver.findElement(pwd).sendKeys(pw);
		driver.findElement(loginButton).click();
		Utility.getScreenShot(driver);
		return driver.getCurrentUrl();
	}

}
