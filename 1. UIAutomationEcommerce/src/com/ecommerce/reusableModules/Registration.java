package com.ecommerce.reusableModules;
import org.openqa.selenium.WebDriver;
import com.ecommerce.pageobjects.MyAccountPage;
import com.ecommerce.pageobjects.RegistrationPage;
import com.ecommerce.pageobjects.LoginPage;

public class Registration {
    /**
     * Registration of a new user
     * @param driver Webdriver instance
     * @param email User's email id
     * @param title User's title
     * @param fname User's First name
     * @param lname User's Last name
     * @param password User's password
     * @param addressFname User's First name in contact address
     * @param addressLname User's Last name in contact address
     * @param address User's address
     * @param city User's city
     * @param state User's state
     * @param zipcode User's zipcode
     * @param country User's country
     * @param mPhone User's mobile phone number
     * @param alias address alias
     */

    public static void registorWithMandatoryFields(WebDriver driver, String email, String title, String fname, String lname,
                                                   String password, String addressFname, String addressLname, String address,
                                                   String city, String state, String zipcode, String country, String mPhone, String alias)  {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage= new MyAccountPage(driver);

        registrationPage.enterEmailIdText(email);
        registrationPage.clickCreateAccountButton();

        registrationPage.selectTitleRadioButton(title);
        registrationPage.enterFirstNameText(fname);
        registrationPage.enterLastNameText(lname);
        registrationPage.enterPasswordText(password);
        registrationPage.enterFirstNameAddressText(addressFname);
        registrationPage.enterLastNameAddressText(addressLname);
        registrationPage.enterAddressText(address);
        registrationPage.enterCityText(city);
        registrationPage.selectStateDropdown(state);
        registrationPage.enterZipCodeText(zipcode);
        registrationPage.selectCountryDropdown(country);
        registrationPage.enterMobilePhoneText(mPhone);
        registrationPage.enterAliasText(alias);
        registrationPage.clickRegisterButton();
        myAccountPage.viewMyAccountSection();

    }
}
