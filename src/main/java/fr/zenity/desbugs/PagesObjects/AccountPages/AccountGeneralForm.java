package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountGeneralForm extends AccountPage {

    public AccountGeneralForm() {
        super();
        init(DesbugsPage.ACCOUNT_GENERAL, container);
    }

    @FindBy(className = "MuiGrid-container")
    private WebElement container;

    @FindBy(css = "div.MuiCardContent-root > div.MuiAvatar-root")
    private WebElement avatarContainer;

    @FindBy(css = "div.MuiCardContent-root > h5.MuiTypography-root")
    private WebElement  userDataContainer;

    @FindBy(css = "div.MuiCardContent-root > h6.MuiTypography-root")
    private WebElement  emailContainer;

    @FindBy(css = "div.MuiCardActions-root > button")
    private WebElement  deleteAvatarButton;

    @FindBy(id = "newFirstname")
    private WebElement  firstnameInput;

    @FindBy(id = "newLastname")
    private WebElement  lastnameInput;

    @FindBy(id = "newUsername")
    private WebElement  usernameInput;

    @FindBy(id = "newPhone")
    private WebElement  phoneInput;

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
