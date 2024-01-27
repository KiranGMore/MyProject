package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass
{
      @FindBy(id="email")
      WebElement userName;
      
      @FindBy(id="passwd")
      WebElement password;
      
      @FindBy(id="SubmitLogin")
      WebElement signInBtn;
      
      @FindBy(id="email_create")
      WebElement emailForNewAccount;
      
      @FindBy(id="SubmitCreate")
      WebElement createNewAccountBtn;
      
      public LoginPage()
      {
    	  PageFactory.initElements(getDriver(), this);
      }
      
      public HomePage login(String uName, String pswd)
      {
    	  Action.type(userName, uName);
    	  Action.type(password, pswd);
    	  Action.click(getDriver(), signInBtn);
    	  return new HomePage();
      }
      
      public AccountCreationPage createNewAccount(String newEmail)
      {
    	  Action.type(emailForNewAccount, newEmail);
    	  Action.click(getDriver(), createNewAccountBtn);
    	  return new AccountCreationPage();
      }
      
      public AddressPage login1(String uName, String pswd)
      {
    	  Action.type(userName, uName);
    	  Action.type(password, pswd);
    	  Action.click(getDriver(), signInBtn);
    	  return new AddressPage();
      } 
}
















