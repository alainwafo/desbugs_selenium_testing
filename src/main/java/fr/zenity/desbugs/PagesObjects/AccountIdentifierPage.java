package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountIdentifierPage extends Page {

    public AccountIdentifierPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ACCOUNT_IDENTIFY, container);
    }

    By container = By.className("");
}