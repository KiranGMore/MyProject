package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
     @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/ul/li[4]/a/span")
     WebElement myAddress;
     
     @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/ul/li[2]/a/span")
     WebElement orderHistory;
     
     public HomePage()
     {
   	  PageFactory.initElements(getDriver(), this);
     }
     
     public boolean validateMyAddress()
     {
    	 return Action.isDisplayed(getDriver(), myAddress);
     }
     
     public boolean validateOrderHistory()
     {
    	return Action.isDisplayed(getDriver(), orderHistory);
     }
     
     public String getCurrentURL()
     {
    	String homePageURL = getDriver().getCurrentUrl();
    	return homePageURL;
     }
}
