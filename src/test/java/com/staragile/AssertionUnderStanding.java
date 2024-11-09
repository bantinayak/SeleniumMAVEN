package com.staragile;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionUnderStanding {
	@Test
	public void HardAssertionTest() {
		String act = "selenium webdriver is a api";
		String exp = "selenium webdriver is a apii";
		Assert.assertEquals(act, exp, "Test is fail");
		System.out.println("Test is pass");
	}
}
