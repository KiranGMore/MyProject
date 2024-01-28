package com.mystore.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass
{
	IndexPage indexPages;
	 SearchResultPage searchResultPage;
	 AddToCartPage addToCartPage;
	 OrderPage orderPage;
	 
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
	  
	  @Test(dataProvider =  "getProduct", dataProviderClass = DataProviders.class,groups = "Regression")
	  public void verifyTotalPrice(String product, String quantity, String size)
	  {
		  indexPages = new IndexPage();
		  searchResultPage = indexPages.searchProduct(product);
		  addToCartPage = searchResultPage.clickOnProduct();
		  addToCartPage.enterQuantity(quantity);;
		  addToCartPage.selectSize(size);;
		  addToCartPage.clickOnAddToCart();
		  orderPage = addToCartPage.clickOnCheckOut();
		  Double unitPrice = orderPage.getUnitPrice();
		  Double totalPrice =orderPage.getTotalPrice();
		  Double totalexPrice = (unitPrice * (Double.parseDouble(quantity))) + 7;
		  Assert.assertEquals(totalPrice, totalexPrice);
	  }
}
