package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass
{
	  IndexPage indexPages;
	
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
	  
	  @Test(groups = "Smoke")
	  public void verifyLogo()
	  {
		  indexPages = new IndexPage();
		  boolean result = indexPages.validateLogo();
		  Assert.assertTrue(result);
	  }
	  
	  @Test(groups = "Smoke")
	  public void verifyTitle()
	  {
		 String title = indexPages.getMyStoreTitle();
		//replace My Shop1 as My Shop for original code
		 Assert.assertEquals(title, "My Shop1");
	  }
}
