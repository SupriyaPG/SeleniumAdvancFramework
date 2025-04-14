package com.spgtesting.pages.pageObjectModel.appvwo;

import com.spgtesting.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//page class
public class LoginPage {

           WebDriver driver;

        public LoginPage(WebDriver driver)
        {
            this.driver=driver;
        }

        //Step 1 - page Locators
        private By username=By.id("login-username");
        private By password=By.id("login-password");
        private By errorMessage =By.id("js-notification-box-msg");
        private By signButton=By.id("js-login-btn");

        //Step 2 - Page Actions
        public String loginToVWOLoginInvalidCreds(String user,String pwd)
        {

            driver.get("https://app.vwo.com");
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(signButton).click();

            waitHelpers.waitJVM(3000);
            //waitHelpers.checkVisibility(driver,errorMessage);
            String error_message_text=driver.findElement(errorMessage).getText();

            return  error_message_text;
        }

        public void loginToVWOLoginValidCred(String user,String pwd)
        {
            driver.get("https://app.vwo.com");
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(signButton).click();

            waitHelpers.waitJVM(3000);

        }
    }
