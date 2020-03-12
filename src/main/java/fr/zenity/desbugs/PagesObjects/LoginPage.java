package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.UsersPages.UsersPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(className = "MuiGrid-container")
    private WebElement  container ;
    @FindBy(id = "user-login")
    private WebElement  userInput ;
    @FindBy(id = "password-login")
    private WebElement  passwordInput ;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitButton ;

    public void waitPageToBeLoad(){
        init(DesbugsPage.LOGIN, container);
    }

    public void navigateToLoginPage() {
        driver.navigate().to(DesbugsPage.LOGIN.getUrl());
    }

    public void writeUser(String user){
        writeText(userInput, user);
    }

    public void writePassword(String password){
        writeText(passwordInput, password);
    }

    public void submitForm(){
        click(submitButton);
    }
}
