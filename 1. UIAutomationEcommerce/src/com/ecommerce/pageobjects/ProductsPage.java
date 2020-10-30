package com.ecommerce.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCategoryTab(String category) {
        String temp = "//a[@title='" + category + "']";
        driver.findElement(By.xpath(temp)).click();
    }

    public void selectSizeCheckbox(String size) {
        String temp = "//a[contains(@href,'size') and contains(text()," +size+ ")]/parent::label/parent::li/div/span/input";
        driver.findElement(By.xpath(temp)).click();
    }

    public void selectColorCheckbox(String color) {
        String temp = "//a[contains(@href,'color') and contains(text()," + color + ")]/parent::label/parent::li/input";
        driver.findElement(By.xpath(temp)).click();
    }

    public void selectCompositionCheckbox(String composition) {
        String temp = "//a[contains(@href,'composition') and contains(text()," +composition+ ")]/parent::label/parent::li/div/span/input";
        driver.findElement(By.xpath(temp)).click();
    }

    public int getCountOfProductsDisplayed() {
        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,\"ajax_block_product\")]"));
        return list.size();
    }

    public void selectProductImage(String product) {
        String temp = "(//div[@class='product-image-container']/a[contains(@href,'product') and @title='" +product + "'])[1]/parent::div";

        WebElement element = driver.findElement(By.xpath(temp));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(temp)));

        driver.findElement(By.xpath(temp)).click();
    }

    public String getProductAtIndex(int index) {
        String temp = "(//div[@class='product-container']/div/h5/a)[" + index + "]";
        return driver.findElement(By.xpath(temp)).getText();
    }

}