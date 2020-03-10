package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LOGIN, container);
    }

    By container = By.className("jss844");
    By userInput = By.id("user-login");
    By passwordInput = By.id("password-login");
    By submitButton = By.cssSelector("button[type=\"submit\"]");

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
