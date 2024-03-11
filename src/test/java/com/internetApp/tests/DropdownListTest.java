package com.internetApp.tests;

import com.internetApp.pages.DropdownListPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListTest extends TestBase{
    
    @BeforeMethod
    public void precondition(){
        new DropdownListPage(driver).openDropdownPage();
    }

    @Test
    public void selectOptionTest(){
        new DropdownListPage(driver).selectOption("Option 2");
    }

}
