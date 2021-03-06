package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyLoginPageWithReports {
	
	  
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		
		report = new ExtentReports("./Reports/LoginPageReport.html",true);
		
		logger = report.startTest("Verify Login Page");
		
		driver = BrowserFactory.getBrowser("Firefox");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testLoginPage(){
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		home.LoginPageNew(driver);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		
		home.clickOnLogin();
		
		logger.log(LogStatus.INFO, "Click on Login link");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 1, 0),DataProviderFactory.getExcel().getData(0, 1, 1));
		
		logger.log(LogStatus.INFO, "Login to application");
		
		login.verifyDashboardTitle();
		
		logger.log(LogStatus.PASS, "Dashboard Title verified.");
	}
	
	
	@AfterMethod
	public void tearDown(){
		
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
	

}
