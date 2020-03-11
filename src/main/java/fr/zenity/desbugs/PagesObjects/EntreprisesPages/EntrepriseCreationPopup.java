package fr.zenity.desbugs.PagesObjects.EntreprisesPages;

import fr.zenity.desbugs.PagesObjects.InformationPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntrepriseCreationPopup extends InformationPopup {

    public EntrepriseCreationPopup(WebDriver driver){
        super(driver);
    }

    By emailInput = By.id("email-tester");

    public enum Button{
        CANCEL("Annuler"),
        CREATE("Créer");

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
        clickButtonWithText(Button.CREATE.get());
    }

    public void cancelForm(){
        clickButtonWithText(Button.CANCEL.get());
    }
}
