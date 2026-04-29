package com.jerrytest.framework.pages;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jerrytest.framework.driver.DriverFactory;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector("[data-test='title']");
    private final By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By lightAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By redShirtAddToCartButton = By.cssSelector("[data-test='add-to-cart-test.allthethings()-t-shirt-(red)']");
    private final By redShirtRemoveFromCartButton = By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']");
   
    public void removeRedShirtFromCart() {
    	click(redShirtRemoveFromCartButton);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(cartBadge, "2"));
    }
    
    public Map<String, String> getProductImageMap() {
        Map<String, String> actualMap = new HashMap<>();

        List<WebElement> items = driver.findElements(By.className("inventory_item"));

        for (WebElement item : items) {
        	
            String name = item.findElement(By.className("inventory_item_name")).getText();
            String src = item.findElement(By.cssSelector("img.inventory_item_img"))
                    .getDomAttribute("src");
            if (src == null) {
                actualMap.put(name, "");
                continue;
            }
            String fileName = src.substring(src.lastIndexOf("/") + 1);
            actualMap.put(name, fileName);
        }
        System.out.println(actualMap);
        return actualMap;
    }
    
    public List<String> getProductsWithIncorrectImages(Map<String, String> expectedImages) {
        Map<String, String> actualImages = getProductImageMap();
        List<String> failures = new ArrayList<>();

        for (String product : expectedImages.keySet()) {
            String actual = actualImages.get(product);
            String expected = expectedImages.get(product);

            if (actual == null || !actual.contains(expected)) {
                failures.add(product);
            }
        }

        return failures;
    }
  

    
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
    	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(cartBadge, "3"));
    }
      
}