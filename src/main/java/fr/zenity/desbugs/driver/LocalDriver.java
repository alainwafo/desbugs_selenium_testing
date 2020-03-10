package fr.zenity.desbugs.driver;

import fr.zenity.desbugs.configuration.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalDriver implements Driver {

    public final WebDriver webDriver = null;

    @Override
    public WebDriver getWebDriver() {
        if (webDriver == null) {
            switch (PropertiesConfig.getInstance().browser){
                case CHROME:
                    return new ChromeDriver(chromeOptions());
                default :
                    return new ChromeDriver();
            }
        }
        return webDriver;
    }

    @Override
    public void closeDriver() {
        webDriver.close();
    }

}
