package com.ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmailIdText(String emailId) {
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys(emailId);
    }

    public void clickCreateAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void selectTitleRadioButton(String title) {
        if (title.equals("Mr.")) {
            driver.findElement(By.id("id_gender1")).click();
        } else {
            driver.findElement(By.id("id_gender2")).click();
        }
    }

    public void enterFirstNameText(String fname) {
        driver.findElement(By.id("customer_firstname")).sendKeys(fname);
    }

    public void enterLastNameText(String lname) {
        driver.findElement(By.id("customer_lastname")).sendKeys(lname);
    }

    public void enterPasswordText(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void enterFirstNameAddressText(String fname) {
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(fname);
    }

    public void enterLastNameAddressText(String lname) {
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(lname);
    }

    public void enterAddressText(String address) {
        driver.findElement(By.id("address1")).sendKeys(address);
    }

    public void enterCityText(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void selectStateDropdown(String state) {
        driver.findElement(By.id("id_state")).sendKeys(state);
    }

    public void enterZipCodeText(String code) {
        driver.findElement(By.id("postcode")).sendKeys(code);
    }

    public void selectCountryDropdown(String country) {
        driver.findElement(By.id("id_country")).sendKeys(country);
    }

    public void enterMobilePhoneText(String mPhone) {
        driver.findElement(By.id("phone_mobile")).sendKeys(mPhone);
    }

    public void enterAliasText(String alias) {
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(alias);
    }

    public void clickRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }

}
