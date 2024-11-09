package com.staragile;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CRM.Utility.Utility;

public class HomePageTest extends BaseClass {
	@Test(priority = 1)
	public void VerifyURL() {

		String getActURL = hp.getAppURL();
		Assert.assertTrue(getActURL.contains("crm"), "TestFailURLnotmatching");
		Reporter.log("TestPass, URL Matched");
	}

	@Test(priority = 2)
	public void VerifyTitle() {
		String actURL = hp.getAppTitle();
		Assert.assertTrue(actURL.contains("Customer"), "title not match");
		Reporter.log("url matched successfully");
	}

	@Test(priority = 3)
	public void ValidateSignInLink() {
		String nextpageURL = hp.getStatusOfLink();
		Assert.assertTrue(nextpageURL.contains("login"), "link not matched");
		Reporter.log("link match ans pass");
		Utility.getScreenShot(driver);

	}
}
