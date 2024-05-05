package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends baseClass{

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseURL);
		Logger.info("URL is opend");
		
	LoginPage lp= new LoginPage(driver);
	
	lp.setUserName(username);
	Logger.info("Entered username");
	
	lp.setPassword(password);
	Logger.info("password entered");
	
	lp.clickSubmit();
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
    Assert.assertTrue(true);
    Logger.info("Login test passed");
	}
    else
    {
    	   Assert.assertTrue(false);
    	   Logger.info("Login test failed");
    	   Assert.assertTrue(false);
    	   captureScreenShot(driver,"LoginTest");
    }	
	}
}
