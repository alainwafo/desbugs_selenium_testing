package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "MuiContainer-root")
    private WebElement  container ;

    private By  generalSeletorBy = By.cssSelector("a.MuiButtonBase-root[href=\"" + DesbugsPage.ACCOUNT_GENERAL + "\"]");

    private By  identifierSeletorBy = By.cssSelector("a.MuiButtonBase-root[href=\"" + DesbugsPage.ACCOUNT_IDENTIFY + "\"]");

    private By  securitySeletorBy = By.cssSelector("a.MuiButtonBase-root[href=\"" + DesbugsPage.ACCOUNT_SECURITY + "\"]");

    @FindBy(className = "selection.jss1183 > button[type=\"submit\"]")
    private WebElement  submitButton ;

    public void selectGeneralForm(){
        click(driver.findElement(generalSeletorBy));
    }

    public void selectIdentifyForm(){
        click(driver.findElement(identifierSeletorBy));
    }

    public void selectSecurityForm(){
        click(driver.findElement(securitySeletorBy));
    }

    public void submitForm(){
        click(submitButton);
    }
}
