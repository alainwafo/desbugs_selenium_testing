package fr.zenity.desbugs.PagesObjects.RegisterPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super();
        init(DesbugsPage.REGISTER, container);
        hunterForm = new HunterRegisterForm(driver);
    }

    By container = By.className("MuiGrid-container");

    //user register form
    HunterRegisterForm hunterForm;
    By hunterSeletor = By.id("scrollable-auto-tab-0");

    //entreprise register form
    EntrepriseRegisterForm entrepriseForm;
    By entrepriseSeletor = By.id("scrollable-auto-tab-1");

    By submitButton = By.className("button.MuiButton-root[type=\"submit\"]");

    public void selectHunterForm(){
        click(hunterSeletor);
        hunterForm = new HunterRegisterForm(driver);
        entrepriseForm = null;
    }

    public void selectEntrepriseForm(){
        click(entrepriseSeletor);
        entrepriseForm = new EntrepriseRegisterForm(driver);
        hunterForm = null;
    }

    public void submitForm(){
        click(submitButton);
    }
}
