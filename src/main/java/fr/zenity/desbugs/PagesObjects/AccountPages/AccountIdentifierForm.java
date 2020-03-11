package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountIdentifierForm extends AccountPage {

    public AccountIdentifierForm() {
        super();
        init(DesbugsPage.ACCOUNT_IDENTIFY, container);
    }

    @FindBy(css = "div.MuiCard-root > form")
    private WebElement  container;

    @FindBy(id = "newEmail")
    private WebElement emailInput;

    @FindBy(id = "confirmEmail")
    private WebElement  confirmEmailInput;

    @FindBy(id = "password")
    private WebElement  passwordInput;

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
