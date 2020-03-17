package fr.zenity.desbugs.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;


import fr.zenity.desbugs.driverManager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseRunner extends AbstractTestNGCucumberTests {

    private static WebDriverManager driver;

    @BeforeSuite
    public void init_webDriver( ){
        driver.getInstance().initWebDriver();
    }

    @AfterMethod
    public void cleanBrowser(){
        driver.getInstance().getWebDriver().manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void delete_webDriver(){
        WebDriverManager.getWebDriver().quit();
    }
}
