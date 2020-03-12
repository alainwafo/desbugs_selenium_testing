package fr.zenity.desbugs.PagesObjects.RegisterPages;

import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    @FindBy(className = "MuiGrid-container")
    private WebElement container ;

    //user register form
    HunterRegisterForm hunterForm;
    @FindBy(id = "scrollable-auto-tab-0")
    private WebElement  hunterSeletor ;

    //entreprise register form
    EntrepriseRegisterForm entrepriseForm;
    @FindBy(id = "scrollable-auto-tab-1")
    private WebElement  entrepriseSeletor ;

    @FindBy(className = "button.MuiButton-root[type=\"submit\"]")
    private WebElement  submitButton ;

    public void selectHunterForm(){
        click(hunterSeletor);
        hunterForm = new HunterRegisterForm(driver);
        entrepriseForm = null;
    }

    public void selectEntrepriseForm(){
        click(entrepriseSeletor);
        entrepriseForm = new EntrepriseRegisterForm();
        hunterForm = null;
    }

    public void submitForm(){
        click(submitButton);
    }
}
