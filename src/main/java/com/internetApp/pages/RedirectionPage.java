package com.internetApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RedirectionPage extends BasePage {
    public RedirectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/redirector']")
    WebElement redirectPage;

    public RedirectionPage openRedirectPage() {
        clickWithJS(redirectPage, 0, 500);
        return this;
    }

    @FindBy(id = "redirect")
    WebElement hereLink;

    public RedirectionPage clickHereLink() {
        click(hereLink);
        return this;
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public RedirectionPage checkStatusCodesLink() {
        for (WebElement element : allLinks) {
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " is broken link");
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + " link with exception");
        }
    }
}
