package com.ecommerce.reusableModules;

import com.ecommerce.pageobjects.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class CartCheckout {

    /**
     * Check out flow
     *
     * @param driver   Webdriver instance
     * @param paymentType Payment type (by Wire or Cheque)
     */
    public static void cartCheckout(WebDriver driver, String paymentType)  {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCartButton();
        checkoutPage.clickSummarySectionProceedToCheckoutButton();
        checkoutPage.clickAddressSectionProceedToCheckoutButton();
        checkoutPage.selectTermsOfServiceCheckbox();
        checkoutPage.clickShippingSectionProceedToCheckoutButton();
        checkoutPage.selectPaymentmentButton(paymentType);
        checkoutPage.clickConfirmOrderButton();
    }


    /**
     * Checkout confirmation
     *
     * @param driver   Webdriver instance
     * @param paymentType Type of payment
     * @return confirmation string
     */
    public static String returnCheckoutConfirmation(WebDriver driver, String paymentType) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getConfirmationText(paymentType);
    }

    /**
     * Remove from cart
     *
     * @param driver   Webdriver instance
     * @param itemnumber Item number to be removed from cart
     */
    public static void removeFromCart(WebDriver driver, int itemnumber)  {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCartButton();
        checkoutPage.clickDeleteButton(itemnumber);
    }

    /**
     * Return product at index from cart
     *
     * @param driver   Webdriver instance
     * @param index index of Item in cart
     * @return product name at the chosen index
     */
    public static String returnProductAtIndex(WebDriver driver, int index) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCartButton();
        return checkoutPage.getProductAtIndex(index);

    }
}
