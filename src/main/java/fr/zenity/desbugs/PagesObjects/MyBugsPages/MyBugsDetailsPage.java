package fr.zenity.desbugs.PagesObjects.MyBugsPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBugsDetailsPage extends Page {

    public MyBugsDetailsPage(WebDriver driver) {
        super();
        init(DesbugsPage.RANKING, container);
    }

    //TODO : check selectors
    @FindBy(className = "")
    private WebElement container ;

    //TODO : implement page
}
