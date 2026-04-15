package com.jerrytest.framework.pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector("[data-test='title']");
    private final By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By lightAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By redShirtAddToCartButton = By.cssSelector("[data-test='add-to-cart-test.allthethings()-t-shirt-(red)']");
    private final By redShirtRemoveFromCartButton = By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']");
    //private final By cart //span[@class='shopping_cart_badge']
  
    public String getProductsTitle() {
        return getText(productsTitle);
    }

    public void addBackpackToCart() {
        click(backpackAddToCartButton);
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
    
    public void addLightToCart() {
    	click(lightAddToCartButton);
    }
    
    public void addRedShirtToCart() {
    	click(redShirtAddToCartButton);
    }
    
    public void removeRedShirtFromCart() {
    	click(redShirtRemoveFromCartButton);
    }
    
}