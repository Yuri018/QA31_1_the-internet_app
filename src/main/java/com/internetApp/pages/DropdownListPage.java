package com.internetApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownListPage extends BasePage {
    public DropdownListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/dropdown']")
    WebElement dropdownList;

    public DropdownListPage openDropdownPage() {
        click(dropdownList);
        return this;
    }

    @FindBy(id = "dropdown")
    WebElement selectDropdownList;

    public DropdownListPage selectOption(String text) {
        Select select = new Select(selectDropdownList);
        select.selectByVisibleText(text);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        return this;
    }

}
