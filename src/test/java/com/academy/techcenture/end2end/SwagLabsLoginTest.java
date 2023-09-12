package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ProductsPage;
import org.testng.annotations.Test;

import static com.academy.techcenture.constants.Constants.*;

public class SwagLabsLoginTest extends BaseTest {

    @Test
    public void loginPositiveTest(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.verifyUserIsOnProductsPage();
    }

    @Test
    public void loginIncorrectCredentialsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, INCORRECT_PASSWORD);
        loginPage.verifyLoginError();
    }
    @Test
    public void loginEmptyCredentialsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(EMPTY_CREDS, EMPTY_CREDS);
        loginPage.verifyLoginError();
    }
}
