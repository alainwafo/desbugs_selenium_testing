package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountGeneralForm extends AccountPage {

    public AccountGeneralForm(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ACCOUNT_GENERAL, container);
    }

    //TODO : ask for better selector
    By container = By.className("MuiGrid-container");

    By avatarContainer = By.className("jss1243");
    By userDataContainer = By.className("jss1244");
    By emailContainer = By.className("jss1245");

    By deleteAvatarButton = By.cssSelector("div.jss1246 > button");

    By firstnameInput = By.id("newFirstname");
    By lastnameInput = By.id("newLastname");
    By usernameInput = By.id("newUsername");
    By phoneInput = By.id("newPhone");

    public void getavatar(){
        readText(avatarContainer);
    }

    public void readUserName(){
        readText(userDataContainer);
    }

    public void readUserEmail(){
        readText(emailContainer);
    }

    public void deleteAvatar(){
        click(deleteAvatarButton);
    }

    public void writeFirstname(String name){
        writeText(firstnameInput, name);
    }

    public void writeLastname(String name){
        writeText(lastnameInput, name);
    }

    public void writeUsername(String name){
        writeText(usernameInput, name);
    }

    public void writePhone(String phone){
        writeText(phoneInput, phone);
    }

}
