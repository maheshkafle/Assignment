package com.automationpractice.qa.testcases;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    // Global Variables
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest(){
        // Call TestBase class constructor which initializes all properties
        super();
    }

    @BeforeMethod
    public void setUp(){
        Initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPage.NavigateToRegistrationPage();
        homePage = loginPage.login();
    }

    @Test(priority = 1)
    public void VerifyAddToCart() throws InterruptedException {
        homePage.AddProductToCart();
        String actualmsg = homePage.GetAddProductToCartMsg();
       // System.out.println("------"+msg+"-------");
        Assert.assertEquals(actualmsg, "\n" +
                "\t\t\t\t\t\tThere is 1 item in your cart.\n" +
                "\t\t\t\t\t");
    }

    @Test(priority = 2)
    public void VerifySearch(){
        homePage.SearchProduct();
        String actualmsg = homePage.GetSearchMsg();
        //System.out.println("------"+actualmsg+"-------");
        Assert.assertEquals(actualmsg, "5 results have been found.");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
