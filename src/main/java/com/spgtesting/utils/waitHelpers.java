package com.spgtesting.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class waitHelpers {

             public static void waitJVM(int time){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static void implicitWait(WebDriver driver, int time){
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

        }

        public static void checkVisibility(WebDriver driver, By locator, int time){

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }

        public static void checkVisibility(WebDriver driver, By locator){

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }

        public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver, WebElement element){

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.textToBePresentInElement(element,"your email, password, IP address "));

        }

        public static WebElement checkVisibilityByFluentWait(WebDriver driver,By locator){

            FluentWait<WebDriver> wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
            WebElement errorMsg=wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return driver.findElement(By.className("notification-box-description"));
                }
            });
            return errorMsg;

        }

    }

