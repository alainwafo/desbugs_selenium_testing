package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountIdentifierForm extends AccountPage {

    public AccountIdentifierForm() {
        super();
        init(DesbugsPage.ACCOUNT_IDENTIFY, container);
    }

    //TODO : ask for better selector
    By container = By.cssSelector("div.MuiCard-root > form");

    By emailInput = By.id("newEmail");
    By confirmEmailInput = By.id("confirmEmail");
    By passwordInput = By.id("password");

    public void writeFirstname(String email){
        writeText(emailInput, email);
    }

    public void writeEmailConfirmation(String email){
        writeText(confirmEmailInput, email);
    }

    public void writePassword(String password){
        writeText(passwordInput, password);
    }
}
