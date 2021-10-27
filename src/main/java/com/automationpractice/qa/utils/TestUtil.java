package com.automationpractice.qa.utils;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtil extends TestBase {

    public static void doClick(WebElement locator){
        locator.click();
    }

    public static void doSendKeys(WebElement locator, String text){
        locator.clear();
        locator.sendKeys(text);
    }

    public static void selectDropdownValue( WebElement locator, String value) throws InterruptedException {
        Select dropdown_option = new Select(locator);
        dropdown_option.selectByValue(value);
        Thread.sleep(1000);
    }


}
