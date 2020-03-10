package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewBugPlateformTypePage extends Page {

    public NewBugPlateformTypePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.NEW_BUG, container);
    }

    By container = By.className("");
}
