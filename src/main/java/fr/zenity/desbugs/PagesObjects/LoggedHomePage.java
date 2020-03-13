package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.UsersPages.LandingMenuComponant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends Page {

    @FindBy(className = "MuiContainer-root")
    private WebElement container ;

    public void waitPageToBeLoad(){
        init(DesbugsPage.LOGGED_HOME, container);
    }
}
