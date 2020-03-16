package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends Page {

    @FindBy(className = "MuiContainer-root")
    private WebElement container ;

    public LoggedMenuComponant menu;

    public void waitPageToBeLoad(){
        init(DesbugsPage.LOGGED_HOME, container);
        menu = new LoggedMenuComponant();
    }

    public boolean isPageOpen(){
        return isPageOpened(DesbugsPage.LOGGED_HOME, container);
    }
}
