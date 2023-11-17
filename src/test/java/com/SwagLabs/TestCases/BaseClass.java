package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.SwagLabs.Pages.*;
import com.SwagLabs.Utilities.PropertiesUtil;
import com.SwagLabs.Utilities.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass
{
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckOutPage ch;
	public OverviewPage op;
	public PropertiesUtil pl;
	public ExtentReports extents;
	public  ExtentTest test;
	
	
	@BeforeSuite
	public void attchReports()
	{
		//create object of ExtentReports class
		  extents=new ExtentReports();
		  
		  //reporter
		  ExtentSparkReporter spark=new ExtentSparkReporter("./"+"\\Reports\\SwagLabs.html");
		  
		 
		  
		  spark.config().setDocumentTitle("Automation Test Report");
		  spark.config().setReportName("SwagLabs Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  //attach report
		  extents.attachReporter(spark);
		  
		  //create test
		  test=extents.createTest("SwagLab_Sprint1");
	}
	
	
	
	@BeforeTest
	public void browserSetUp()
	{
		Reporter.log("Log:Driver session created",true);
		test.log(Status.PASS,"Driver session is Created");
		driver=new ChromeDriver();
		pl=new PropertiesUtil();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pl.getData("url"));
		Reporter.log("Log:Application Launch",true);
		test.log(Status.PASS,"Swglabs application is open");
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
		lp.doLogin(pl.getData("un"),pl.getData("psw"));
		test.log(Status.PASS,"User login is completed");
		Reporter.log("Log:User login is Completed",true);
		setPause();
		System.out.println("*********Inventory Page*********");
		System.out.println("Total Products on the page:"+ip.getProductCount());
		ip.getProductNames();
		setPause();
		Utility.getScreenshot(driver);
		ip.addProductToCart(pl.getData("pname1"));
		test.log(Status.PASS,"Product added into cart");
		Reporter.log("Log:Product got added into cart",true);
		Utility.getScreenshot(driver);
		setPause();
		System.out.println("*********Cart page************");
		cp.getCartPage();
		setPause();
		cp.doRemove();
		test.log(Status.PASS,"Product remove from the cart");
		Utility.getScreenshot(driver);
		setPause();
		cp.doContinueShopping();
		test.log(Status.PASS,"Naviget to inventory page for continue shopping");
		setPause();
		ip.addProductToCart(pl.getData("pname2"));
		test.log(Status.PASS,"New product added into cart");
		setPause();
		Utility.getScreenshot(driver);
		cp.getCartPage();
		Utility.getScreenshot(driver);
		setPause();
		cp.doCheckout();
		test.log(Status.PASS,"Checkout process begins");
		setPause();
		System.out.println("*****Chckeout page************");
		ch.doContinue(pl.getData("fname"),pl.getData("lname"),pl.getData("zcode"));
		setPause();
		Reporter.log("Log:Checkout process is completed",true);
		test.log(Status.PASS,"Checkout is completed!");
				
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
	
	@AfterSuite
	public void exit()
	{
		extents.flush();
	}

}
