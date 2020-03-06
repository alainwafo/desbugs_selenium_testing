package fr.zenity.desbugs.driver;

import org.openqa.selenium.WebDriver;

public class LocalDriver implements Driver {

    private final WebDriver webDriver = null;

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void closeDriver() {
        webDriver.close();
    }

}
