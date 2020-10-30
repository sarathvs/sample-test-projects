package com.ecommerce.tests;

import com.ecommerce.reusableModules.LoginLogout;
import com.ecommerce.reusableModules.Registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ecommerce.reusableModules.GetExcelData;
import com.ecommerce.utilities.Constants;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 * RegistrationTest.java - has registration test with details from xlsx
 * Test verifies successful registration
 * @author Sarath Babu V S
 * @version 1.0
 */

public class RegistrationTest {

    String driverPath = ".//lib//chromedriver.exe";
    WebDriver driver;


    @BeforeClass
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.loginUrl);
    }


    @DataProvider(name = "Registration Data")
    public Object[][] dat(){
        return GetExcelData.getExcelData(Constants.registrationData,"Sheet1");
    }


    @Test(dataProvider="Registration Data")
    public void testRegisterUser(String email, String title, String fname, String lname,
                                 String password, String addressFname, String addressLname, String address,
                                 String city, String state, String zipcode, String country, String mPhone, String alias) throws Exception{


        Date date = new Date();
        long timeMilli = date.getTime();

        String newEmail = email+timeMilli+"@test.com";

        Registration.registorWithMandatoryFields(driver, newEmail, title, fname, lname,password,
                addressFname,addressLname, address, city, state, zipcode, country, mPhone, alias);
        Assert.assertTrue(driver.getTitle().equals("My account - My Store"));
    }

    @AfterClass
    public void teardown() {
        LoginLogout.logout(driver);
        driver.quit();
    }
}
