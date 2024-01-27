package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
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
	  
	  @Test(dataProvider = "email", dataProviderClass = DataProviders.class,groups = "Sanity")
	  public void verifyCreateAccountPageTest(String mail)
	  {
		  Log.startTestCase("verifyCreateAccountPageTest");
		  indexPage = new IndexPage();
		  loginPage = indexPage.clickOnSignIn();
		  Log.info("Click on signin");
		  accountCreationPage = loginPage.createNewAccount(mail);
		  Log.info("Create new account");
		  boolean result = accountCreationPage.validateAccounCreatePage();
		  Assert.assertTrue(result);
		  Log.endTestCase("verifyCreateAccountPageTest");
	  }
}
