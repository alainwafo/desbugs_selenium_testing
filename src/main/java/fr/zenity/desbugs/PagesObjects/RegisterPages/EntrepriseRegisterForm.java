package fr.zenity.desbugs.PagesObjects.RegisterPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntrepriseRegisterForm extends Page {

    public EntrepriseRegisterForm(WebDriver driver) {
        super(driver);
        waitVisibility(container);
    }

    @FindBy(className = "scrollable-auto-tab-1")
    private WebElement container ;
    @FindBy(id = "society")
    private WebElement  entrepriseSocietyInput ;
    @FindBy(id = "phone-helper-text")
    private WebElement  entreprisePhoneInput ;
    @FindBy(id = "lastnameE")
    private WebElement  entrepriseLastnameInput ;
    @FindBy(id = "firstnameE")
    private WebElement  entrepriseFirstnameInput ;
    @FindBy(id = "usernameE")
    private WebElement  entrepriseUsernameInput ;
    @FindBy(id = "emailE")
    private WebElement  entrepriseEmailInput ;
    @FindBy(id = "passwordE")
    private WebElement  entreprisePasswordInput ;
    @FindBy(id = "confirmPasswordE")
    private WebElement  entrepriseConfirmPasswordInput ;
    @FindBy(id = "CGUE")
    private WebElement  entrepriseCguInput ;

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
