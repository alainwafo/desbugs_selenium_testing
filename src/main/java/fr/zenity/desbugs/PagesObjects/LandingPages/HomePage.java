package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.HOME, container);
    }

    @FindBy(id = "gatsby-focus-wrapper")
    private WebElement container ;
}
