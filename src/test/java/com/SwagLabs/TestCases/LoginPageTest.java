package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass
 {
  @Test(priority=1)
  public void verifyUrl() 
  {
	  
	  String url=lp.getAppUrl();
	  Assert.assertTrue(url.contains("demo"),"Url not match!");
	  System.out.println("URL is matched!: "+url);
	  
  }
  
  @Test(priority=2)
  public void verifyTitle() 
  {
	  String title=lp.getAppTitle();
	  Assert.assertEquals(title,"Swag Labs","Title not matched!");
	  System.out.println("Title matched!: "+title);
  }
  
  @Test(priority=3)
  public void verifyLogin() 
  {
	  lp.doLogin("standard_user","secret_sauce");
	  Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Login Fail!");
	  System.out.println("Login Completed! User is navigated to Inventory page");
  }
}
