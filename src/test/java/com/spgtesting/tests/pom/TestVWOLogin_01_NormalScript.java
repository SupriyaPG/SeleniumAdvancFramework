package com.spgtesting.tests.pom;

import com.spgtesting.pages.pageObjectModel.appvwo.DashboardPage;
import com.spgtesting.pages.pageObjectModel.appvwo.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;


public class TestVWOLogin_01_NormalScript {

    @Test
    @Owner("Supriya G ")
    @Description("Verify with invalid email,pass,error message is showing  on vwo.com.")
    public void test_negaive_vwo_login() throws Exception{

        // Driver Manager code -1
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver= new EdgeDriver(edgeOptions);

        //Page class Code - 2
        LoginPage loginPage=new LoginPage(driver);
        String  error_msg=loginPage.loginToVWOLoginInvalidCreds("admin@gmail.com","1234").toString();

        //Assertions -3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();
    }

    @Test
    @Description("Verify VWO.com with valid credentials.")
    @Owner("Supriya G")
    public void testLoginPositiveVWO(){

        WebDriver driver=new EdgeDriver();
        LoginPage loginPage=new LoginPage(driver);
        String  error_msg=loginPage.loginToVWOLoginInvalidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85").toString();
        DashboardPage dashboardPage=new DashboardPage(driver);
        String usernameLoggedIn=dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(usernameLoggedIn,"Aman");

        driver.quit();
    }
}
