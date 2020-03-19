package fr.zenity.desbugs.runners;

import fr.zenity.desbugs.configuration.Config;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import fr.zenity.desbugs.driverManager.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeSuite
    public void init_webDriver( ){

        if(Config.propConfig.isFrontal) {
            WebDriverManager.initWebDriver();
            driver = WebDriverManager.getWebDriver();
        }
    }

    @AfterMethod
    public void cleanBrowser(){
        if(Config.propConfig.isFrontal) {
            driver.manage().deleteAllCookies();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void delete_webDriver(){
        if(Config.propConfig.isFrontal) {
            WebDriverManager.getWebDriver().quit();
        }
    }

}
