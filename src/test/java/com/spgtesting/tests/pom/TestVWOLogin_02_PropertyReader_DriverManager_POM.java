package com.spgtesting.tests.pom;

import com.spgtesting.driver.DriverManager;
import com.spgtesting.pages.pageObjectModel.appvwo.LoginPage;
import com.spgtesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class       TestVWOLogin_02_PropertyReader_DriverManager_POM {

    @Test
    @Owner("Supriya G ")
    @Description("Verify with invalid email,pass,error message is showing  on vwo.com.")
    public void test_negaive_vwo_login() throws Exception{

        // Driver Manager code -1
//        EdgeOptions edgeOptions=new EdgeOptions();
//        edgeOptions.addArguments("--start-maximized");
//        WebDriver driver= new EdgeDriver(edgeOptions);
        //iNSTEAD OF ABOVE CODE WE WILL USE
        DriverManager.init();

        //Page class Code - 2
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        String  error_msg=loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password")).toString();

        //Assertions -3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

        DriverManager.getDriver().quit();
    }
}
