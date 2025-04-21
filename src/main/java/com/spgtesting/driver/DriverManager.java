package com.spgtesting.driver;

import com.spgtesting.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public  static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    // Open the Browser
    public static void init(){
        //Browser - ? chrome, firefox, edge  for that we will create external file in a resources package
        String browser= PropertiesReader.readKey("browser");
        browser=browser.toLowerCase();

        switch (browser){
            case "edge":
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver=new EdgeDriver(edgeOptions);
                break;
            case  "chrome":
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");
                driver=new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--guest");
                driver=new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("Browser not found.");

        }

    }


    // Close the Browser
    public static void down(){
        driver.quit();
    }

}
