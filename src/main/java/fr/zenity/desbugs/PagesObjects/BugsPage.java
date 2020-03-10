package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugsPage extends Page {

    public BugsPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.BUGS, container);
    }

    By container = By.className("jss2386");
}
