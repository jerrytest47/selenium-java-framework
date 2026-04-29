package com.jerrytest.tests.base;

import com.jerrytest.framework.driver.DriverFactory;
import com.jerrytest.framework.pages.InventoryPage;
import com.jerrytest.framework.pages.LoginPage;
import com.jerrytest.framework.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }
    

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}