package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends Page {

    public LoggedHomePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LOGGED_HOME, container);
    }

    @FindBy(className = "MuiGrid-container")
    private WebElement container ;
}
