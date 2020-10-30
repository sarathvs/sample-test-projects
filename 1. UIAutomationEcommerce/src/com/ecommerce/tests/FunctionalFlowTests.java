package com.ecommerce.tests;

import com.ecommerce.reusableModules.CartCheckout;
import com.ecommerce.reusableModules.GetExcelData;
import com.ecommerce.reusableModules.LoginLogout;
import com.ecommerce.reusableModules.ProductsFilteringAndSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.ecommerce.utilities.Constants;

/**
 * FunctionFlowTests.java - has functional flows
 * @author Sarath Babu V S
 * @version 1.0
 */

public class FunctionalFlowTests {

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


    @DataProvider(name = "Login Data")
    public Object[][] dat(){
        return GetExcelData.getExcelData(Constants.loginData,"Sheet1");
    }


    @Test(dataProvider="Login Data")
    public void loginTest(String username, String password) throws Exception{
        LoginLogout.login(driver,username,password);
    }

    @Test(dependsOnMethods = "loginTest")
    public void filterProductTest() throws Exception {
        ProductsFilteringAndSelection.selectSection(driver, Constants.section);
        ProductsFilteringAndSelection.filterByColor(driver,Constants.color);
        ProductsFilteringAndSelection.filterBySize(driver, Constants.size);
        ProductsFilteringAndSelection.filterByComposition(driver,Constants.composition);
        Assert.assertEquals(ProductsFilteringAndSelection.returnFilteredCount(driver), 3);
        Assert.assertEquals(ProductsFilteringAndSelection.getProductNameAtIndex(driver, 1),"Faded Short Sleeve T-shirts");
        Assert.assertEquals(ProductsFilteringAndSelection.getProductNameAtIndex(driver, 2),"Printed Dress");
        Assert.assertEquals(ProductsFilteringAndSelection.getProductNameAtIndex(driver, 3),"Printed Summer Dress");

    }

    @Test(dependsOnMethods = "loginTest")
    public void addDeleteProductsCheckout() throws Exception {
        ProductsFilteringAndSelection.selectSection(driver, Constants.section);
        ProductsFilteringAndSelection.selectAddProduct(driver,Constants.product1);
        ProductsFilteringAndSelection.selectSection(driver, Constants.section);
        ProductsFilteringAndSelection.selectAddProduct(driver,Constants.product2);
        ProductsFilteringAndSelection.selectSection(driver, Constants.section);
        ProductsFilteringAndSelection.selectAddProduct(driver,Constants.product3);

        Assert.assertEquals(CartCheckout.returnProductAtIndex(driver,1), "Faded Short Sleeve T-shirts");
        Assert.assertEquals(CartCheckout.returnProductAtIndex(driver,2), "Printed Dress");
        Assert.assertEquals(CartCheckout.returnProductAtIndex(driver,3), "Printed Summer Dress");

        CartCheckout.removeFromCart(driver,1);

        Assert.assertEquals(CartCheckout.returnProductAtIndex(driver,1), "Printed Dress");
        Assert.assertEquals(CartCheckout.returnProductAtIndex(driver,2), "Printed Summer Dress");


        CartCheckout.cartCheckout(driver,"cheque");
        Assert.assertEquals(CartCheckout.returnCheckoutConfirmation(driver,"cheque"), "Your order on My Store is complete.");
    }

    @AfterClass
    public void teardown() {
        LoginLogout.logout(driver);
        driver.quit();
    }
}
