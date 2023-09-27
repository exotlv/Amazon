package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By checkoutButton = By.id("hlb-ptc-btn-native");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
