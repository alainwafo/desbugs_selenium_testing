package fr.zenity.desbugs.PagesObjects.RegisterPages;

import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HunterRegisterForm extends Page {

    public HunterRegisterForm(WebDriver driver) {
        super();
        waitVisibility(container);
    }

    @FindBy(className = "scrollable-auto-tabpanel-0")
    private WebElement container ;
    @FindBy(id = "lastname")
    private WebElement  hunterLastnameInput ;
    @FindBy(id = "firstname")
    private WebElement  hunterFirstnameInput ;
    @FindBy(id = "username")
    private WebElement  hunterUsernameInput ;
    @FindBy(id = "email")
    private WebElement  hunterEmailInput ;
    @FindBy(id = "password")
    private WebElement  hunterPasswordInput ;
    @FindBy(id = "confirmPassword")
    private WebElement  hunterConfirmPasswordInput ;
    @FindBy(id = "CGU")
    private WebElement  hunterCguInput ;

    public void writeLastname(String lastname){
        writeText(hunterLastnameInput, lastname);
    }

    public void writeFirstname(String firstname){
        writeText(hunterFirstnameInput, firstname);
    }

    public void writeUsername(String username){
        writeText(hunterUsernameInput, username);
    }

    public void writeEmail(String email){
        writeText(hunterEmailInput, email);
    }

    public void writePassword(String password){
        writeText(hunterPasswordInput, password);
    }

    public void writeConfirmPassword(String password){
        writeText(hunterConfirmPasswordInput, password);
    }

    public void selectCgu(){
        click(hunterCguInput);
    }
}
