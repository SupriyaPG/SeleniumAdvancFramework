package com.spgtesting.pages.pageObjectModel.appvwo;

import com.spgtesting.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){

        this.driver=driver;

    }

    private By userNameOnDashboard=By.cssSelector("[data-qa=\"lufexuloga\"]");

    //page actions
    public String loggedInUserName(){

        waitHelpers.waitJVM(2000);
        return driver.findElement(userNameOnDashboard).getText();
    }


}
