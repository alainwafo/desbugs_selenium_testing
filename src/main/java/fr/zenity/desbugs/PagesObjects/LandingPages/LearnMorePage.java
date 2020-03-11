package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearnMorePage extends Page {

    public LearnMorePage(WebDriver driver) {
        super();
        init(DesbugsPage.RANKING, container);
    }

    @FindBy(id = "gatsby-focus-wrapper")
    private WebElement container ;
}
