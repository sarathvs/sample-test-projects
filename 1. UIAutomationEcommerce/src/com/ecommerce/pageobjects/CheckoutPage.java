package com.ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getProductAtIndex(int index) {
        String temp = "(//td[@class='cart_description']/p/a)[" + index + "]";
        return driver.findElement(By.xpath(temp)).getText();
    }

    public void clickDeleteButton(int itemnumber) {
        String temp = "(//a[@class='cart_quantity_delete'])[" + itemnumber + "]";
        driver.findElement(By.xpath(temp)).click();
    }

    public void selectCartButton() {
        driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]")).click();
    }

    public void clickSummarySectionProceedToCheckoutButton() {
        driver.findElement(By.xpath("//a[contains(@title,\"Proceed to checkout\") and contains(@class,\"standard-checkout\")]")).click();
    }

    public void clickAddressSectionProceedToCheckoutButton() {
        driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to checkout')]/parent::button")).click();
    }

    public void selectTermsOfServiceCheckbox() {
        driver.findElement(By.xpath("//input[@name=\"cgv\"]")).click();
    }

    public void clickShippingSectionProceedToCheckoutButton() {
        driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to checkout')]/parent::button")).click();
    }

    public void selectPaymentmentButton(String paymentType) {
        if (paymentType.equals("cheque")) {
            driver.findElement(By.xpath("//a[@class=\"cheque\"]")).click();
        } else {
            driver.findElement(By.xpath("//a[@class=\"bankwire\"]")).click();
        }
    }

    public void clickConfirmOrderButton() {
        driver.findElement(By.xpath("//button/span[contains(text(),'I confirm my order')]/parent::button")).click();
    }

    public String getConfirmationText(String paymentType) {
        WebDriverWait wait = new WebDriverWait(driver,30);

        if (paymentType.equals("cheque")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your order on My Store is complete.')]")));
            return driver.findElement(By.xpath("//p[contains(text(),'Your order on My Store is complete.')]")).getText();

        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/strong[contains(text(),'Your order on My Store is complete.')]")));
            return driver.findElement(By.xpath("//p/strong[contains(text(),'Your order on My Store is complete.')]")).getText();
        }
    }
}