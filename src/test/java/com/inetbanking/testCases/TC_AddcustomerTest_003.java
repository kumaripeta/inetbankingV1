package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddcustomerTest_003 extends baseClass{
	
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		Logger.info("Entered username");
		
		lp.setPassword(password);
		Logger.info("password entered");
		
		lp.clickSubmit();
		Thread.sleep(2000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewcustomer();
		Thread.sleep(2000);
		
		addcust.custName("kumari");
		addcust.custgender("female");
		addcust.custstate("ap");
		addcust.custpinno("5000074");
		addcust.custdob("10","8","1999");
		addcust.custcity("vizag");
		addcust.custaddress("indaddcustia");
		addcust.custtelephoneno("8245978631");
		addcust.custpassword("acdsc");
		String email=randomString()+"gmail.com";
		addcust.custemailid(email);
		Thread.sleep(1000);
		addcust.custsubmit();
	}
public String randomString() {
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return (generatedstring);
}
}
