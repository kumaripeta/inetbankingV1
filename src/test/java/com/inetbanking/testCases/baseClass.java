package com.inetbanking.testCases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.inetbanking.Utilities.ReadConfig;


public class baseClass {
	     ReadConfig readconfig = new ReadConfig();
	     
	     public String baseURL=readconfig.getAplicationURL();
		 public String username=readconfig.getUsername();
		 public String password=readconfig.getPassword();
		 public static WebDriver driver;
		 
		 public static Logger Logger;
		 @Parameters("browser")
		 @BeforeClass
		 public void setup(String br)
		 {
			 Logger = LogManager.getLogger("inetBankingV1");
			if(br.equals("chrome"))
			{
				driver=new ChromeDriver(); 
			}
			else if(br.equals("ie"))
			{
				driver=new InternetExplorerDriver(); 
		 }
			else if(br.equals("firefox"))
			{
				driver=new FirefoxDriver(); 
		 }
			driver.get(baseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		 }
		 @AfterClass
		 public void tearDown()
		 {
			 driver.quit();  
		 }
		 
		 public void captureScreenShot(WebDriver driver,String testName) throws IOException {
			//convet webdriver obj to take 
			 TakesScreenshot screenshot=((TakesScreenshot)driver);
			 
			 //call getScreeshotAS mentohd to create image file
			 File src= screenshot.getScreenshotAs(OutputType.FILE);
			 File dest=new File(System.getProperty("user.dir"+"//Screenshots//" + testName + ".png"));
			 
			 //copy image file to destination
			 FileUtils.copyFile(src, dest); 
			  		 
		 }
		 public void Login() {
			 driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr570218");
			 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("epypatE");
			 driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
			 
		 }
		 
}
