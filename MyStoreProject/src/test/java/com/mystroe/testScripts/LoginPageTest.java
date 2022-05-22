package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.dataProvider.DataProviders;
import com.mystroe.pageObjects.HomePage;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.LoginPage;
import com.mystroe.utility.Log;

public class LoginPageTest extends Baseclass{

	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchBrowser(browserName); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "Credentials" ,dataProviderClass = DataProviders.class,groups = {"Smoke","Sanity","Regression"})
	public void loginTest(String usname,String passwd){
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("Click on SignIn Button");
		loginPage=indexPage.clickOnSignIn();
		Log.info("User enter Username and Password as "+prop.getProperty("username")+prop.getProperty("password"));     
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(usname,passwd);
		Log.info("Get the actual url");
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Log.info("Validating the url");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.endTestCase("Test Case ended successfully");
	}
	
}
