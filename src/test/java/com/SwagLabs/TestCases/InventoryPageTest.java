package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass
{
	
	
  @Test(priority=1)
  public void verifyProductCount()
  {
	  int count=ip.getProductCount();
	  Assert.assertTrue(count==6,"Count of product is invalid");
	  System.out.println("Product count is valid: "+count);
  }
  
  @Test(priority=2)
  public void verifyProductName()
  {
	  ip.getProductNames();
  }
  
  
  @Test(priority=3)
  public void verifyAddProductTocart()
  {
	  ip.addProductToCart("Sauce Labs Onesie");
	  
	  
  }
}
