package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(id = "gatsby-focus-wrapper")
    private WebElement container ;

    LandingMenuComponant menu;

    public void waitPageToBeLoad(){
        init(DesbugsPage.HOME, container);
        menu = new LandingMenuComponant();
    }
}
