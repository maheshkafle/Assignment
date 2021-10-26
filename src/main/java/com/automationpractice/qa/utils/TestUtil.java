package com.automationpractice.qa.utils;

import com.automationpractice.qa.base.TestBase;
import org.openqa.selenium.WebElement;

public class TestUtil extends TestBase {

    public static void doClick(WebElement locator){
        locator.click();
    }

}
