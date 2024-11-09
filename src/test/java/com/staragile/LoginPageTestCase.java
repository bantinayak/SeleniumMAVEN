	package com.staragile;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPageTestCase extends BaseClass {

	@BeforeClass
	public void pagesetup() {
		hp.getStatusOfLink();
	}

	@Test
	public void ValidateLogin() {
		String url = dp.dologin("test@gmail.com", "test123");
		Assert.assertTrue(url.contains("customers"), "testfail");
		Reporter.log("TestPass");

	}
}
