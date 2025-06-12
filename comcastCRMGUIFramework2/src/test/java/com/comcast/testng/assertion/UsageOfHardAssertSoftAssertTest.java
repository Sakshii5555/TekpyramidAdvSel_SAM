package com.comcast.testng.assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsageOfHardAssertSoftAssertTest {
	@Test
	public void TestA(Method m) {
		System.out.println(m.getName()+ " TestCase Starts");
		System.out.println("STEP-1");
		System.out.println("STEP-2");
		Assert.assertEquals("Home", "Home");
		System.out.println("STEP-3");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("HomePage","HomePagew");
		System.out.println("STEP-4");
		sa.assertAll();
		System.out.println(m.getName()+" TestCase Ends");
	}
	
	@Test
	public void TestB(Method m) {
		System.out.println(m.getName()+ " TestCase Starts");
		System.out.println("STEP-1");
		System.out.println("STEP-2");
		System.out.println("STEP-3");
		System.out.println("STEP-4");
		System.out.println(m.getName()+" TestCase Ends");
	}
}
