package fr.zenity.desbugs.PagesObjects.RegisterPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HunterRegisterForm extends Page {

    public HunterRegisterForm(WebDriver driver) {
        super(driver);
        waitVisibility(container);
    }

    By container = By.className("scrollable-auto-tabpanel-0");
    By hunterSeletor = By.id("scrollable-auto-tab-0");
    By hunterLastnameInput = By.id("lastname");
    By hunterFirstnameInput = By.id("firstname");
    By hunterUsernameInput = By.id("username");
    By hunterEmailInput = By.id("email");
    By hunterPasswordInput = By.id("password");
    By hunterConfirmPasswordInput = By.id("confirmPassword");
    By hunterCguInput = By.id("CGU");

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
