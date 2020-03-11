package fr.zenity.desbugs.PagesObjects.MyBugsPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBugsFilesPage extends Page {

    public MyBugsFilesPage(WebDriver driver) {
        super();
        init(DesbugsPage.RANKING, container);
    }

    //TODO : check selectors
    By container = By.className("");

    //TODO : implement page
}
