package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSecurityForm extends AccountPage {

    @FindBy(className = "MuiCard-root")
    private WebElement  container ;

    @FindBy(id = "oldPassword")
    private WebElement oldPasswordInput ;
    @FindBy(id = "newPassword")
    private WebElement  newPasswordInput ;
    @FindBy(id = "confirmPassword")
    private WebElement  confirmPasswordInput ;

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
