package fr.zenity.desbugs.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import fr.zenity.desbugs.driverManager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeClass
    public static void init_webDriver( ){
        WebDriverManager.initWebDriver();
        driver = WebDriverManager.getWebDriver();
    }


    private static void tearDown(){
        WebDriverManager.getWebDriver().quit();
    }

}
