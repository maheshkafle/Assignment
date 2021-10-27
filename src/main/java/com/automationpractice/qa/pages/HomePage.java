package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    // Initializing Page Objects using constructor
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product-container")
    WebElement image;

    @FindBy(xpath = "//span[contains(text(), 'Add to cart')]")
    WebElement AddToCartBtn;

    @FindBy(xpath = " //span[contains(text(), 'There is 1 item in your cart.')]")
    WebElement DisplayedModal;

    @FindBy(className = "cross")
    WebElement CancelBtn;

    public void AddProductToCart() throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.moveToElement(image).build().perform();
        AddToCartBtn.click();
        Thread.sleep(4000);
    }

    public String GetAddProductToCartMsg(){
        String msg = DisplayedModal.getAttribute("innerText");
        CancelBtn.click();
        return msg;
    }
}
