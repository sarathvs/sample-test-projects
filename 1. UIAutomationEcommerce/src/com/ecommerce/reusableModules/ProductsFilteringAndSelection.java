package com.ecommerce.reusableModules;

import com.ecommerce.pageobjects.ProductPage;
import com.ecommerce.pageobjects.ProductsPage;
import org.openqa.selenium.WebDriver;

public class ProductsFilteringAndSelection {

    /**
     * Select the section of products
     *
     * @param driver   Webdriver instance
     * @param section Section to view products
     */
    public static void selectSection(WebDriver driver, String section)  {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectCategoryTab(section);
    }

    /**
     * Filter products by size
     *
     * @param driver   Webdriver instance
     * @param size Size filter
     */
    public static void filterBySize(WebDriver driver, String size)  {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectSizeCheckbox(size);
    }

    /**
     * Filter products by color
     *
     * @param driver   Webdriver instance
     * @param color Color filter
     */
    public static void filterByColor(WebDriver driver, String color)  {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectColorCheckbox(color);
    }

    /**
     * Filter products by composition
     *
     * @param driver   Webdriver instance
     * @param composition Composition filter
     */
    public static void filterByComposition(WebDriver driver, String composition)  {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectCompositionCheckbox(composition);
    }


    /**
     * Filter products by composition
     *
     * @param driver   Webdriver instance
     * @return count Count of filtered products
     */
    public static int returnFilteredCount(WebDriver driver) {
        ProductsPage productsPage = new ProductsPage(driver);
        return productsPage.getCountOfProductsDisplayed();
    }


    /**
     * Select products and add to cart and continue shopping
     *
     * @param driver   Webdriver instance
     * @param product product to be selected and added to cart
     */
    public static void selectAddProduct(WebDriver driver, String product) throws Exception {
        ProductsPage productsPage = new ProductsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        productsPage.selectProductImage(product);
        productPage.clickAddToCartButton();
        productPage.clickContinueShoppingButton();
    }

    /**
     * Select products and add to cart and continue shopping
     *
     * @param driver   Webdriver instance
     * @param index index of product
     * @return product name at index
     */
    public static String getProductNameAtIndex(WebDriver driver, int index) throws Exception {
        ProductsPage productsPage = new ProductsPage(driver);
        return productsPage.getProductAtIndex(index);
    }


}
