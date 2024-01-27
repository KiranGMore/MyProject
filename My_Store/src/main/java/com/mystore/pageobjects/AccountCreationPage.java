package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass
{
     @FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
     WebElement formTitle;
     
     public AccountCreationPage()
     {
   	  PageFactory.initElements(getDriver(), this);
     }
     
     public boolean validateAccounCreatePage()
     {
    	Action.fluentWait(getDriver(), formTitle, 10);
    	return Action.isDisplayed(getDriver(), formTitle);
     }
}
