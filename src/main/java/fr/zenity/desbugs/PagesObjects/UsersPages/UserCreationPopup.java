package fr.zenity.desbugs.PagesObjects.UsersPages;

import fr.zenity.desbugs.PagesObjects.InformationPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserCreationPopup extends InformationPopup {

    public UserCreationPopup(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "email-tester")
    private WebElement  emailInput ;

    public enum Button{
        CANCEL("Annuler"),
        VALID("Valider");

        private String buttonText;

        private String get(){ return buttonText; }

        private Button(String text){
            this.buttonText = text;
        }
    }

    public void writeEmail(String email){
        writeText(emailInput, email);
    }

    public void submitForm(){
        clickButtonWithText(Button.VALID.get());
    }

    public void cancelForm(){
        clickButtonWithText(Button.CANCEL.get());
    }
}
