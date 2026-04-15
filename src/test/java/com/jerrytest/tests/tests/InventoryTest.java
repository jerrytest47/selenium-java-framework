package com.jerrytest.tests.tests;

import com.jerrytest.framework.pages.InventoryPage;
import com.jerrytest.framework.pages.LoginPage;
import com.jerrytest.tests.base.BaseTest;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
	
    private InventoryPage inventoryPage;

	
	@BeforeMethod
	public void setUpInventoryPage() {
		LoginPage loginPage = new LoginPage();
        inventoryPage = loginPage.inventoryPageLogin("standard_user", "secret_sauce");
	}
	
	
	 @Test
	 public void productsTitleShouldBeVisible() {
	        Assert.assertEquals(inventoryPage.getProductsTitle(), "Products");
	    }
	
	//add items to cart
    @Test
    public void addItemsToCartTest() {
        
    	inventoryPage.addBackpackToCart();
    	inventoryPage.addLightToCart();
    	inventoryPage.addRedShirtToCart();

    	
        Assert.assertEquals(inventoryPage.getProductsTitle(), "Products",
                "Products page title did not match expected value.");
        Assert.assertEquals(3, inventoryPage.getCartBadgeCount());
        
		 System.out.println(inventoryPage.getCartBadgeCount());

    }
    //remove item from cart, validate cart updates on page
    @Test
    public void removeItemFromCart() {     

    	inventoryPage.addBackpackToCart();
    	inventoryPage.addLightToCart();
    	inventoryPage.addRedShirtToCart();
    	inventoryPage.removeRedShirtFromCart();
      
    	assertEquals(2, inventoryPage.getCartBadgeCount());
    }
    
    
}