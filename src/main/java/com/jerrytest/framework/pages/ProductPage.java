package com.jerrytest.framework.pages;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jerrytest.framework.driver.DriverFactory;

public class ProductPage extends BasePage {
	
private final WebElement BigImage = driver.findElement(By.cssSelector("[src^='/static/media/']"));

public String getbackpackImageSmall() {
	 String src = BigImage.getDomAttribute("src");
	 return src;
}


}
