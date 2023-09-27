package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListingPage extends BasePage {
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By selectItem = By.cssSelector(".a-section .s-image-fixed-height");
    private By selectItemFrom = By.cssSelector(".a-section .s-image");
    private By buyNowButton = By.id("buy-now-button");
    private By itemFromList = By.cssSelector("#desktop-4 .deals-shoveler .feed-carousel-card[data-csa-c-posx='1']");
    private By addToCartButton = By.id("add-to-cart-button");
    private By openCart = By.id("nav-cart-count-container");
    private By quantityBox = By.cssSelector(".sc-action-quantity");
    private By changeQuantity = By.cssSelector(".a-popover-wrapper [aria-labelledby=\"quantity_2\"]");
    private By update = By.name("update");
    private By proceedToCheckout = By.name("proceedToRetailCheckout");

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        WebElement searchInput = driver.findElement(searchBox);
        driver.findElement(searchBox).click();
        searchInput.sendKeys(productName);
        driver.findElement(searchButton).click();
        driver.findElement(selectItem).click();

    }

    public void selectProductFromList() {
        driver.findElement(itemFromList).click();
    }

    public void addThreeRandomProducts(String productName) throws InterruptedException {
        // Add 3 different products to the cart
        for (int i = 0; i < 3; i++) {
            WebElement searchInput = driver.findElement(searchBox);
            driver.findElement(searchBox).click();
            searchInput.sendKeys(productName + i);
            driver.findElement(searchButton).click();
            driver.findElement(selectItemFrom).click();
            driver.findElement(addToCartButton).click();

            // Wait a bit for any popups or modals to close
            Thread.sleep(2000);
        }
    }

    public void openCartAndChangeQuantity(){
        driver.findElement(openCart).click();
        driver.findElement(quantityBox).click();
        driver.findElement(changeQuantity).click();
    }

    public void checkout(){
        driver.findElement(proceedToCheckout).click();
    }
    public void buyNow() {
        driver.findElement(buyNowButton).click();
    }
}
