package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.sisu.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.atomic.AtomicInteger;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class BaseClass 
{
	
     public static Properties prop;
  //   public static WebDriver driver;
     //declare ThreadLocal driver
     public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
     
     @BeforeSuite(groups = {"Smoke","Sanity","Regression"})
     public void loadConfig() throws IOException
     {
    	 ExtentManager.setExtent();
    	 DOMConfigurator.configure("log4j.xml");
    	 
    	 try {
    		 prop = new Properties();
    		 System.out.println("Super Constructor Invoked");
    		 FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
    		 prop.load(ip);
    	 }catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
     }
     
     public static WebDriver getDriver()
     {
    	 //Get driver from ThreadLocal
    	 return driver.get();
     }
	
     public static void launchApp(String browserName)
     {
    	// String browserName = prop.getProperty("browser");
    	 
    	if( browserName.equalsIgnoreCase("Chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		//driver = new ChromeDriver();
    		driver.set(new ChromeDriver());
    	}
    	else if ( browserName.contains("IE"))
    	{
    		//driver = new InternetExplorerDriver();
    		driver.set(new InternetExplorerDriver());
    	}
    	
    	else if (browserName.contains("Edge"))
    	{
    		WebDriverManager.edgedriver().setup();
    		//driver = new EdgeDriver();
    		driver.set(new EdgeDriver());
    	}
     	 Action.implicitWait(getDriver(), 10);
    	 Action.pageLoadTimeOut(getDriver(), 30);
    	 
    	getDriver().get(prop.getProperty("url"));
    	 
      }
     
     @AfterSuite
     public void afterSuit()
     {
    	 ExtentManager.endReport();
     }
     
}
