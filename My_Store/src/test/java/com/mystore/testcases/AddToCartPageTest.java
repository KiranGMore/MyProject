package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class AddToCartPageTest extends BaseClass
{
	 IndexPage indexPages;
	 SearchResultPage searchResultPage;
	 AddToCartPage addToCartPage;
	
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
	  
	  @Test(dataProvider =  "getProduct", dataProviderClass = DataProviders.class,groups = {"Regression","Sanity"})
	  public void addToCartTest(String product, String quantity, String size)
	  {
		  Log.startTestCase("addToCartTest");
		  indexPages = new IndexPage();
		  searchResultPage = indexPages.searchProduct(product);
		  Log.info("Enter T-shirt as input in search box");
		  addToCartPage = searchResultPage.clickOnProduct();
		  Log.info("Clicked on product");
		  addToCartPage.enterQuantity(quantity);;
		  Log.info("2 quantity selected");
		  addToCartPage.selectSize(size);;
		  Log.info("M size selected");
		  addToCartPage.clickOnAddToCart();
		  Log.info("Added to cart");
		  boolean result = addToCartPage.validateAddToCart();
		  Assert.assertTrue(result);
		  Log.endTestCase("addToCartTest");
	  }
}
