package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass
{
	IndexPage indexPages;
	 SearchResultPage searchResultPage;
	 AddToCartPage addToCartPage;
	 OrderPage orderPage;
	 LoginPage loginPage;
	 AddressPage addressPage;
	 ShippingPage shippingPage;
	 PaymentPage paymentPage;
	 OrderSummaryPage orderSummary;
	 OrderConfirmationPage orderConfirmation;
	 
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
	  public void endToendTest(String product, String quantity, String size)
	  {
		  indexPages = new IndexPage();
		  searchResultPage = indexPages.searchProduct(product);
		  addToCartPage = searchResultPage.clickOnProduct();
		  addToCartPage.enterQuantity(quantity);;
		  addToCartPage.selectSize(size);;
		  addToCartPage.clickOnAddToCart();
		  orderPage = addToCartPage.clickOnCheckOut();
		  loginPage = orderPage.clickOnCheckOut();
		  addressPage = loginPage.login1( prop.getProperty("username"), prop.getProperty("password"));
		  shippingPage = addressPage.clickOnCheckOut();
		  shippingPage.clickCheckTheTerms();
		  paymentPage = shippingPage.clickOnProceedToCheckOut();
		  orderSummary = paymentPage.clickOnPaymentMethod();
		  orderConfirmation = orderSummary.clickOnConfirmOrderBtn();
		  String actMessage = orderConfirmation.validateConfirmMessage();
		  String expMessage = "Your order on My Shop is complete.";
		  Assert.assertEquals(actMessage, expMessage);
	  }
}