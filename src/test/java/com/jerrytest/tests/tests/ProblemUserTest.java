package com.jerrytest.tests.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jerrytest.framework.pages.InventoryPage;
import com.jerrytest.framework.pages.LoginPage;
import com.jerrytest.tests.base.BaseTest;

public class ProblemUserTest extends BaseTest{
    private InventoryPage inventoryPage;

	 @BeforeMethod
		public void setUpInventoryPage() {
			LoginPage loginPage = new LoginPage();
	        inventoryPage = loginPage.inventoryPageLogin("problem_user", "secret_sauce");
		}	
	
	 @Test
	    public void problemUserDisplaysWrongImages() {
	        	        
	        Map<String, String> expectedImages = Map.of(
	        	    "Sauce Labs Backpack", "sauce-backpack-1200x1500",
	        	    "Sauce Labs Bike Light", "bike-light-1200x1500",
	        	    "Sauce Labs Bolt T-Shirt", "bolt-shirt-1200x1500",
	        	    "Sauce Labs Fleece Jacket","sauce-pullover-1200x1500",
	        	    "Sauce Labs Onesie","red-onesie-1200x1500",
	        	    "Test.allTheThings() T-Shirt (Red)","red-tatt-1200x1500"
	        	);
	        List<String> failures = inventoryPage.getProductsWithIncorrectImages(expectedImages);

	        Assert.assertFalse(
	            failures.isEmpty(),
	            "Expected incorrect images but all were correct"
	        );
	        
	    }
	
}
