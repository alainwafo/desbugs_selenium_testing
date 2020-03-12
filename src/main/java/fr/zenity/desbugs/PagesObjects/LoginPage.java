package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    private static By container = By.className("");

    @FindBy(id="test")
    private WebElement test;

    public void navigateToLoginPage(){
        driver.get(DesbugsPage.HOME.getUrl());
    }


    public void fillForm(String login, String password) {
    }

    public void validForm() {
    }
}
