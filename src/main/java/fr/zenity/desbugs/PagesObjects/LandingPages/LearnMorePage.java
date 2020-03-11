package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearnMorePage extends Page {

    public LearnMorePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LEARN_MORE, container);
    }

    By container = By.id("gatsby-focus-wrapper");
}
