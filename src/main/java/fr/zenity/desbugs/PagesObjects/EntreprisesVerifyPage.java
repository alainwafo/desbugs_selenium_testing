package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntreprisesVerifyPage extends Page {

    public EntreprisesVerifyPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ENTREPRISES_VERIFY, container);
    }

    By container = By.className("");
}
