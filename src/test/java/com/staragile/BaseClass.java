package com.staragile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	public HomePage hp;
	public LoginPage dp;

	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		driver.get("https://automationplayground.com/crm/");
		hp = new HomePage(driver);
		dp=new LoginPage(driver);
	}

}
