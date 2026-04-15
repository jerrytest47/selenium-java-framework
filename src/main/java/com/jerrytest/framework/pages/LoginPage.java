package com.jerrytest.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By productsTitle = By.cssSelector("[data-test='title']");

    public InventoryPage inventoryPageLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new InventoryPage();
    }
    
    public void enterUsername(String username) {
        enterText(usernameInput, username);
    }

    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public String getProductsTitle() {
        return getText(productsTitle);
    }
}