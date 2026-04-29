package com.jerrytest.tests.tests;

import com.jerrytest.framework.pages.InventoryPage;
import com.jerrytest.framework.pages.LoginPage;
import com.jerrytest.tests.base.BaseTest;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import static org.testng.Assert.assertEquals;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    	System.out.println(inventoryPage.getCartBadgeCount());
        Assert.assertEquals(inventoryPage.getProductsTitle(), "Products",
                "Products page title did not match expected value.");
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), 3);   
        
    }
    
    //remove item from cart, validate cart updates on page
    @Test
    public void removeItemFromCart() {     

    	inventoryPage.addBackpackToCart();
    	inventoryPage.addLightToCart();
    	inventoryPage.addRedShirtToCart();
    	inventoryPage.removeRedShirtFromCart();
		System.out.println(inventoryPage.getCartBadgeCount());

    	assertEquals(inventoryPage.getCartBadgeCount(), 2);
    }
    
    @Test
    public void standardUserDisplaysCorrectImages() {
           
        Map<String, String> expectedImages = Map.of(
        	    "Sauce Labs Backpack", "sauce-backpack-1200x1500",
        	    "Sauce Labs Bike Light", "bike-light-1200x1500",
        	    "Sauce Labs Bolt T-Shirt", "bolt-shirt-1200x1500",
        	    "Sauce Labs Fleece Jacket","sauce-pullover-1200x1500",
        	    "Sauce Labs Onesie","red-onesie-1200x1500",
        	    "Test.allTheThings() T-Shirt (Red)","red-tatt-1200x1500"
        	);
        
        List<String> failures = inventoryPage.getProductsWithIncorrectImages(expectedImages);

        Assert.assertTrue(
        	    failures.isEmpty(),
        	    "Image mismatches found for products: " + failures
        	);
    }
    
   
    
}