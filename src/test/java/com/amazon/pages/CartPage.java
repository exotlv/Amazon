package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final By quantityInput = By.name("quantity");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void updateQuantity(int quantity) {
        WebElement quantityField = driver.findElement(quantityInput);
        quantityField.clear();
        quantityField.sendKeys(Integer.toString(quantity));
    }
}
