package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewBugTypePage extends Page {

    public NewBugTypePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.NEW_BUG, container);
    }

    By container = By.className("");
}
