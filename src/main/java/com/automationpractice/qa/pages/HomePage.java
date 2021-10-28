package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(id = "search_query_top")
    WebElement SearchBox;

    @FindBy(className = "button-search")
    WebElement SubmitSearchBtn;

    @FindBy(className = "heading-counter")
    WebElement DivSearchMsg;

    @FindBy(css = ".facebook > a:nth-child(1)")
    WebElement FacebookLink;

    @FindBy(css = ".twitter > a:nth-child(1)")
    WebElement TwitterLink;

    @FindBy(css = ".youtube > a:nth-child(1)")
    WebElement YoutubeLink;

    @FindBy(css = ".google-plus > a:nth-child(1)")
    WebElement GooglePlusLink;


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

    public void SearchProduct(){
        TestUtil.doSendKeys(SearchBox, prop.getProperty("searchtext"));
        SubmitSearchBtn.click();
    }

    public String GetSearchMsg(){
        String msg = DivSearchMsg.getAttribute("innerText");
        return msg;
    }

    public void ClickFacebookLink() {
       TestUtil.doClick(FacebookLink);
    }

    public void ClickTwitterLink() {
        TestUtil.doClick(TwitterLink);
    }

    public void ClickYoutubeLink() {
        TestUtil.doClick(YoutubeLink);
    }

    public void ClickGooglePlusLink() {
        TestUtil.doClick(GooglePlusLink);
    }

}
