package fr.zenity.desbugs.PagesObjects.MyBugsPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBugsPage extends Page {

    public MyBugsPage(WebDriver driver) {
        super();
        init(DesbugsPage.RANKING, container);
    }

    By container = By.className("");
}