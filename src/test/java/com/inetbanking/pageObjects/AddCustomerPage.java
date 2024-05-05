package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	WebElement lnkAddNewcustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@name=\"rad1\"]")
	WebElement rdGender;
	
	@FindBy(xpath="//input[@type=\"date\"]")
	WebElement txtdob;
	
	@FindBy(xpath="//input[@name=\"state\"]")
	WebElement txtstate;
	
	@FindBy(xpath="//input[@name=\"pinno\"]")
	WebElement txtpinno;
	
	@FindBy(xpath="//textarea[@name=\"addr\"]")
	WebElement txtaddress;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	WebElement txtcity;
	
	@FindBy(xpath="//input[@name=\"telephoneno\"]")
	WebElement txttelephono;
	
	@FindBy(xpath="//input[@name=\"emailid\"]")
	WebElement txtemailid;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement cadded;
	
	public void custdded()
	{
		cadded.click();
	}
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void clickAddNewcustomer()
	{
		lnkAddNewcustomer.click();
	}
	public void custgender(String cgender)
	{
		rdGender.click();
	}
	
	public void custdob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custpinno(String cpinno)
	{
		txtpinno.sendKeys(cpinno);
	}
	
	public void custtelephoneno(String ctelephoneno)
	{
		txttelephono.sendKeys(ctelephoneno);
	}
	public void custpassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	public void custemailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}

	public void custsubmit()
	{
		btnSubmit.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
