package fr.zenity.desbugs.runners;

import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.testng.CucumberOptions;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@CucumberOptions(
        features = "./src/test/resources/features",
        strict = true,
        glue = {"fr.zenity.desbugs.steps","fr/zenity/desbugs/PagesObjects"},
        tags = "@test",
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
        }
)
public class TestRunner extends BaseRunner {

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
