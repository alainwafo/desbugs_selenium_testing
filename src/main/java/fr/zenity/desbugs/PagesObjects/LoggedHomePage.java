package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedHomePage extends Page {

    public LoggedHomePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LOGGED_HOME, container);
    }

    By container = By.className("");
}
