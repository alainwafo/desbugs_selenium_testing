package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntreprisesCreatedPage extends Page {

    public EntreprisesCreatedPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ENTREPRSES_CREATED, container);
    }

    By container = By.className("");
}
