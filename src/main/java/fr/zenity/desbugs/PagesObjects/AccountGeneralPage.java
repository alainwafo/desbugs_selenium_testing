package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountGeneralPage extends Page {

    public AccountGeneralPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ACCOUNT_GENERAL, container);
    }

    By container = By.className("");
}
