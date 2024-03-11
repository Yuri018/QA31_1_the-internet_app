package com.internetApp.tests;

import com.internetApp.pages.WindowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new WindowPage(driver).openWindowPage();
    }

    @Test
    public void openWindowTest() {
        new WindowPage(driver).openWindow(1);
    }
}