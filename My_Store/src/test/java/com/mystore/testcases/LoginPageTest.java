package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass
{
	  IndexPage indexPages;
	  LoginPage loginPage;
	  HomePage homePage;
	
	  @org.testng.annotations.Parameters("browser")
      @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
      public void setUp(String browser)
      {
    	  launchApp(browser);
      }
	  
	  @AfterMethod(groups = {"Smoke","Sanity","Regression"})
	  public void tearDown()
	  {
		  getDriver().quit();
	  }
	  
	  @Test(dataProvider =  "credentials", dataProviderClass = DataProviders.class,groups = {"Smoke","Sanity"})
	  public void loginTest(String uname, String psd)
	  {
		  Log.startTestCase("loginTest");
		  indexPages = new IndexPage();
		  Log.info("User is going to click on signin");
		  loginPage = indexPages.clickOnSignIn();
		  Log.info("Enter uname and pass");
		  homePage=loginPage.login(uname, psd);
		  String actualURL=homePage.getCurrentURL();
		  String expactedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		  
		  Log.info("Verifing if user is able to login");
		  Assert.assertEquals(actualURL, expactedURL);
		  Log.info("Login successful");
		  Log.endTestCase("loginTest");
	  }
	   
}
