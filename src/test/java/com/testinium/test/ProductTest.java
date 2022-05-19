package com.testinium.test;

import com.sun.scenario.effect.impl.prism.PrDrawable;
import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

import java.util.Random;

public class ProductTest extends BaseTest {

    @Test
    public void ProductTest() {
        ProductPage productPage = new ProductPage();
        productPage.scrollAndSelect();


    }

    @Test
    public void getAttributeTest() {
        ProductPage productPage = new ProductPage();
        productPage.attributeTest();
    }

    @Test
    public void getText() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        loginPage.login();
        productPage.textControlTest();

    }

    @Test
    public void scrollTest() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        loginPage.login();
        productPage.scrollAndFind();
        productPage.randomUrunSecimi();
        productPage.favorilerim();
        productPage.sepeteGit();
        productPage.satinAl();
        productPage.odemeYontemi();
        productPage.logOut();
    }

}



