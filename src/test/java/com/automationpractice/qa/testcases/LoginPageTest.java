package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    // Global Variables
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        // Call TestBase class constructor which initializes all properties
        super();
    }

    @BeforeMethod
    public void setUp(){
        Initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void RegisterUser() throws InterruptedException {
        loginPage.NavigateToRegistrationPage();
        loginPage.EnterEmailAddress();
        loginPage.ClickOnCreateAccountBtn();
        loginPage.EnterFirstName();
        loginPage.EnterLastName();
        loginPage.EnterPassword();
        loginPage.EnterAddress1();
        loginPage.EnterCity();
        loginPage.EnterState();
        loginPage.EnterPostalCode();
        loginPage.EnterCountry();
        loginPage.EnterMobilePhone();
        loginPage.ClickOnRegisterBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
