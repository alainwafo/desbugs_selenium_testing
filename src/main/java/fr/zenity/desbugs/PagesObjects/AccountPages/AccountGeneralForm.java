package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountGeneralForm extends AccountPage {

    public AccountGeneralForm() {
        super();
        init(DesbugsPage.ACCOUNT_GENERAL, container);
    }

    By container = By.className("MuiGrid-container");

    By avatarContainer = By.cssSelector("div.MuiCardContent-root > div.MuiAvatar-root");
    By userDataContainer = By.cssSelector("div.MuiCardContent-root > h5.MuiTypography-root");
    By emailContainer = By.cssSelector("div.MuiCardContent-root > h6.MuiTypography-root");

    By deleteAvatarButton = By.cssSelector("div.MuiCardActions-root > button");

    By firstnameInput = By.id("newFirstname");
    By lastnameInput = By.id("newLastname");
    By usernameInput = By.id("newUsername");
    By phoneInput = By.id("newPhone");

    public void getAvatar(){
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
