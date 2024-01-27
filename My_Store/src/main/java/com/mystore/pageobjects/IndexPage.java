package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass
{
     @FindBy(xpath = "//a[@class='login']")
     WebElement signInBtn;
     
     @FindBy(xpath = "//img[@class='logo img-responsive']")
     WebElement myStoreLogo;
     
     @FindBy(id="search_query_top")
     WebElement searchProductBox;
     
     @FindBy(name="submit_search")
     WebElement searchButton;
     
     public IndexPage()
     {
    	 PageFactory.initElements(getDriver(), this);
     }
     
     public LoginPage clickOnSignIn()
     {
    	 Action.click(getDriver(), signInBtn);
    	 return new LoginPage();
     }
     
     public boolean validateLogo()
     {
    	 return Action.isDisplayed(getDriver(), myStoreLogo);
     }
     
     public String getMyStoreTitle()
     {
    	 String myStoreTitle = getDriver().getTitle();
    	 return myStoreTitle;
     }
     
     public SearchResultPage searchProduct(String producName)
     {
    	 Action.type(searchProductBox, producName);
    	 Action.click(getDriver(), searchButton);
    	 return new SearchResultPage();
     }
}





















