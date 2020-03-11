package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LOGIN, container);
    }

    @FindBy(className = "MuiGrid-container")
    private WebElement  container ;
    @FindBy(id = "user-login")
    private WebElement  userInput ;
    @FindBy(id = "password-login")
    private WebElement  passwordInput ;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitButton ;

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
