package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSecurityPage extends Page {

    public AccountSecurityPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ACCOUNT_SECURITY, container);
    }

    By container = By.className("");
}
