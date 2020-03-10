package fr.zenity.desbugs.PagesObjects.AccountPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends Page {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    By container = By.className("jss2");

    By generalSeletor = By.cssSelector("a.MuiButtonBase-root[href=\"" + DesbugsPage.ACCOUNT_GENERAL + "\"]");

    By identifierSeletor = By.cssSelector("a.MuiButtonBase-root[href=\"" + DesbugsPage.ACCOUNT_IDENTIFY + "\"]");

    By securitySeletor = By.cssSelector("a.MuiButtonBase-root[href=\"" + DesbugsPage.ACCOUNT_SECURITY + "\"]");

    By submitButton = By.className("selection.jss1183 > button[type=\"submit\"]");

    public void selectGeneralForm(){
        click(generalSeletor);
    }

    public void selectIdentifyForm(){
        click(identifierSeletor);
    }

    public void selectSecurityForm(){
        click(securitySeletor);
    }

    public void submitForm(){
        click(submitButton);
    }
}
