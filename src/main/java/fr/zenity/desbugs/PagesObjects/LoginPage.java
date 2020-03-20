package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
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
    @FindBy(css = "div[role=\"porgressbar\"]")
    private WebElement progressbar;

    public void waitPageToBeLoad(){
        init(DesbugsPage.LOGIN, container);
    }

    public void writeUser(String user){
        writeText(userInput, user);
    }

    public void writePassword(String password){
        writeText(passwordInput, password);
    }

    public void submitForm() {
        click(submitButton);
        //wait the form to be submit
        waitLoading(progressbar);
    }

    public boolean isPageOpen() {
        return isPageOpened(DesbugsPage.LOGIN, container);
    }


}
