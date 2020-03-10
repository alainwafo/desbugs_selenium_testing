package fr.zenity.desbugs.PagesObjects.RegisterPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntrepriseRegisterForm extends Page {

    public EntrepriseRegisterForm(WebDriver driver) {
        super();
        waitVisibility(container);
    }

    By container = By.className("scrollable-auto-tab-1");
    By entrepriseSocietyInput = By.id("society");
    By entreprisePhoneInput = By.id("phone-helper-text");
    By entrepriseLastnameInput = By.id("lastnameE");
    By entrepriseFirstnameInput = By.id("firstnameE");
    By entrepriseUsernameInput = By.id("usernameE");
    By entrepriseEmailInput = By.id("emailE");
    By entreprisePasswordInput = By.id("passwordE");
    By entrepriseConfirmPasswordInput = By.id("confirmPasswordE");
    By entrepriseCguInput = By.id("CGUE");

    public void writeSociety(String society){
        writeText(entrepriseSocietyInput, society);
    }

    public void writePhone(String phone){
        writeText(entreprisePhoneInput, phone);
    }

    public void writeLastname(String lastname){
        writeText(entrepriseLastnameInput, lastname);
    }

    public void writeFirstname(String firstname){
        writeText(entrepriseFirstnameInput, firstname);
    }

    public void writeUsername(String username){
        writeText(entrepriseUsernameInput, username);
    }

    public void writeEmail(String email){
        writeText(entrepriseEmailInput, email);
    }

    public void writePassword(String password){
        writeText(entreprisePasswordInput, password);
    }

    public void writeConfirmPassword(String password){
        writeText(entrepriseConfirmPasswordInput, password);
    }

    public void selectCgu(){
        click(entrepriseCguInput);
    }
}
