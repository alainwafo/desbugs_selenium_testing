package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSecurityForm extends AccountPage {

    public AccountSecurityForm() {
        super();
        init(DesbugsPage.ACCOUNT_SECURITY, container);
    }

    //TODO : ask for better selector
    By container = By.className("MuiCard-root");

    By oldPasswordInput = By.id("oldPassword");
    By newPasswordInput = By.id("newPassword");
    By confirmPasswordInput = By.id("confirmPassword");

    public void writeOldPassword(String oldPassword){
        writeText(oldPasswordInput, oldPassword);
    }

    public void writeNewPassword(String newPassword){
        writeText(newPasswordInput, newPassword);
    }

    public void writeNewPasswordConfirmation(String newPassword){
        writeText(confirmPasswordInput, newPassword);
    }
}
