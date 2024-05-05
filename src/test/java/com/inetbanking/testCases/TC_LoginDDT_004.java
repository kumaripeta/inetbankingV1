package com.inetbanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginDDT_004 extends baseClass{
	
	@Test(dataProvider="LoginData1")
	public void loginDDT(String cname,String cgender,String caddress,String ccity,String cstate,String cpin,String cmob,String cemail,String cpassword)
	{
		Login(); 
	AddCustomerPage adcust=new AddCustomerPage(driver);
	    adcust.clickAddNewcustomer();
		adcust.custName(cname);
		adcust.custgender(cgender);
		//adcust.custdob(cdob);
		adcust.custaddress(caddress);
		adcust.custcity(ccity);
		adcust.custstate(cstate);
		adcust.custpinno(cpin);
		adcust.custtelephoneno(cmob);
		adcust.custemailid(cemail);
		adcust.custpassword(cpassword);
		adcust.custsubmit();
	}
	@DataProvider(name="LoginData1")
	String [][]getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData1.xlsx";
		int rownum=XLUtils.getRowCount(path,"sheet1");
		int colcount=XLUtils.getCellCount(path,"sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"sheet1",i,j);
			}
		}
		return logindata;
	}
	}
