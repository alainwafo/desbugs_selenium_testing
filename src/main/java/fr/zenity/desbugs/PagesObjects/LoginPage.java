package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LOGIN, container);
    }

    By container = By.className("");

    public void fillForm(String login, String password) {
    }

    public void validForm() {
    }
}
