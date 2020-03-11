package fr.zenity.desbugs.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;


import fr.zenity.desbugs.driverManager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeClass
    public static void init_webDriver( ){
        WebDriverManager.initWebDriver();
        driver = WebDriverManager.getWebDriver();
    }

    @AfterClass(alwaysRun = true)
    private static void tearDown(){
        WebDriverManager.getWebDriver().quit();
    }

}
