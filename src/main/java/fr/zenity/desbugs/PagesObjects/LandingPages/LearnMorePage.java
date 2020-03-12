package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearnMorePage extends Page {

    @FindBy(id = "gatsby-focus-wrapper")
    private WebElement container ;
}
