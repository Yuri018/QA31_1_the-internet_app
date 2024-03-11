package com.internetApp.tests;

import com.internetApp.pages.RedirectionPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedirectionTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new RedirectionPage(driver).openRedirectPage();
    }

    @Test
    public void checkRedirectLinks() {
        new RedirectionPage(driver).clickHereLink();
        new RedirectionPage(driver).checkStatusCodesLink();
    }
}
