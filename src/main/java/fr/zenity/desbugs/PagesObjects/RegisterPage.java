package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.REGISTER, container);
    }

    By container = By.className("");
}