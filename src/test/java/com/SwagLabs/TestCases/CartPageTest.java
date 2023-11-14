package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CartPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyPageLaunch()
  {
	  cp.getCartPage();
	  setPause();
  }
  
  @Test(priority=2)
  public void verifyRemove()
  {
	  cp.doRemove();
	  setPause();
  }
  
  
  @Test(priority=3)
  public void verifyContinueShopping()
  {
	  cp.doContinueShopping();
	  setPause();
	  ip.addProductToCart("Sauce Labs Fleece Jacket");
	  setPause();
	  cp.getCartPage();
	  setPause();
  }
  
  @Test(priority=4)
  public void verifyCheckout()
  {
	  cp.doCheckout();
  }
}
