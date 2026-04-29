package com.jerrytest.tests.tests;

import com.jerrytest.framework.pages.InventoryPage;
import com.jerrytest.framework.pages.LoginPage;
import com.jerrytest.tests.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(inventoryPage.getProductsTitle(), "Products",
                "Products page title did not match expected value.");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected login error message was not displayed.");
    }
    

    @Test
    public void lockedOutUserLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Sorry, this user has been locked out."),
                "Expected lockout error message was not displayed.");
    }
       
}