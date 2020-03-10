package fr.zenity.desbugs.driver;

import fr.zenity.desbugs.Enum.Browser;
import fr.zenity.desbugs.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LocalDriver implements Driver {

    private WebDriver webDriver = null;

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void closeDriver() {
        webDriver.close();
    }

    public LocalDriver(){
        webDriver = buildLocalDriver();
    }

    private WebDriver buildLocalDriver(){
        Browser browser = Config.propConfig.browser;
        System.setProperty(
                browser.getProperty(),
                browser.getPath()
        );

        return browser.toString().equals("firefox") ?
               new FirefoxDriver(FirefoxOptions()) :
               browser.toString().equals("edge") ?
               new EdgeDriver(EdgeOptions()) :
               browser.toString().equals("opera") ?
               new OperaDriver(OperaOptions()) :
               // default
               new ChromeDriver(ChromeOptions());
    }
}
