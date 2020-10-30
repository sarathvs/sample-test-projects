package com.ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe")));

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//body[@id='product']//button[@type='submit']")).click();
        driver.switchTo().defaultContent();

    }

    public void clickContinueShoppingButton() {
        driver.findElement(By.xpath("//div/span[contains(@title,\"Continue shopping\")]/parent::div")).click();
    }

    public void clickProceedToCheckoutButton() {
        driver.findElement(By.xpath("//a[contains(@title,\"Proceed to checkout\")]")).click();
    }

}