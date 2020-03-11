package fr.zenity.desbugs.driver;

import fr.zenity.desbugs.Enum.Browser;
import fr.zenity.desbugs.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import static fr.zenity.desbugs.Enum.Browser.*;

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

        switch(browser){
            case FIREFOX:
                return new FirefoxDriver(firefoxOptions());
            case OPERA:
                return new OperaDriver(operaOptions());
            case EDGE:
                return new EdgeDriver(edgeOptions());
            case CHROME:
            default:
                return new ChromeDriver(chromeOptions());
        }
    }
}
