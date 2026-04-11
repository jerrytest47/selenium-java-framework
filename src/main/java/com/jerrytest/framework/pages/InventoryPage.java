package com.jerrytest.framework.pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector("[data-test='title']");
    private final By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public String getProductsTitle() {
        return getText(productsTitle);
    }

    public void addBackpackToCart() {
        click(backpackAddToCartButton);
    }

    public String getCartBadgeCount() {
        return getText(cartBadge);
    }
}