package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.Assert;
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
    public void VerifyUserRegistration() throws InterruptedException {
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
        String expectedmsg = loginPage.validateAccountCreation();
        Assert.assertEquals(expectedmsg,prop.getProperty("actualmsg"));
    }

    @Test(priority = 2)
    public void VerifyLogin() {
        loginPage.NavigateToRegistrationPage();
        homePage = loginPage.login();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
