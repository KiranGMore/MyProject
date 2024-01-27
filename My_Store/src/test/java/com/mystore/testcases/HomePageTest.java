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

public class HomePageTest extends BaseClass
{
	IndexPage indexPage;
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
	  
	  @Test(dataProvider =  "credentials", dataProviderClass = DataProviders.class,groups = "Smoke")
	  public void wishListTest(String uname, String pwd)
	  {
		  indexPage = new IndexPage();
		  loginPage = indexPage.clickOnSignIn();
		  homePage=loginPage.login(uname, pwd);
		  boolean result = homePage.validateMyAddress();
		  Assert.assertTrue(result);
	  }
	  
	  @Test(dataProvider =  "credentials", dataProviderClass = DataProviders.class,groups = "Smoke")
	  public void orderHistoryAndDetailsTest(String uname, String pwd)
	  {
		  indexPage = new IndexPage();
		  loginPage = indexPage.clickOnSignIn();
		  homePage=loginPage.login(uname, pwd);
		  @SuppressWarnings("unused")
		  boolean result = homePage.validateOrderHistory();
		  //replace false as result for original code
		  Assert.assertTrue(false);
	  }
}
