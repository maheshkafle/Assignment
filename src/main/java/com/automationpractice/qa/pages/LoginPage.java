package com.automationpractice.qa.pages;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // Initializing Page Objects using constructor
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Page Library / Object Repo
    @FindBy(className="login")
    WebElement SignInBtn;

    @FindBy(id = "email_create")
    WebElement EmailAddress;

    @FindBy(id = "SubmitCreate")
    WebElement CreateAccountBtn;

    @FindBy(id = "customer_firstname")
    WebElement FirstName;

    @FindBy(id = "customer_lastname")
    WebElement LastName;

    @FindBy(id = "passwd")
    WebElement Password;

    @FindBy(id = "address1")
    WebElement Address1;

    @FindBy(id = "city")
    WebElement City;

    @FindBy(id = "id_state")
    WebElement State;

    @FindBy(id = "postcode")
    WebElement PostalCode;

    @FindBy(id = "id_country")
    WebElement Country;

    @FindBy(id = "phone_mobile")
    WebElement MobilePhone;

    @FindBy(id = "submitAccount")
    WebElement SubmitAccount;

    @FindBy(className="info-account")
    WebElement SuccessMsgDiv;

    @FindBy(xpath="//span[contains(text(), 'Home')]")
    WebElement HomePageBtn;

    @FindBy(id = "email")
    WebElement Email;

    @FindBy(id = "SubmitLogin")
    WebElement LoginBtn;

    // Page Actions
    public void NavigateToRegistrationPage(){
        TestUtil.doClick(SignInBtn);
    }

    public void EnterEmailAddress(){
        TestUtil.doSendKeys(EmailAddress, prop.getProperty("emailaddress"));
    }

    public void ClickOnCreateAccountBtn(){
        TestUtil.doClick(CreateAccountBtn);
    }

    public void EnterFirstName(){
        TestUtil.doSendKeys(FirstName, prop.getProperty("firstname"));
    }

    public void EnterLastName(){
        TestUtil.doSendKeys(LastName, prop.getProperty("lastname"));
    }

    public void EnterPassword(){
        TestUtil.doSendKeys(Password, prop.getProperty("password"));
    }

    public void EnterAddress1(){
        TestUtil.doSendKeys(Address1, prop.getProperty("address1"));
    }

    public void EnterCity(){
        TestUtil.doSendKeys(City, prop.getProperty("city"));
    }

    public void EnterState() throws InterruptedException {
        TestUtil.selectDropdownValue(State, prop.getProperty("statevalue"));
    }

    public void EnterPostalCode(){
        TestUtil.doSendKeys(PostalCode, prop.getProperty("postalcode"));
    }

    public void EnterCountry() throws InterruptedException {
        TestUtil.selectDropdownValue(Country, prop.getProperty("countryvalue"));
    }

    public void EnterMobilePhone(){
        TestUtil.doSendKeys(MobilePhone, prop.getProperty("mobilephone"));
    }

    public void ClickOnRegisterBtn(){
        TestUtil.doClick(SubmitAccount);
    }

    public String validateAccountCreation(){
        String msg = SuccessMsgDiv.getText();
        //System.out.println("--------"+msg+"---------");
        return msg;
    }

    public HomePage login(){

        Email.sendKeys(prop.getProperty("emailaddress"));
        Password.sendKeys(prop.getProperty("password"));
        LoginBtn.click();
        HomePageBtn.click();

        return new HomePage();
    }
}
