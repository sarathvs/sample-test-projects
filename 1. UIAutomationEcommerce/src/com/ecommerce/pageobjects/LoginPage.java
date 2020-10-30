package com.ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmailIdText(String emailId) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(emailId);
    }

    public void enterPasswordText(String password) {
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void viewLoginSection() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign in')]")));
        return;
    }

}
