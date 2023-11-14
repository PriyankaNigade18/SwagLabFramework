package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.SwagLabs.Pages.*;
import com.SwagLabs.Utilities.Utility;

public class BaseClass
{
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckOutPage ch;
	public OverviewPage op;
	
	@BeforeTest
	public void browserSetUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		lp=new LoginPage(driver);
		ip=new InventoryPage(driver);
		cp=new CartPage(driver);
		ch=new CheckOutPage(driver);
		op=new OverviewPage(driver);
		
		
		
		
	}
	
	
	
	@BeforeClass
	public void pageSetUp()
	{
		System.out.println("**********Login Page***********");
		
		System.out.println("Application url is:"+lp.getAppUrl());
		System.out.println("Application title is: "+lp.getAppTitle());
		setPause();
		lp.doLogin("standard_user","secret_sauce");
		setPause();
		System.out.println("*********Inventory Page*********");
		System.out.println("Total Products on the page:"+ip.getProductCount());
		ip.getProductNames();
		setPause();
		Utility.getScreenshot(driver);
		ip.addProductToCart("Sauce Labs Bolt T-Shirt");
		Utility.getScreenshot(driver);
		setPause();
		System.out.println("*********Cart page************");
		cp.getCartPage();
		setPause();
		cp.doRemove();
		Utility.getScreenshot(driver);
		setPause();
		cp.doContinueShopping();
		setPause();
		ip.addProductToCart("Test.allTheThings() T-Shirt (Red)");
		setPause();
		Utility.getScreenshot(driver);
		cp.getCartPage();
		Utility.getScreenshot(driver);
		setPause();
		cp.doCheckout();
		setPause();
		System.out.println("*****Chckeout page************");
		ch.doContinue("Priyanka","Nigade","411047");
		setPause();
		
				
	}
	
	public void setPause()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
