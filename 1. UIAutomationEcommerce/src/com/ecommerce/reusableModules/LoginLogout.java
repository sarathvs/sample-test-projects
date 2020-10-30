package com.ecommerce.reusableModules;

import org.openqa.selenium.WebDriver;
import com.ecommerce.pageobjects.LoginPage;
import com.ecommerce.pageobjects.MyAccountPage;

public class LoginLogout {

    /**
     * Login to the website
     *
     * @param driver   Webdriver instance
     * @param username login email id
     * @param password login password
     */
    public static void login(WebDriver driver, String username, String password)  {
        LoginPage login = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        login.enterEmailIdText(username);
        login.enterPasswordText(password);
        login.clickSignInButton();
        myAccountPage.viewMyAccountSection();
    }

    /**
     * Logout of the website
     * @param driver Webdriver instance
     */
    public static void logout(WebDriver driver) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        myAccountPage.clickLogoutLink();
        loginPage.viewLoginSection();
    }
}
