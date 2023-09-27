package com.amazon.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.pages.ProductListingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amazon.pages.CartPage;
import com.amazon.pages.CheckoutPage;

public class AmazonTest {
    private WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp() {

        // Initialize WebDriver (Chrome in this example)
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        // Set up ChromeOptions for incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(groups = "smoke")
    public void TestOne() {
        // Test Case 1: Go to amazon.com, add a product to cart from the Product Listing page, and complete the buying process

        driver.get("https://www.amazon.com");

        // Search for a product
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.searchProduct("English Book 2022");

        // Start buying process
        productListingPage.buyNow();
    }

    @Test(groups = "smoke")
    public void TestTwo() {
        // Test Case 2:  Go to amazon.com, add a product to cart from Product Listing page and complete the buying process.

        driver.get("https://www.amazon.com");

        //Add a product to cart from Product Listing page
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.selectProductFromList();

        // Start buying process
        productListingPage.buyNow();
    }

    @Test(groups = "smoke")
    public void TestThree() throws InterruptedException {
        // Test Case 3: Go to amazon.com, add 3 different product to cart(from any page), in cart page, increment
        //number of quantity to 2 for the first product and complete the buying process.

        driver.get("https://www.amazon.com");

        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.addThreeRandomProducts("Guide 202");

        // Go to cart and increase the quantity of the first product to 2
        productListingPage.openCartAndChangeQuantity();

        // Proceed to checkout
        productListingPage.checkout();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();  // This will close the browser window after all test methods have run
    }
}