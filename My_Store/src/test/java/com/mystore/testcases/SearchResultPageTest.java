package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass
{
	IndexPage index;
	SearchResultPage searchResultPage;
	
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
	  
	  @Test(dataProvider =  "searchProduct", dataProviderClass = DataProviders.class,groups = "Smoke")
	  public void productAvaibilityTest(String product)
	  {
		  index = new IndexPage();
		  searchResultPage = index.searchProduct(product);
		  boolean result = searchResultPage.isProductAvailable();
		  Assert.assertTrue(result);
	  }
}
